package ar.edu.unlam.tallerweb1.controladores;

import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Provincia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFiltro;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class ControladorFiltrosTest {
	
	private ServicioFiltro servicioFiltro;
	private ControladorFiltros controladorFiltros= new ControladorFiltros(servicioFiltro);
	private Especialidad especialidad=new Especialidad();
	private Provincia provincia=new Provincia();
	private Usuario usuario=new Usuario();
	
	@Test
	public void testQueTraeUnUsuarioFiltrandoPorEspecialidadYProvincia() {
		givenUnUsuarioConEspecialidadYProvincia(usuario,"grua","CABA");
		ModelAndView mav =whenSolicitoEspecialista(especialidad,provincia);
		thenElUsuarioEsElSolicitado(mav);
	}
	
	private void givenUnUsuarioConEspecialidadYProvincia(Usuario usuario, String especialidad, String provincia) {
		this.especialidad.setDescripcion(especialidad);
		this.especialidad.setId(1L);
		this.provincia.setNombre(provincia);
		this.provincia.setId(1L);
		usuario.setApellido("Cuevas");
		usuario.setEspecialidad(this.especialidad);
		usuario.setProvincia(this.provincia);
	}
	
	private ModelAndView whenSolicitoEspecialista(Especialidad especialidad, Provincia provincia) {
		ModelMap modelo = new ModelMap();
		List<Usuario> listaUsuarios=servicioFiltro.usuariosDeLaEspecialidadYprovincia(especialidad.getId(),provincia.getId());
		modelo.put("resultadoUsuarios", listaUsuarios);
		return new ModelAndView("resultadoPrestadores",modelo);
		
	}
	
	private void thenElUsuarioEsElSolicitado(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("resultadoPrestadores");
        //por ahora se intenta testear solamente que lleve a la vista correcta
    }
	
	
}
