/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apiensusmanos.modelo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "puntos")
public class Puntos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_puntos")
    private int id_puntos;

    @Column(name = "descripcion_puntos")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "Id_usuarios_puntos")
    private Usuarios usuarios;

    @ManyToOne
    @JoinColumn(name = "Id_eventos_puntos")
    private Eventos eventos;

    public Puntos() {

    }

    public int getId_puntos() {
        return id_puntos;
    }

    public void setId_puntos(int id_puntos) {
        this.id_puntos = id_puntos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Eventos getEventos() {
        return eventos;
    }

    public void setEventos(Eventos eventos) {
        this.eventos = eventos;
    }

}
