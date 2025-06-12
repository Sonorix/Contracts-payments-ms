package com.contracts.ms.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

public class PaymentDto {
    private UUID idPago;
    private UUID idContrato;
    private String metodoPago; // 'Tarjeta', 'PayPal', 'Transferencia'
    private BigDecimal monto;
    private String estado; // 'Pendiente', 'Confirmado', 'Fallido'
    private Timestamp fechaPago;

    public PaymentDto(UUID idContrato, String metodoPago, BigDecimal monto, String estado) {
        this.idContrato = idContrato;
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.estado = estado;
    }

    public UUID getIdPago() {
        return idPago;
    }

    public void setIdPago(UUID idPago) {
        this.idPago = idPago;
    }

    public UUID getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(UUID idContrato) {
        this.idContrato = idContrato;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Timestamp fechaPago) {
        this.fechaPago = fechaPago;
    }
}