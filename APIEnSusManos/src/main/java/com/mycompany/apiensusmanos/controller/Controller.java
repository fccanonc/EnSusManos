package com.mycompany.apiensusmanos.controller;

import com.mycompany.apiensusmanos.modelo.entity.Eventos;
import com.mycompany.apiensusmanos.modelo.entity.Usuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class Controller {

    @Autowired
    private EventosServicio eventosServicio;

    @RequestMapping(value = "/Eventos/", method = RequestMethod.GET)
    public ResponseEntity<List<Eventos>> obtenerEventos() {
        List<Eventos> Eventos = eventosServicio.getAllEvent();
        return new ResponseEntity<>(Eventos, HttpStatus.OK);
    }

    @Autowired
    private PuntosServicio puntosServicio;

    @RequestMapping(value = "/Puntos/", method = RequestMethod.GET)
    public ResponseEntity<List<Eventos>> obtenerPuntos() {
        List<Eventos> Puntos = puntosServicio.getAllPuntos();
        return new ResponseEntity<>(Puntos, HttpStatus.OK);
    }

    @Autowired
    private UsuariosServicio usuariosServicio;

    @RequestMapping(value = "/Usuarios/", method = RequestMethod.GET)
    public ResponseEntity<List<Usuarios>> obtenerUsuarios() {
        List<Usuarios> Usuarios = usuariosServicio.getAllUsuarios();
        return new ResponseEntity<>(Usuarios, HttpStatus.OK);
    }
}
