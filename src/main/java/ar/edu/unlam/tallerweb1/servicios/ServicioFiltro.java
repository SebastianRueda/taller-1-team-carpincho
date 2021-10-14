package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Provincia;


public interface ServicioFiltro {

	List<Especialidad> traerEspecialidad();
	List<Provincia> traerprovincia();
	List <Usuario> usuariosDeLaEspecialidadYprovincia(Long idEspecialidad, Long idProvincia);
	List<Usuario> usuariosDeLaProvincia(Long idProvincia);
	List<Usuario> usuariosDeLaEspecialidad(Long idEspecialidad);

}
