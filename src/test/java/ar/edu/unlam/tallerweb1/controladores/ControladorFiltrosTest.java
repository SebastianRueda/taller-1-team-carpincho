package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioEspecialidades;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioProvincias;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFiltroImp;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Provincia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFiltro;
import java.util.ArrayList;
import java.util.List;

public class ControladorFiltrosTest {
	private RepositorioEspecialidades repositorioEspecialidades = Mockito.mock(RepositorioEspecialidades.class);
	private RepositorioProvincias repositorioProvincias = Mockito.mock(RepositorioProvincias.class);
	private RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
	private ServicioFiltro servicioFiltro = new ServicioFiltroImp(repositorioEspecialidades, repositorioProvincias, repositorioUsuario);
	private ControladorFiltros controladorFiltros = new ControladorFiltros(servicioFiltro);

	private Usuario usuario;
	private Especialidad especialidad;
	private Provincia provincia;

	// La anotación @Before ejecuta el método que la lleve siempre antes que se ejecute
	// un método con la anotación @Test. En este caso antes de testear un método se va a instanciar un
	// objeto usuario
	// También hay una anotación que se llama @After que ejecuta el método después que es ejecuta un test
	@Before
	public void intanciarUsuario() {
		usuario = new Usuario();
	}

	@Before
	public void intanciarEspecialidad() {
		especialidad = new Especialidad();
	}

	@Before
	public void intanciarProvincia() {
		provincia = new Provincia();
	}

	@Test
	public void testQueTraeUnUsuarioFiltrandoPorEspecialidadYProvincia() {
		givenUnUsuarioConEspecialidadYProvincia(usuario,"grua","CABA");
		ModelAndView mav =whenSolicitoEspecialista(especialidad,provincia);
		thenElUsuarioEsElSolicitado(mav);
	}

	@Test
	public void traerLaListaDeProvinciasYEspecialidadesEsperadas() {
		final var cantEspecialidades = 10;
		final var cantProvincias = 12;
		givenTraerLaListaDeProvinciasYEspecialidadesEsperadas(cantEspecialidades, cantProvincias);
		var mav = whenTraerLaListaDeProvinciasYEspecialidadesEsperadas();
		thenTraerLaListaDeProvinciasYEspecialidadesEsperadas(mav, cantEspecialidades, cantProvincias);
	}
	
	private void givenUnUsuarioConEspecialidadYProvincia(Usuario usuario, String especialidad, String provincia) {
		this.especialidad.setDescripcion(especialidad);
		this.especialidad.setId(1L);
		this.provincia.setNombre(provincia);
		this.provincia.setId(1L);
		usuario.setApellido("Cuevas");
		usuario.setEspecialidad(this.especialidad);
		usuario.setProvincia(this.provincia);

		var usuarioEsperado = new ArrayList<Usuario>();
		usuarioEsperado.add(usuario);

		// Cuando serivicioFiltro llame al método usuariosDeLaEspecialidadYprovincia con el id de
		// especialidad seteado en el objecto especialidad de esta clase y el id de provincia del objecto
		// provincia va a devolver la lista especificada
		Mockito.when(servicioFiltro.usuariosDeLaEspecialidadYprovincia(
				this.especialidad.getId(), this.provincia.getId()))
				.thenReturn(usuarioEsperado);
	}
	
	private ModelAndView whenSolicitoEspecialista(Especialidad especialidad, Provincia provincia) {
		ModelMap modelo = new ModelMap();
		List<Usuario> listaUsuarios = servicioFiltro.usuariosDeLaEspecialidadYprovincia(especialidad.getId(),provincia.getId());
		modelo.put("resultadoUsuarios", listaUsuarios);
		return new ModelAndView("resultadoPrestadores",modelo);
		
	}
	
	private void thenElUsuarioEsElSolicitado(ModelAndView mav) {
        Assertions.assertThat(mav.getViewName()).isEqualTo("resultadoPrestadores");
		var usuarios = mav.getModel().get("resultadoUsuarios");
		// checkea que sea una lista
		Assertions.assertThat(usuarios).isInstanceOf(List.class);
		// checkea que la lista sea de clase Usuario
		Assertions.assertThat((List<?>) usuarios).hasOnlyElementsOfType(Usuario.class);
		// checkea que la lista tenga un único usuario que es el estoy esperando
		Assertions.assertThat((List<?>) usuarios).hasSize(1);
		// checkea que la lista contenga al usuario que estoy esperando
		Assertions.assertThat(((List<?>) usuarios).contains(usuario));
    }
	
	private void givenTraerLaListaDeProvinciasYEspecialidadesEsperadas(int cantEspecialidadesEsperadas, int cantProvinciasEsperadas) {
		var especialidades = new ArrayList<Especialidad>();
		for (int i = 0; i < cantEspecialidadesEsperadas; i++) {
			especialidades.add(new Especialidad());
		}

		Mockito.when(servicioFiltro.traerEspecialidad()).thenReturn(especialidades);

		var provincias = new ArrayList<Provincia>();
		for (int i = 0; i < cantProvinciasEsperadas; i++) {
			provincias.add(new Provincia());
		}

		Mockito.when(servicioFiltro.traerprovincia()).thenReturn(provincias);
	}

	private ModelAndView whenTraerLaListaDeProvinciasYEspecialidadesEsperadas() {
		return controladorFiltros.listaEspecialidadesDesplegable();
	}

	private void thenTraerLaListaDeProvinciasYEspecialidadesEsperadas(ModelAndView mav, int cantEspecilidades, int cantProvincias) {
		Assertions.assertThat(mav.getViewName()).isEqualTo("busquedaPrestadores");

		var model = mav.getModel();

		var especialidades = model.get("especialidades");

		Assertions.assertThat(especialidades).isInstanceOf(List.class);
		Assertions.assertThat((List<?>) especialidades).hasOnlyElementsOfType(Especialidad.class);
		Assertions.assertThat((List<?>) especialidades).hasSize(cantEspecilidades);

		var provincias = model.get("provincias");

		Assertions.assertThat(provincias).isInstanceOf(List.class);
		Assertions.assertThat((List<?>) provincias).hasOnlyElementsOfType(Provincia.class);
		Assertions.assertThat((List<?>) provincias).hasSize(cantProvincias);
	}
}
