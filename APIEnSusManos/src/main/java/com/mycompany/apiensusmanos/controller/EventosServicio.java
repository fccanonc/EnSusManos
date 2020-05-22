package com.mycompany.apiensusmanos.controller;

import com.mycompany.apiensusmanos.modelo.dao.EventosRepositorio;
import com.mycompany.apiensusmanos.modelo.entity.Eventos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventosServicio {

    @Autowired
    private EventosRepositorio eventosRepositorio;

    public EventosServicio() {
    }

    public List<Eventos> getEventosBynombreydescripcion(String nombre, String descripcion) {
        List<Eventos> eventos = eventosRepositorio.getEventosBynombreydescripcion(nombre, descripcion);
        return eventos;

    }

    public Eventos getEventoID(int id) {
        return eventosRepositorio.getEventoID(id);
    }

    public String crearEventos(Eventos eventos) {
        long eventosId = eventosRepositorio.crearEventos(eventos);
        return "Evento creado con ID:" + eventosId;
    }
    
    public Eventos getCiudadanoByEventos(int id){
        return eventosRepositorio.getCiudadanoByEventos(id);
    }
}
