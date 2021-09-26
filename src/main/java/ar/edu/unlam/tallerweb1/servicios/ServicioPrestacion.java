package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;

import java.util.List;

public interface ServicioPrestacion {

    void save(Prestacion nuevaPrestacion);
    void delete(Prestacion prestacionExistente);
    void update(Prestacion prestacionExistente);

    List<Prestacion> getAll();
    Prestacion prestacionFindById(Long id);
    List<Prestacion> prestacionFindByEspecialidad(String especialidad);
}
