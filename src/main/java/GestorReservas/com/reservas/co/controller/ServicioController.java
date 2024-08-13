package GestorReservas.com.reservas.co.controller;

import GestorReservas.com.reservas.co.model.Servicio;
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
@RequestMapping("/servicios")
public class ServicioController {

   @Autowired
   private ServicioService service;

    @GetMapping()
    public List<Servicio> obtenerTodasLosServicios(){
        var servicios = service.listar();
        return ResponseEntity.ok(servicios).getBody();
    }
}
