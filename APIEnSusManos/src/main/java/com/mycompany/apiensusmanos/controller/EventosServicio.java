/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apiensusmanos.controller;

import com.mycompany.apiensusmanos.modelo.dao.EventosRepositorio;
import com.mycompany.apiensusmanos.modelo.entity.Eventos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Camilo Cañon
 */
public class EventosServicio {

    @Autowired
    private EventosRepositorio eventosRepositorio;

    public EventosServicio() {
    }

    public List<Eventos> getAllEvent() {
        return eventosRepositorio.getAllEventos();
    }

}
