package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;

public interface RepositorioEspecialidad {
	void save(Especialidad especialidad);
	void update(Especialidad especialidad);
	void delete(Especialidad especialidad);
	Especialidad find(Especialidad especialidad);
	List<Especialidad> traerEspecialidad();
	Especialidad traerEspecialidadPorId(Long id);
}
