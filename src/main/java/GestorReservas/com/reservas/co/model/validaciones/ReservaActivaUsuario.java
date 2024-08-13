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
public class ReservaActivaUsuario implements  ValidadorDeConsultas{
    @Autowired
    private ReservaRepository repository;
    @Autowired
    private PersonaRepository repositoryPersona;

    public void validar(DatosAgendarReserva datos) {
        var persona = repositoryPersona.getReferenceById(datos.idPersona());
        var personaConReserva = repository.existsByPersonaAndEstadoNot(persona, Estado.CANCELADA);
        if(personaConReserva){
            throw new ValidationException("esta persona ya tiene una reservacion activa");
        }
    }

    public void validarActualizacion(DatosActualizacionReserva datos) {
        System.out.println("validacion excenta");
    }
}