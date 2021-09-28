package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPrestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacionImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioPrestacionTest {
    private static final Long MECANICO = 638L;
    private static final Long CLIENTE = 201L;

    private Usuario cliente;
    private Usuario asistente;
    private Especialidad especialidad;
    private Prestacion prestacion;

    private RepositorioPrestacion repositorioContratar = Mockito.mock(RepositorioPrestacion.class);
    private ServicioPrestacionImpl servicioContratar = new ServicioPrestacionImpl(repositorioContratar);

    @Test
    public void prestacionServicioExitoso() {
        givenPrestacionServicioExitosoDisponible();
        whenPrestacionServicioExitosoContratoPrestacion();
        thenPrestacionServicioExitosoContratacionExitosa();
    }

    private void givenPrestacionServicioExitosoDisponible() {
        cliente = new Usuario();

        var rolCliente = new Rol();
        rolCliente.setId(CLIENTE);

        cliente.setRol(rolCliente);

        asistente = new Usuario();

        var rolMecanico = new Rol();
        rolMecanico.setId(MECANICO);

        asistente.setRol(rolMecanico);

        especialidad = new Especialidad();

        prestacion = new Prestacion();

        prestacion.setUsuarioSolicitante(cliente);
        prestacion.setUsuarioAsistente(asistente);
        prestacion.setEspecialidad(especialidad);
    }

    private void whenPrestacionServicioExitosoContratoPrestacion() {
        servicioContratar.save(prestacion);
    }

    private void thenPrestacionServicioExitosoContratacionExitosa() {
        Assertions.assertThat(servicioContratar.prestacionFindById(prestacion.getId()));
    }
}
