package GestorReservas.com.reservas.co.service;

import GestorReservas.com.reservas.co.dto.DatosActualizacionReserva;
import GestorReservas.com.reservas.co.dto.DatosAgendarReserva;
import GestorReservas.com.reservas.co.dto.DatosDetalleReserva;
import GestorReservas.com.reservas.co.model.Estado;
import GestorReservas.com.reservas.co.model.Reserva;
import GestorReservas.com.reservas.co.model.validaciones.ValidadorDeConsultas;
import GestorReservas.com.reservas.co.repository.PersonaRepository;
import GestorReservas.com.reservas.co.repository.ReservaRepository;
import GestorReservas.com.reservas.co.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    List<ValidadorDeConsultas> validadores;

    public DatosDetalleReserva agendar(DatosAgendarReserva datos) {

        var persona = personaRepository.findById(datos.idPersona()).get();
        var servicio = servicioRepository.findById(datos.idServicio()).get();
        var reserva = new Reserva(datos.fecha(), datos.estado(), persona, servicio);
        validadores.forEach(v-> v.validar(datos));
        reservaRepository.save(reserva);
        return new DatosDetalleReserva(reserva);
    }

    public DatosDetalleReserva actualizar(DatosActualizacionReserva datos){
        var reserva = reservaRepository.getReferenceById(datos.id());
        var servicio = servicioRepository.findById(datos.idServicio()).get();

        validadores.forEach(v-> v.validarActualizacion(datos));
        reserva.actualizarInformacion(datos, servicio);
        return new DatosDetalleReserva(reserva);

    }
    public List<DatosDetalleReserva> listar() {
        var lista = reservaRepository.findAll();
        var detalle = lista.stream()
                .filter(r -> !Estado.CANCELADA.equals(r.getEstado()))  // Filtra las reservas que no están en estado "CANCELADA"
                .map(DatosDetalleReserva::new)
                .collect(Collectors.toList());
        return detalle;
    }

    public void eliminar(Long id){
        var reserva = reservaRepository.getReferenceById(id);
        reserva.eliminar();
    }


}
