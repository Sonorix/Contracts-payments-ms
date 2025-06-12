package com.contracts.ms.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

public class ContractsDto {
    private UUID idContrato;
    private UUID idEvento;
    private UUID idMusico;
    private Timestamp fechaContrato;
    private BigDecimal pagoTotal;
    private String estado;

    public ContractsDto(UUID idEvento, UUID idMusico, BigDecimal pagoTotal, String estado) {
        this.idEvento = idEvento;
        this.idMusico = idMusico;
        this.pagoTotal = pagoTotal;
        this.estado = estado;
    }
    
    public ContractsDto(UUID idContrato, UUID idEvento, UUID idMusico, BigDecimal pagoTotal, String estado) {
        this.idContrato = idContrato;
        this.idEvento = idEvento;
        this.idMusico = idMusico;
        this.pagoTotal = pagoTotal;
        this.estado = estado;
    }
    //Sobre carga de constructor para crear el dto del id propio del contrato

    public UUID getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(UUID idContrato) {
        this.idContrato = idContrato;
    }

    public UUID getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(UUID idEvento) {
        this.idEvento = idEvento;
    }

    public UUID getIdMusico() {
        return idMusico;
    }

    public void setIdMusico(UUID idMusico) {
        this.idMusico = idMusico;
    }

    public Timestamp getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Timestamp fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public BigDecimal getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(BigDecimal pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}   