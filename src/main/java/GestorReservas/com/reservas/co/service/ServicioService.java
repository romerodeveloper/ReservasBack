package GestorReservas.com.reservas.co.service;

import GestorReservas.com.reservas.co.model.Servicio;
import GestorReservas.com.reservas.co.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository repository;

    public List<Servicio> listar(){
        var lista = repository.findAll();
        return lista;

    }
}
