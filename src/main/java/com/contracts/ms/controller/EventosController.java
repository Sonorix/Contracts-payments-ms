/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.contracts.ms.controller;

import com.contracts.ms.dao.EventosDao;
import com.contracts.ms.model.EventosDto;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.UUID;

/**
 *
 * @author Maria Jose
 */
@WebServlet(name = "EventosController", urlPatterns = {"/eventos"})
public class EventosController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try (JsonReader reader = Json.createReader(request.getInputStream())) {
            JsonObject data = reader.readObject();

            UUID idCliente = UUID.fromString(data.getString("idCliente"));
            String nombreEvento = data.getString("nombreEvento");
            Timestamp fechaEvento = Timestamp.valueOf(data.getString("fechaEvento")); // formato: "2025-06-13 18:00:00"
            String ubicacion = data.getString("ubicacion");
            String estado = data.containsKey("estado") ? data.getString("estado") : "Pendiente";

            EventosDto evento = new EventosDto(idCliente, nombreEvento, fechaEvento, ubicacion, estado);
            new EventosDao().crearEvento(evento);

            JsonObject json = Json.createObjectBuilder()
                    .add("message", "Evento creado correctamente")
                    .build();

            try (PrintWriter out = response.getWriter()) {
                out.print(json.toString());
            }

        } catch (Exception e) {
            response.setStatus(400);
            JsonObject error = Json.createObjectBuilder()
                    .add("message", "Error al crear evento: " + e.getMessage())
                    .build();

            try (PrintWriter out = response.getWriter()) {
                out.print(error.toString());
            }
        }
    }
}