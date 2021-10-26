package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Provincia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEspecialidad;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioProvincias;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;


public class ServicioFiltroTest {
	private ServicioFiltro servicioFiltro=new ServicioFiltroImp(mock(RepositorioEspecialidad.class),mock(RepositorioProvincias.class),mock(RepositorioUsuario.class));
	private List <Especialidad> especialidades;
	private List <Provincia> provincias;
	private List <Usuario> usuarios;
	
	Provincia caba=new Provincia(1L,"CABA");
	Especialidad grua=new Especialidad(1L,"grua");
	
	
	@Before
	public void intanciarEspecialidades() {
		especialidades = new ArrayList<Especialidad>();
		
	}
	
	@Before
	public void intanciarProvincias() {
		provincias = new ArrayList<Provincia>();
		
	} 

	@Before
	public void intanciarListaUsuarios() {
		usuarios = new ArrayList<Usuario>();
		
	}
	
	@Before
	public void intanciarProvincia() {
		caba = new Provincia();
		
	}
	
	@Before
	public void intanciarEspecialidad() {
		grua = new Especialidad();
		
	} 
	
	@Test
	public void testQueTraeLaListaDeEspecialidadesCompleta() {
		givenLaListaDeEspecialidades();
		thenSonLasEspecialidades(whenTraigoLaLista());
	}
	
	private void givenLaListaDeEspecialidades() {
		this.especialidades.add(new Especialidad(1L,"grua"));
		this.especialidades.add(new Especialidad(2L,"mecanico"));
		this.especialidades.add(new Especialidad(3L,"medico"));
		this.especialidades.add(new Especialidad(4L,"gestor"));
		this.especialidades.add(new Especialidad(5L,"abogado"));
		this.especialidades.add(new Especialidad(6L,"gomeria movil"));
		this.especialidades.add(new Especialidad(7L,"chofer"));
		
		Mockito.when(servicioFiltro.traerEspecialidad()).thenReturn(this.especialidades);	
	}
	
	private List<Especialidad> whenTraigoLaLista() {
		return servicioFiltro.traerEspecialidad();
		
	}
	private void thenSonLasEspecialidades(List<Especialidad> especialidad) {
		Especialidad grua =especialidad.get(0);
		Assertions.assertThat(grua.getId()).isEqualTo(1L);
		Assertions.assertThat(grua.getDescripcion()).isEqualTo("grua");
		Assertions.assertThat(especialidad.size()).isNotNull();
		Assertions.assertThat(especialidad.size()).isEqualTo(7);
		Assertions.assertThat(!especialidad.isEmpty());
		Assertions.assertThat((List<?>) especialidad).hasOnlyElementsOfType(Especialidad.class);
		
	}
	
	//test
	@Test
	public void testQueTraeUnaListaDe3Provincias() {
		givenLaListaDeProvincias();
		thenSonLasProvincias(whenTraigoLaListaDeProvincias());
	}
	
	private void givenLaListaDeProvincias() {
		this.provincias.add(new Provincia(1L,"CABA"));
		this.provincias.add(new Provincia(2L,"Buenos Aires"));
		this.provincias.add(new Provincia(3L,"Santa Fe"));
		
		Mockito.when(servicioFiltro.traerprovincia()).thenReturn(this.provincias);		
	}

	private List<Provincia> whenTraigoLaListaDeProvincias() {
		
		return servicioFiltro.traerprovincia();
	}

	private void thenSonLasProvincias(List<Provincia> provincias) {
		Provincia caba =provincias.get(0);
		Assertions.assertThat(caba.getId()).isEqualTo(1L);
		Assertions.assertThat(caba).hasFieldOrProperty("nombre");
		Assertions.assertThat(caba.getNombre()).isEqualTo("CABA");
		Assertions.assertThat(provincias.size()).isNotNull();
		Assertions.assertThat(provincias.size()).isEqualTo(3);
		Assertions.assertThat(!provincias.isEmpty());
		Assertions.assertThat((List<?>) provincias).hasOnlyElementsOfType(Provincia.class);
		
	}
	
	//test
	@Test
	public void testQueTraeUsuariosDeUnaProvincia() {
		givenUsuariosEspecialidadesYprovincia();
		this.usuarios=whenTraigoLosUsuariosDeUnaProvincia();
		thenSonLosUsuariosDeLaProvincia(this.usuarios);
	}
	
	private void givenUsuariosEspecialidadesYprovincia() {
		Provincia caba=new Provincia(1L,"CABA");
		Especialidad especialidad=new Especialidad(1L,"grua");
		Especialidad especialidad2=new Especialidad(2L,"mecanico");
		Especialidad especialidad3=new Especialidad(3L,"gestor");
		this.usuarios.add(new Usuario("juan","perez",especialidad,caba));
		this.usuarios.add(new Usuario("jose","martinez",especialidad2,caba));
		this.usuarios.add( new Usuario("carlos","lobos",especialidad3,caba));
		Mockito.when(servicioFiltro.usuariosDeLaProvincia(caba.getId())).thenReturn(this.usuarios);
	}

	private List<Usuario> whenTraigoLosUsuariosDeUnaProvincia() {
		return servicioFiltro.usuariosDeLaProvincia(1L);
		
	}
	
	private void thenSonLosUsuariosDeLaProvincia(List<Usuario> usuarios) {
		Usuario usuario=usuarios.get(0);
		Assertions.assertThat(usuario).hasFieldOrProperty("nombre");
		Assertions.assertThat(usuario).hasFieldOrProperty("apellido");
		Assertions.assertThat(usuario).hasFieldOrProperty("especialidad");
		Assertions.assertThat(usuario).hasFieldOrProperty("provincia");
		Assertions.assertThat(usuario.getProvincia().getNombre()).isEqualTo("CABA");
		
		Usuario usuario2=usuarios.get(1);
		Assertions.assertThat(usuario2).hasFieldOrProperty("nombre");
		Assertions.assertThat(usuario2).hasFieldOrProperty("apellido");
		Assertions.assertThat(usuario2).hasFieldOrProperty("especialidad");
		Assertions.assertThat(usuario2).hasFieldOrProperty("provincia");
		Assertions.assertThat(usuario2.getProvincia().getNombre()).isEqualTo("CABA");
		
	}
	
	//test
		@Test
		public void testQueTraeUsuariosDeLaMismaEspecialidad() {
			givenUsuariosProvinciasYEspecialidad();
			this.usuarios=whenTraigoLosUsuariosDeLaMismaEspecialidad();
			thenSonLosUsuariosDeLaMismaEspecialidad(this.usuarios);
		}
		
		private void givenUsuariosProvinciasYEspecialidad() {
			Provincia caba=new Provincia(1L,"CABA");
			Provincia ba=new Provincia(2L,"Buenos Aires");
			Provincia cba=new Provincia(3L,"Cordoba");
			Especialidad especialidad=new Especialidad(1L,"grua");
			this.usuarios.add(new Usuario("juan","perez",especialidad,caba));
			this.usuarios.add(new Usuario("jose","martinez",especialidad,cba));
			this.usuarios.add( new Usuario("carlos","lobos",especialidad,ba));
			Mockito.when(servicioFiltro.usuariosDeLaEspecialidad(especialidad.getId())).thenReturn(usuarios);
					
		}

		private List<Usuario> whenTraigoLosUsuariosDeLaMismaEspecialidad() {
			return servicioFiltro.usuariosDeLaEspecialidad(1L);
			
		}
		
		private void thenSonLosUsuariosDeLaMismaEspecialidad(List<Usuario> usuarios) {
			Usuario usuario=usuarios.get(0);
			Assertions.assertThat(usuario).hasFieldOrProperty("nombre");
			Assertions.assertThat(usuario).hasFieldOrProperty("apellido");
			Assertions.assertThat(usuario).hasFieldOrProperty("especialidad");
			Assertions.assertThat(usuario).hasFieldOrProperty("provincia");
			Assertions.assertThat(usuario.getProvincia().getNombre()).isEqualTo("CABA");
			
			Usuario usuario2=usuarios.get(1);
			Assertions.assertThat(usuario2).hasFieldOrProperty("nombre");
			Assertions.assertThat(usuario2).hasFieldOrProperty("apellido");
			Assertions.assertThat(usuario2).hasFieldOrProperty("especialidad");
			Assertions.assertThat(usuario2).hasFieldOrProperty("provincia");
			Assertions.assertThat(usuario2.getProvincia().getNombre()).isEqualTo("Cordoba");			
		}
		
		//test
		@Test
		public void testQueTraeUsuariosDeLaMismaEspecialidadYprovincia() {
			givenUsuariosDeLaMismaProvinciaYEspecialidad();
			this.usuarios=whenTraigoLosUsuariosDeLaMismaEspecialidadYprovincia(grua.getId(), caba.getId());
			thenSonLosUsuariosDeLaMismaEspecialidadYprovincia(this.usuarios);
		}


		private void givenUsuariosDeLaMismaProvinciaYEspecialidad() {
			this.usuarios.add(new Usuario("juan","perez",this.grua,this.caba));
			this.usuarios.add(new Usuario("jose","martinez",this.grua,this.caba));
			this.usuarios.add( new Usuario("carlos","lobos",this.grua,this.caba));
			Mockito.when(servicioFiltro.usuariosDeLaEspecialidadYprovincia(grua.getId(), caba.getId())).thenReturn(this.usuarios);
		}
		
		private List<Usuario> whenTraigoLosUsuariosDeLaMismaEspecialidadYprovincia(Long idEspecialidad, Long idProvincia) {
			return servicioFiltro.usuariosDeLaEspecialidadYprovincia(idEspecialidad, idProvincia);
			
		}
		
		private void thenSonLosUsuariosDeLaMismaEspecialidadYprovincia(List<Usuario> usuarios) {
			Usuario usuario =usuarios.get(0);
			Usuario usuario2 =usuarios.get(1);
			Usuario usuario3 =usuarios.get(2);
			Assertions.assertThat(usuario.getProvincia().getNombre()).isEqualTo(usuario2.getProvincia().getNombre());	
			Assertions.assertThat(usuario3.getProvincia().getNombre()).isEqualTo(usuario.getProvincia().getNombre());
			Assertions.assertThat(usuario.getEspecialidad().getDescripcion()).isEqualTo(usuario2.getEspecialidad().getDescripcion());
			Assertions.assertThat(usuario3.getEspecialidad().getDescripcion()).isEqualTo(usuario.getEspecialidad().getDescripcion());		
			
		}
}
