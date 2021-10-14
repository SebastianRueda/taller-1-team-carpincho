package ar.edu.unlam.tallerweb1.servicios;

import static org.mockito.Mockito.mock;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioEspecialidad;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioProvincias;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

public class ServicioFiltroTest {
	private ServicioFiltro servicioFiltro=new ServicioFiltroImp(mock(RepositorioEspecialidad.class),mock(RepositorioProvincias.class),mock(RepositorioUsuario.class));
//	@Test(expected=RuntimeException.class)
//	public void testQueVerificaQueLaListaDeEspecialidadesEstaVacia() {
//		
//	}
}
