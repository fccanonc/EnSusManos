/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apiensusmanos.modelo.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Camilo Cañon
 */
@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_usuarios")
    private int id_usuarios;

    @Column(name = "nombre_usuarios")
    private String nombre;

    @Column(name = "apellido_usuarios")
    private String apellido;

    @Column(name = "barrio_usuarios")
    private String barrio;

    @Column(name = "usu_usuarios")
    private String usuario;

    @Column(name = "pass_usuarios")
    private String password;

    @OneToMany(mappedBy = "usuarios")
    private List<Puntos> puntos;

    @OneToMany(mappedBy = "usuariosEventos")
    private List<Eventos> eventos;

    public Usuarios() {

    }

    public int getId_usuarios() {
        return id_usuarios;
    }

    public void setId_usuarios(int id_usuarios) {
        this.id_usuarios = id_usuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Puntos> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<Puntos> puntos) {
        this.puntos = puntos;
    }

    public List<Eventos> getEventos() {
        return eventos;
    }

    public void setEventos(List<Eventos> eventos) {
        this.eventos = eventos;
    }

}
