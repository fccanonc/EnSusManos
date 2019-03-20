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

    public List<Eventos> getAllEvent() {
        return eventosRepositorio.getAllEventos();
    }

}
