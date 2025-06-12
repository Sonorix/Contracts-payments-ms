package com.contracts.ms.controller;

import com.contracts.ms.dao.PaymentDao;
import com.contracts.ms.model.PaymentDto;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.UUID;

@WebServlet(name = "PaymentController", urlPatterns = {"/payment"})
public class PaymentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try (JsonReader reader = Json.createReader(request.getInputStream())) {
            JsonObject data = reader.readObject();

            UUID idContrato = UUID.fromString(data.getString("idContrato"));
            String metodoPago = data.getString("metodoPago"); // 'Tarjeta', 'PayPal', etc.
            BigDecimal monto = new BigDecimal(data.getJsonNumber("monto").toString());
            String estado = data.containsKey("estado") ? data.getString("estado") : "Pendiente";

            PaymentDto payment = new PaymentDto(idContrato, metodoPago, monto, estado);
            new PaymentDao().createPayment(payment);

            JsonObject json = Json.createObjectBuilder()
                    .add("message", "Pago registrado correctamente")
                    .build();

            try (PrintWriter out = response.getWriter()) {
                out.print(json.toString());
            }

        } catch (Exception e) {
            response.setStatus(400);
            JsonObject error = Json.createObjectBuilder()
                    .add("message", "Error al procesar el pago: " + e.getMessage())
                    .build();

            try (PrintWriter out = response.getWriter()) {
                out.print(error.toString());
            }
        }
    }
}
