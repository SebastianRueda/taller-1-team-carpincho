package ar.edu.unlam.tallerweb1.servicios;

import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Provincia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEspecialidad;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioProvincias;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

public class ServicioFiltroTest {
	private ServicioFiltro servicioFiltro=new ServicioFiltroImp(mock(RepositorioEspecialidad.class),mock(RepositorioProvincias.class),mock(RepositorioUsuario.class));
	private List <Especialidad> especialidades;
	private List <Provincia> provincias;
	
	@Before
	public void intanciarEspecialidades() {
		especialidades = new ArrayList<Especialidad>();
		
	}
	
	@Before
	public void intanciarProvincias() {
		provincias = new ArrayList<Provincia>();
		
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
		Assertions.assertThat(caba.getNombre()).isEqualTo("CABA");
		Assertions.assertThat(provincias.size()).isNotNull();
		Assertions.assertThat(provincias.size()).isEqualTo(3);
		Assertions.assertThat(!provincias.isEmpty());
		Assertions.assertThat((List<?>) provincias).hasOnlyElementsOfType(Provincia.class);
		
	}

}
