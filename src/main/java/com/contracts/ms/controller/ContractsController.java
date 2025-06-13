package com.contracts.ms.controller;

import com.contracts.ms.dao.ContractsDao;
import com.contracts.ms.model.ContractsDto;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.UUID;

@WebServlet(name = "ContractController", urlPatterns = {"/contract"})
public class ContractsController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try (JsonReader reader = Json.createReader(request.getInputStream())) {
            JsonObject data = reader.readObject();
            UUID idEvento = UUID.fromString(data.getString("idEvento"));
            UUID idMusico = UUID.fromString(data.getString("idMusico"));
            BigDecimal pagoTotal = new BigDecimal(data.getJsonNumber("pagoTotal").toString());
            //Tiene mejor presicion para hacer calculos.
            String estado = data.containsKey("estado") ? data.getString("estado") : "Pendiente";

            ContractsDto contract = new ContractsDto(idEvento, idMusico, pagoTotal, estado);//Añadir dto del usuario
            new ContractsDao().createContract(contract);

            JsonObject json = Json.createObjectBuilder()
                    .add("message", "Contrato creado correctamente")
                    .build();

            try (PrintWriter out = response.getWriter()) {
                out.print(json.toString());
            }

        } catch (Exception e) {
            response.setStatus(400);
            JsonObject error = Json.createObjectBuilder()
                    .add("message", "Error al crear contrato: " + e.getMessage())
                    .build();

            try (PrintWriter out = response.getWriter()) {
                out.print(error.toString());
            }
        }
    }
}
