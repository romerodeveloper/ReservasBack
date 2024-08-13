package GestorReservas.com.reservas.co.dto;

import GestorReservas.com.reservas.co.model.Estado;
import GestorReservas.com.reservas.co.model.Reserva;

import java.time.LocalDateTime;

public record DatosDetalleReserva(Long id, String nombrePersona, Long idServicio, String nombreServicio, LocalDateTime fecha, Estado estado) {
    public DatosDetalleReserva(Reserva reserva) {
        this(reserva.getId(), reserva.getPersona().getNombre(), reserva.getServicio().getId(), reserva.getServicio().getNombre(), reserva.getFecha(), reserva.getEstado());
    }
}
