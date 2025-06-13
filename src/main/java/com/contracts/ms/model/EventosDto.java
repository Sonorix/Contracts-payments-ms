/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contracts.ms.model;

import java.sql.Timestamp;
import java.util.UUID;

/**
 *
 * @author Maria Jose
 */
public class EventosDto {
    private UUID idEvento;
    private UUID idCliente;
    private String nombreEvento;
    private Timestamp fechaEvento;
    private String ubicacion;
    private String estado;

    public EventosDto(UUID idCliente, String nombreEvento, Timestamp fechaEvento, String ubicacion, String estado) {
        this.idCliente = idCliente;
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    public EventosDto(UUID idEvento, UUID idCliente, String nombreEvento, Timestamp fechaEvento, String ubicacion, String estado) {
        this.idEvento = idEvento;
        this.idCliente = idCliente;
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    public UUID getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(UUID idEvento) {
        this.idEvento = idEvento;
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public Timestamp getFechaEvento() {
        return fechaEvento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public void setFechaEvento(Timestamp fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
