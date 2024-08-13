package GestorReservas.com.reservas.co.dto;

import GestorReservas.com.reservas.co.model.Estado;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizacionReserva (
        @NotNull
        Long id,
        @NotNull
        @Future
        LocalDateTime fecha,
        @NotNull
        Estado estado,
        @NotNull
        Long idServicio

){
}
