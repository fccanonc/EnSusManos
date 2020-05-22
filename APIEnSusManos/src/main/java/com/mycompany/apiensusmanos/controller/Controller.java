package com.mycompany.apiensusmanos.controller;

import com.mycompany.apiensusmanos.modelo.entity.Eventos;
import com.mycompany.apiensusmanos.modelo.entity.Puntos;
import com.mycompany.apiensusmanos.modelo.entity.Usuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Controller {

    @Autowired
    private EventosServicio eventosServicio;

    @RequestMapping(value = "/eventos/", method = RequestMethod.GET)
    public ResponseEntity<List<Eventos>> obtenerEvento(@RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "descripcion", required = false) String descripcion) {

        List<Eventos> eventos = eventosServicio.getEventosBynombreydescripcion(nombre, descripcion);
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @RequestMapping(value = "/eventos/{id_eventos}", method = RequestMethod.GET)
    public ResponseEntity<Eventos> obtenerEventoPorID(@PathVariable("id_eventos") int id) {
        Eventos evento = eventosServicio.getEventoID(id);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }

    @RequestMapping(value = "/creacionEventos/", method = RequestMethod.POST, consumes
            = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearEventos(@RequestBody Eventos eventos) {
        String resultado = "Se creo evento con ID: " + eventosServicio.crearEventos(eventos);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }

    @Autowired
    private PuntosServicio puntosServicio;

    @RequestMapping(value = "/puntos/", method = RequestMethod.GET)
    public ResponseEntity<List<Puntos>> obtenerPuntos(@RequestParam(value = "descripcion", required = false) String descripcion) {
        List<Puntos> puntos = puntosServicio.getPuntosdescripcion(descripcion);
        return new ResponseEntity<>(puntos, HttpStatus.OK);
    }

    @RequestMapping(value = "/puntos/{id_puntos}", method = RequestMethod.GET)
    public ResponseEntity<Puntos> obtenerPuntosPorID(@PathVariable("id_puntos") int id) {
        Puntos punto = puntosServicio.getPuntosID(id);
        return new ResponseEntity<>(punto, HttpStatus.OK);
    }

    @RequestMapping(value = "/creacionPuntos/", method = RequestMethod.POST, consumes
            = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearPuntos(@RequestBody Puntos puntos) {
        String resultado = "Se creo puntos con ID: " + puntosServicio.crearPuntos(puntos);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }

    @Autowired
    private UsuariosServicio usuariosServicio;

    @RequestMapping(value = "/usuarios/", method = RequestMethod.GET)
    public ResponseEntity<List<Usuarios>> obtenerUsuarios(@RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "barrio", required = false) String barrio) {
        List<Usuarios> usuarios = usuariosServicio.getUsuariosnombreybarrio(nombre, barrio);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuarios/ord", method = RequestMethod.GET)
    public ResponseEntity<List<Usuarios>> obtenerUsuariosOrd(@RequestParam(value = "nombre", required = false) String nombre
    ) {
        List<Usuarios> usuarios = usuariosServicio.getCiudadanosOrdenado();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuarios/{id_usuarios}", method = RequestMethod.GET)
    public ResponseEntity<Usuarios> obtenerUsuarioPorID(@PathVariable("id_usuarios") int id) {
        Usuarios usuario = usuariosServicio.getUsuariosID(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @RequestMapping(value = "/autenticacion/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuarios>> ObtenerLogin(@RequestParam(value = "usuario", required = true) String user,
            @RequestParam(value = "password", required = true) String pass) {
        List<Usuarios> usuarios = usuariosServicio.Autenticacion(user, pass);
        return new ResponseEntity<List<Usuarios>>(usuarios, HttpStatus.OK);
    }

    @RequestMapping(value = "/crecionCiudadanos/", method = RequestMethod.POST, consumes
            = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearCiudadanos(@RequestBody Usuarios usuarios) {
        String resultado = "Se creo usuario con ID: " + usuariosServicio.crearUsuario(usuarios);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuarios/{id_usuarios}/eventos/", method = RequestMethod.GET)
    public ResponseEntity<Eventos> obtenerEventosPorIdCiudadano(@PathVariable("id_usuarios") int id) {
        Eventos usuarioEvento = eventosServicio.getCiudadanoByEventos(id);
        return new ResponseEntity<>(usuarioEvento, HttpStatus.OK);
    }

}
