package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Provincia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEspecialidad;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioProvincias;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service("servicioFiltro")
@Transactional
public class ServicioFiltroImp implements ServicioFiltro{
	
	private RepositorioEspecialidad repositorioEspecialidades;
	private RepositorioProvincias repositorioProvincias;
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	public ServicioFiltroImp(RepositorioEspecialidad repositorioEspecialidades, RepositorioProvincias repositorioProvincias, RepositorioUsuario repositorioUsuario) {
		this.repositorioEspecialidades=repositorioEspecialidades;
		this.repositorioProvincias=repositorioProvincias;
		this.repositorioUsuario=repositorioUsuario;
	}
	

	@Override
	public List<Especialidad> traerEspecialidad() {
		List <Especialidad> especialidadLista= repositorioEspecialidades.traerEspecialidad();
		return especialidadLista ;
	}
	

	@Override
	public List<Provincia> traerprovincia() {
		List <Provincia> provinciaLista= repositorioProvincias.traerProvincia();
		return provinciaLista ;
	}

	@Override
	public List<Usuario> usuariosDeLaEspecialidadYprovincia(Long idEspecialidad, Long idProvincia) {
		List<Usuario> listaUsuariosDisponibles=repositorioUsuario.usuariosDeLaEspecialidadYprovincia(idEspecialidad,idProvincia);
		return listaUsuariosDisponibles;
	}

}
