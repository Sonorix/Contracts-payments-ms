/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contracts.ms.dao;

import com.contracts.ms.model.Database;
import com.contracts.ms.model.EventosDto;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Maria Jose
 */
public class EventosDao {

    public void crearEvento(EventosDto evento) {
        String sql = "INSERT INTO eventos ( id_cliente, nombre_evento, fecha_evento, ubicacion, estado) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = new Database().getConn();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setObject(1, evento.getIdCliente());
            stmt.setString(2, evento.getNombreEvento());
            stmt.setTimestamp(3, evento.getFechaEvento());
            stmt.setString(4, evento.getUbicacion());
            stmt.setString(5, evento.getEstado());

            int filas = stmt.executeUpdate();
            if (filas == 0) {
                throw new Exception("No se pudo insertar el evento.");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al crear el evento: " + e.getMessage(), e);
        }
    }
}
