package com.mycompany.apiensusmanos.controller;

import com.mycompany.apiensusmanos.modelo.dao.UsuariosRepositorio;
import com.mycompany.apiensusmanos.modelo.entity.Eventos;
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

    public List<Usuarios> getUsuariosnombreybarrio(String nombre, String barrio) {
        List<Usuarios> usuarios = usuariosRepositorio.getUsuariosnombreybarrio(nombre, barrio);
        return usuarios;

    }

    public Usuarios getUsuariosID(int id) {
        return usuariosRepositorio.getUsuariosID(id);
    }

    public List<Usuarios> getCiudadanosOrdenado() {
        List<Usuarios> usuarios = usuariosRepositorio.getCiudadanosOrdenado();
        return usuarios;

    }

    public List<Usuarios> getAllCuidadanos() {
        return usuariosRepositorio.getAllCiudadanos();
    }

    public String crearUsuario(Usuarios usuarios) {
        long usuarioId = usuariosRepositorio.crearUsuario(usuarios);
        return "Usuario creado con ID:" + usuarioId;
    }

   public List<Usuarios> Autenticacion(String usuario, String password){
       List<Usuarios> usuarios = usuariosRepositorio.Autenticacion(usuario, password);
       
       return usuarios;
   }
}
