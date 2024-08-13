package GestorReservas.com.reservas.co.repository;

import GestorReservas.com.reservas.co.model.Estado;
import GestorReservas.com.reservas.co.model.Persona;
import GestorReservas.com.reservas.co.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    boolean existsByPersonaAndEstadoNot(Persona persona, Estado estado);
    boolean existsByFechaAndEstadoNot(LocalDateTime fecha, Estado estado);
}
