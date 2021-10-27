package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Prestacion;

import java.util.List;

public interface RepositorioPrestacion {
    void save(Prestacion nuevaPrestacion);

    void delete(Prestacion prestacionExistente);

    void update(Prestacion prestacionExistente);

    List<Prestacion> getAll();

    Prestacion prestacionFindById(Long id);

    List<Prestacion> prestacionFindByEspecialidad(Especialidad especialidad);

    Prestacion buscarPrestacionPorId(Long id);

    List<Prestacion> listarPrestacionesContratadasPorCliente(Long id);

    Prestacion buscarPrestacionFinalizadaSinCalificar(Long idPrestacion);

    List<Prestacion> buscarPrestacionesCalificadasPorUsuario(Long id);
}
