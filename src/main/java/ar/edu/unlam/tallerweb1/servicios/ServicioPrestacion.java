package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioPrestacion {

    void save(Prestacion nuevaPrestacion);
    void delete(Prestacion prestacionExistente);
    void update(Prestacion prestacionExistente);

    List<Prestacion> getAll();
    Prestacion prestacionFindById(Long id);
    List<Prestacion> prestacionFindByEspecialidad(Especialidad especialidad);

    void finalizarPrestacion(Prestacion prestacion) throws Exception;

    Prestacion buscarPrestacionPorId(Long id);
    List<Prestacion> listarPrestacionesContratadasPorCliente(Long id);

    void ClienteCalificaPrestacion(Long idPrestacion, Integer calificacion) throws Exception;

    Float obtenerPromedioDeCalificicacionDeUnUsuario(Usuario usuario) throws Exception;
}
