package GestorReservas.com.reservas.co.controller;

import GestorReservas.com.reservas.co.model.Persona;
import GestorReservas.com.reservas.co.model.Servicio;
import GestorReservas.com.reservas.co.service.PersonaService;
import GestorReservas.com.reservas.co.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping()
    public List<Persona> obtenerTodasLasPersonas(){
        var personas = service.listar();
        return ResponseEntity.ok(personas).getBody();
    }
}
