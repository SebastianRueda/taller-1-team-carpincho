package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPrestacion;
import static org.assertj.core.api.Assertions.assertThat;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServicioPrestacionTest {


    private static final Long MECANICO = 638L;
    private static final Long CLIENTE = 201L;

    private Usuario cliente;
    private Usuario asistente;
    private Especialidad especialidad;
    private Prestacion prestacion;

    @Mock
    private RepositorioPrestacion repositorioPrestacion;
    @Mock
    private RepositorioUsuario repositorioUsuario;
    private ServicioPrestacion servicioPrestacion;
    private final Prestacion prestacionCONTRATADA = getContratado();

    private Prestacion getContratado(){
        Prestacion prestacionContratada = new Prestacion();
        return prestacionContratada;
    }


    private RepositorioPrestacion repositorioContratar = Mockito.mock(RepositorioPrestacion.class);
    private ServicioPrestacionImpl servicioContratar = new ServicioPrestacionImpl(repositorioContratar, repositorioUsuario);

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        this.servicioPrestacion = new ServicioPrestacionImpl(repositorioPrestacion,repositorioUsuario);
    }


    @Test
    public void prestacionServicioExitoso() {
        givenPrestacionServicioExitosoDisponible();
        whenPrestacionServicioExitosoContratoPrestacion();
        thenPrestacionServicioExitosoContratacionExitosa();
    }

    @Test
    public void queDevuelvaLosContratados(){
        givenContratado();
        whenBuscoLaListaDeContratados(prestacionCONTRATADA);
        thenVeoElSizeDeContratado(1);
    }

    @Test
    public void queEjecuteMetodoSave(){
        givenContratado();
        whenEjecutoMetodoSave(prestacionCONTRATADA);
        thenVeoLaCantidadDeEjecuciones(1);
    }

    @Test
    public void queSeEjecuteFindById(){
        givenContratado();
        whenEjecutoMetodoFindById(1l, prestacionCONTRATADA);
        thenAnalizoElContradoSeaIgualAlQueEspero(1L, prestacionCONTRATADA);
    }


    private void givenContratado() {
    }

    private void whenBuscoLaListaDeContratados(Prestacion prestacionContratada) {
        Mockito.when(repositorioPrestacion.getAll()).thenReturn(Stream.of(prestacionContratada).collect(Collectors.toList()));
    }

    private void thenVeoElSizeDeContratado(Integer count) {
        assertThat(servicioPrestacion.getAll().size()).isEqualTo(count);
    }

    private void whenEjecutoMetodoSave(Prestacion prestacionContratada) {
        servicioPrestacion.save(prestacionContratada);
    }

    private void thenVeoLaCantidadDeEjecuciones(int i) {
        Mockito.verify(repositorioPrestacion,Mockito.times(i)).save(prestacionCONTRATADA);
    }

    private void whenEjecutoMetodoFindById(long l, Prestacion prestacionContratada) {
        Mockito.when(repositorioPrestacion.prestacionFindById(l)).thenReturn(prestacionContratada);
    }

    private void thenAnalizoElContradoSeaIgualAlQueEspero(long l, Prestacion prestacionContratada) {
        assertThat(servicioPrestacion.prestacionFindById(l)).isEqualTo(prestacionContratada);
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
