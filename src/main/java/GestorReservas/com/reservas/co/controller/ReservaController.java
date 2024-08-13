package GestorReservas.com.reservas.co.controller;

import GestorReservas.com.reservas.co.dto.DatosActualizacionReserva;
import GestorReservas.com.reservas.co.dto.DatosAgendarReserva;
import GestorReservas.com.reservas.co.dto.DatosDetalleReserva;
import GestorReservas.com.reservas.co.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/reservas")
@Tag(name = "Controlador de reservas", description = "EndPoint de reservas, implementacion de CRUD")
public class ReservaController {
    @Autowired
    private ReservaService service;

    @PostMapping
    @Transactional
    @Operation(
            summary = "Agenda una reserva",
            description = "Ingresa una reserva con los parametros fecha de tipo DateTime, Estado como string con tres opciones CONFIMARDA, PENDIENTE, los servicios y personas se ingresan con id como asociación de las otras clases, retorna un json de datos de reserva")
    public ResponseEntity agendar(@RequestBody DatosAgendarReserva datos) {
        var response = service.agendar(datos);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    @Operation(
            summary = "Actualiza una reserva",
            description = "Actualiza una reserva con los parametros fecha de tipo DateTime, Estado como string con tres opciones CONFIMARDA, PENDIENTE, el servicio se ingresa con id como asociación de la clase, retorna un json de datos de reserva actualizado")
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionReserva datos) {
        var reserva = service.actualizar(datos);
        return ResponseEntity.ok(reserva);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(
            summary = "Elimina una reserva",
            description = "Elimina una reserva con el id de la reserva, funcion que cambia el estado de la reserva a CANCELADA y no retorna mensajes")
    public ResponseEntity eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    @Operation(
            summary = "Lista de reservas",
            description = "Retorna una lista de objetos json de datos de reserva, con todos los parametros para que puedan hacerse filtros en el front")
    public List<DatosDetalleReserva> obtenerTodasLasReservas(){
        var reservas = service.listar();
        return ResponseEntity.ok(reservas).getBody();
    }

}
