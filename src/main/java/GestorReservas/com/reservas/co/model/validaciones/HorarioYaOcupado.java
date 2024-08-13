package GestorReservas.com.reservas.co.model.validaciones;

import GestorReservas.com.reservas.co.dto.DatosActualizacionReserva;
import GestorReservas.com.reservas.co.dto.DatosAgendarReserva;
import GestorReservas.com.reservas.co.model.Estado;
import GestorReservas.com.reservas.co.repository.PersonaRepository;
import GestorReservas.com.reservas.co.repository.ReservaRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HorarioYaOcupado implements  ValidadorDeConsultas{
    @Autowired
    private ReservaRepository repository;
    @Autowired
    private PersonaRepository repositoryPersona;

    public void validar(DatosAgendarReserva datos) {
        var personaConReserva = repository.existsByFechaAndEstadoNot(datos.fecha(), Estado.CANCELADA);
        if(personaConReserva){
            throw new ValidationException("ya hay una reserva en esta fecha");
        }
    }

    public void validarActualizacion(DatosActualizacionReserva datos) {
        var personaConReserva = repository.existsByFechaAndEstadoNot(datos.fecha(), Estado.CANCELADA);
        if(personaConReserva){
            throw new ValidationException("ya hay una reserva en esta fecha");
        }
    }
}