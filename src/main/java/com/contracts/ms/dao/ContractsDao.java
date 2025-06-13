package com.contracts.ms.dao;

import com.contracts.ms.model.ContractsDto;
import com.contracts.ms.model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

public class ContractsDao {

    public void createContract(ContractsDto contract) {
        String sql = "INSERT INTO contratos (id_evento, id_musico, pago_total, estado, fecha_contrato) " +
                     "VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";

        try (Connection conn = new Database().getConn();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, contract.getIdEvento());       // UUID
            stmt.setObject(2, contract.getIdMusico());       // UUID
            stmt.setBigDecimal(3, contract.getPagoTotal());  // DECIMAL
            stmt.setString(4, contract.getEstado());         // 'Pendiente', 'Pagado', 'Cancelado'

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new Exception("No se pudo insertar el contrato.");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al crear el contrato: " + e.getMessage(), e);
        }
    }
}
