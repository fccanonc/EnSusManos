package com.mycompany.apiensusmanos.controller;

import com.mycompany.apiensusmanos.modelo.dao.PuntosRepositorio;
import com.mycompany.apiensusmanos.modelo.entity.Eventos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuntosServicio {

    @Autowired
    private PuntosRepositorio puntosRepositorio;

    public PuntosServicio() {
    }

    public List<Eventos> getAllPuntos() {
        return puntosRepositorio.getAllPuntos();
    }
}
