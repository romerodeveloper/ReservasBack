package GestorReservas.com.reservas.co.repository;

import GestorReservas.com.reservas.co.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
