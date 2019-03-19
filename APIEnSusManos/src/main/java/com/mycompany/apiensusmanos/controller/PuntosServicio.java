/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apiensusmanos.controller;

import com.mycompany.apiensusmanos.modelo.dao.EventosRepositorio;
import com.mycompany.apiensusmanos.modelo.dao.PuntosRepositorio;
import com.mycompany.apiensusmanos.modelo.entity.Eventos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Camilo Cañon
 */
public class PuntosServicio {

    @Autowired
    private PuntosRepositorio puntosRepositorio;

    public PuntosServicio() {
    }

    public List<Eventos> getAllPuntos() {
        return puntosRepositorio.getAllPuntos();
    }
}
