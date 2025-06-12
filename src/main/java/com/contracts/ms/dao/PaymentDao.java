package com.contracts.ms.dao;

import com.contracts.ms.model.PaymentDto;
import com.contracts.ms.model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDao {

    public void createPayment(PaymentDto payment) {
        String sql = "INSERT INTO pagos (id_contrato, metodo_pago, monto, estado, fecha_pago) " +
                     "VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";

        try (Connection conn = new Database().getConn();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setObject(1, payment.getIdContrato()); // UUID
            stmt.setString(2, payment.getMetodoPago()); // 'Tarjeta', 'PayPal', etc.
            stmt.setBigDecimal(3, payment.getMonto());  // DECIMAL
            stmt.setString(4, payment.getEstado());     // 'Pendiente', 'Confirmado', etc.

            int affected = stmt.executeUpdate();
            if (affected == 0) {
                throw new Exception("No se pudo insertar el pago.");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al crear el pago: " + e.getMessage(), e);
        }
    }

    // Puedes agregar métodos como confirmPayment, listarPagosPorContrato, etc.
}
