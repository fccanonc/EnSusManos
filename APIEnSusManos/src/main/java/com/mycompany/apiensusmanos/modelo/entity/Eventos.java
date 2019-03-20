package com.mycompany.apiensusmanos.modelo.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "eventos")
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_eventos")
    private int id_eventos;

    @Column(name = "nombre_eventos")
    private String nombre;

    @Column(name = "descripcion_eventos")
    private String descripcion;

    @Column(name = "fecha_eventos")
    private Date fecha;

    @Column(name = "hora_eventos")
    private String hora;

    @OneToMany(mappedBy = "eventos")
    private List<Puntos> puntos;

    @ManyToOne
    @JoinColumn(name = "Id_usuarios_eventos")
    private Usuarios usuariosEventos;

    public Eventos() {

    }

    public int getId_eventos() {
        return id_eventos;
    }

    public void setId_eventos(int id_eventos) {
        this.id_eventos = id_eventos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public List<Puntos> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<Puntos> puntos) {
        this.puntos = puntos;
    }

    public Usuarios getUsuariosEventos() {
        return usuariosEventos;
    }

    public void setUsuariosEventos(Usuarios usuariosEventos) {
        this.usuariosEventos = usuariosEventos;
    }

}
