package GestorReservas.com.reservas.co.model.validaciones;

import GestorReservas.com.reservas.co.dto.DatosActualizacionReserva;
import GestorReservas.com.reservas.co.dto.DatosAgendarReserva;

public interface ValidadorDeConsultas {
    public void validar(DatosAgendarReserva datos);

    public void validarActualizacion(DatosActualizacionReserva datos);
}
