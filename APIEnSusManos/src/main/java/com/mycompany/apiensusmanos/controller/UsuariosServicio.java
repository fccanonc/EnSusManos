/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apiensusmanos.controller;

import com.mycompany.apiensusmanos.modelo.dao.UsuariosRepositorio;
import com.mycompany.apiensusmanos.modelo.entity.Eventos;
import com.mycompany.apiensusmanos.modelo.entity.Usuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Camilo Cañon
 */
public class UsuariosServicio {

    @Autowired
    private UsuariosRepositorio usuariosRepositorio;

    public UsuariosServicio() {
    }

    public List<Usuarios> getAllUsuarios() {
        return usuariosRepositorio.getAllCiudadanos();
    }
}

