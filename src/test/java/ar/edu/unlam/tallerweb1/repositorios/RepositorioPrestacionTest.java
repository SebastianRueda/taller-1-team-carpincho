package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.PrestacionEstado;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPrestacionTest extends SpringTest {
    private Prestacion prestacion;

    @Before
    public void createPrestacion() {
        prestacion = new Prestacion();
    }

    @Autowired
    private RepositorioPrestacion repositorioPrestacion;

    @Test
    @Rollback
    @Transactional
    public void guardarPrestacionTest() {
        givenGuardarPrestacionExitosamente(prestacion);
        var encontrada = whenBuscoLaPresatacionQueGuarde(this.prestacion);
        thenComparoQueSeanLasMismasLaPrestacionGuardadaConLaObtenida(this.prestacion, encontrada);
    }

    @Test
    @Rollback
    @Transactional
    public void deletePrestacionTest() {
        givenGuardarPrestacionExitosamente(prestacion);
        whenEliminoPrestacion(prestacion);
        thenComprueboQueLaPrestacionSeHayaEliminado(prestacion);
    }

    @Test
    @Rollback
    @Transactional
    public void actualizarEstadoDeLaPrestacionTest() {
        givenGuardarPrestacionConEstadoActivo(prestacion);
        whenActualizarEstadoDeLaPrestacionGuardadaAFinalizada(prestacion);
        thenCompruboQueSeHayaActualizadoLaPrestacionCorrectamente(prestacion);
    }

    @Test
    @Rollback
    @Transactional
    public void traerListaDePrestacionesTest() {
        final var cantPrestaciones = 6;
        givenGuardarListaDePrestaciones(cantPrestaciones);
        var prestaciones = whenTraerTodasLasPrestaciones();
        thenComprueboQueLaCantidadDePrestacionesSeaLaMismaQueGuardada(prestaciones, cantPrestaciones);
    }

    @Test
    @Rollback
    @Transactional
    public void encontrarPrestacionTest() {
        whenEncontrarPrestacion(prestacion);
        thenEncontrarPrestacion(prestacion);
    }

   /* @Test
    @Rollback
    @Transactional
    public void filtarPrestacionPorEspecialiadad() {
        var especialidad = new Especialidad();
        var cantEsperada = 3;
        givenFiltarPrestacionPorEspecialiadad(especialidad, cantEsperada);
        var prestaciones = whenGivenFiltrarPrestacionesPorEspecialidad(especialidad);
        thenFiltrarPrestacionesPorEspecialidad(prestaciones, cantEsperada);
    }*/

    // ------------------------------------------------

    private void givenGuardarPrestacionExitosamente(Prestacion prestacion) {
        repositorioPrestacion.save(prestacion);
    }

    private Prestacion whenBuscoLaPresatacionQueGuarde(Prestacion prestacion) {
        return repositorioPrestacion.prestacionFindById(prestacion.getId());
    }

    private void thenComparoQueSeanLasMismasLaPrestacionGuardadaConLaObtenida(Prestacion guardada, Prestacion buscada) {
        Assert.assertEquals(guardada.getId(), buscada.getId());
    }

    // ------------------------------------------------

    private void givenDeletePrestacionExitoso() {
        repositorioPrestacion.save(prestacion);
    }

    private void whenEliminoPrestacion(Prestacion prestacion) {
        repositorioPrestacion.delete(prestacion);
    }

    private void thenComprueboQueLaPrestacionSeHayaEliminado(Prestacion prestacion) {
        Assert.assertNull(repositorioPrestacion.prestacionFindById(prestacion.getId()));
    }

    // ------------------------------------------------

    private void givenGuardarPrestacionConEstadoActivo(Prestacion prestacion) {
        prestacion.setEstado(PrestacionEstado.ACTIVO.getEstado());
        repositorioPrestacion.save(prestacion);
    }

    private void whenActualizarEstadoDeLaPrestacionGuardadaAFinalizada(Prestacion prestacion) {
        prestacion.setEstado(PrestacionEstado.FINALIZADO.getEstado());
        repositorioPrestacion.update(prestacion);
    }

    private void thenCompruboQueSeHayaActualizadoLaPrestacionCorrectamente(Prestacion prestacion) {
        Assert.assertEquals(prestacion.getEstado(), PrestacionEstado.FINALIZADO.getEstado());
    }

    // ------------------------------------------------

    private void givenGuardarListaDePrestaciones(int cantPrestaciones) {
        var prestaciones = new ArrayList<Prestacion>();
        for (int i = 0; i < cantPrestaciones; i++) {
            var p = new Prestacion();
            prestaciones.add(p);
            repositorioPrestacion.save(p);
        }
    }

    private List<Prestacion> whenTraerTodasLasPrestaciones() {
        return repositorioPrestacion.getAll();
    }

    private void thenComprueboQueLaCantidadDePrestacionesSeaLaMismaQueGuardada(List<Prestacion> prestacions, int cantPrestaciones) {
        Assert.assertEquals(repositorioPrestacion.getAll().size(), cantPrestaciones);
    }

    // ------------------------------------------------

    private void whenEncontrarPrestacion(Prestacion prestacion) {
        repositorioPrestacion.save(prestacion);
    }

    private void thenEncontrarPrestacion(Prestacion prestacion) {
        Assert.assertNotNull(repositorioPrestacion.prestacionFindById(prestacion.getId()));
    }

    // ------------------------------------------------

    private List<Prestacion> givenFiltarPrestacionPorEspecialiadad(Especialidad especialidad, int repetir) {
        var prestaciones = new ArrayList<Prestacion>();

        // la lista siempre va ser más el doble de la cantidad de veces que se va a repetir la especialidad
        // esperada
        for (int i = 0; i < (repetir * 2); i++) {
            var prestacion = new Prestacion();

            // si el índice es menor a repetir se guarda la prestación con la especialidad esperada
            // en caso contrario se le asigna una nueva especialidad
            if (i < repetir) {
                prestacion.setEspecialidad(especialidad);
            } else {
                prestacion.setEspecialidad(new Especialidad());
            }
            prestaciones.add(prestacion);
            repositorioPrestacion.save(prestacion);
        }
        return prestaciones;
    }

    private List<Prestacion> whenGivenFiltrarPrestacionesPorEspecialidad(Especialidad especialidad) {
        return repositorioPrestacion.prestacionFindByEspecialidad(especialidad);
    }

    private void thenFiltrarPrestacionesPorEspecialidad(List<Prestacion> prestaciones, int cantEsperado) {
        Assert.assertEquals(prestaciones.size(), cantEsperado);
    }
}
