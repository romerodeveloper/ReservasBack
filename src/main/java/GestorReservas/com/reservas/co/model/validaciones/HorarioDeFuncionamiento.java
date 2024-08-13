package GestorReservas.com.reservas.co.model.validaciones;

import GestorReservas.com.reservas.co.dto.DatosActualizacionReserva;
import GestorReservas.com.reservas.co.dto.DatosAgendarReserva;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HorarioDeFuncionamiento implements ValidadorDeConsultas{
    public void validar(DatosAgendarReserva datos) {

        var domingo = DayOfWeek.SUNDAY.equals(datos.fecha().getDayOfWeek());

        var antesdDeApertura=datos.fecha().getHour()<7;
        var despuesDeCierre=datos.fecha().getHour()>19;
        if(domingo || antesdDeApertura || despuesDeCierre){
            throw  new ValidationException("El horario permitido para reservas es de lunes a sábado, de 07:00 a 20:00 horas");
        }
    }

    public void validarActualizacion(DatosActualizacionReserva datos) {

        var domingo = DayOfWeek.SUNDAY.equals(datos.fecha().getDayOfWeek());
        var antesdDeApertura=datos.fecha().getHour()<7;
        var despuesDeCierre=datos.fecha().getHour()>19;
        if(domingo || antesdDeApertura || despuesDeCierre){
            throw  new ValidationException("El horario permitido para reservas es de lunes a sábado, de 07:00 a 20:00 horas");
        }
    }
}
