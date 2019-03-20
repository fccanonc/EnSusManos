package com.mycompany.apiensusmanos.controller;

import com.mycompany.apiensusmanos.modelo.dao.PuntosRepositorio;
import com.mycompany.apiensusmanos.modelo.entity.Eventos;
import com.mycompany.apiensusmanos.modelo.entity.Puntos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuntosServicio {

    @Autowired
    private PuntosRepositorio puntosRepositorio;

    public PuntosServicio() {
    }

    public List<Puntos> getPuntosdescripcion(String descripcion) {
        List<Puntos> puntos = puntosRepositorio.getPuntosdescripcion(descripcion);
        return puntos;

    }

    public Puntos getPuntosID(int id) {
        return puntosRepositorio.getPuntosID(id);
    }

    public String crearPuntos(Puntos puntos) {
        long puntosId = puntosRepositorio.crearPuntos(puntos);
        return "Puntos creados con ID:" + puntosId;
    }

}
