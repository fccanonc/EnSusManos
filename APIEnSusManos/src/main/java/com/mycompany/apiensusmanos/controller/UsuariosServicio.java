package com.mycompany.apiensusmanos.controller;

import com.mycompany.apiensusmanos.modelo.dao.UsuariosRepositorio;
import com.mycompany.apiensusmanos.modelo.entity.Usuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServicio {

    @Autowired
    private UsuariosRepositorio usuariosRepositorio;

    public UsuariosServicio() {
    }

    public List<Usuarios> getAllUsuarios() {
        return usuariosRepositorio.getAllCiudadanos();
    }
}

