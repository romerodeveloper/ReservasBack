package GestorReservas.com.reservas.co.model;

import GestorReservas.com.reservas.co.dto.DatosActualizacionReserva;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "reservas")
@Entity(name = "Reserva")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;


    public Reserva(LocalDateTime fecha, Estado estado, Persona persona, Servicio servicio) {
        this.fecha = fecha;
        this.estado = estado;
        this.persona = persona;
        this.servicio = servicio;
    }

    public void actualizarInformacion(DatosActualizacionReserva datos, Servicio servicio) {
        if (datos.fecha() != null) {
            this.fecha = datos.fecha();
        }
        if (datos.estado() != null) {
            this.estado = datos.estado();
        }
        if (datos.idServicio() != null) {
            this.servicio = servicio;
        }
    }

    public void eliminar() {
        this.estado = Estado.CANCELADA;
    }
}
