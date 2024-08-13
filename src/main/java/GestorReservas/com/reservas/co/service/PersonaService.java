package GestorReservas.com.reservas.co.service;

import GestorReservas.com.reservas.co.model.Persona;
import GestorReservas.com.reservas.co.model.Servicio;
import GestorReservas.com.reservas.co.repository.PersonaRepository;
import GestorReservas.com.reservas.co.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository repository;

    public List<Persona> listar(){
        var lista = repository.findAll();
        return lista;

    }
}
