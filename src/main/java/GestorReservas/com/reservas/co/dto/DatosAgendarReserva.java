package GestorReservas.com.reservas.co.dto;
import GestorReservas.com.reservas.co.model.Estado;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DatosAgendarReserva(

        @NotNull
        @Future
        LocalDateTime fecha,
        @NotNull
        Estado estado,
        @NotNull
        Long idPersona,
        @NotNull
        Long idServicio

) {
}
