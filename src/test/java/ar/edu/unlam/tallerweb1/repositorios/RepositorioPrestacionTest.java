package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.PrestacionEstado;
import org.assertj.core.api.Assertions;
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
        whenGuardarPrestacionExitoso(prestacion);
        thenGuardarPrestacionExitoso(prestacion);
    }

    @Test
    @Rollback
    @Transactional
    public void deletePrestacionTest() {
        givenDeletePrestacionExitoso();
        whenDeletePrestacionExitoso(prestacion);
        thenDeletePrestacionExitoso(prestacion);
    }

    @Test
    @Rollback
    @Transactional
    public void updatePrestacionTest() {
        givenUpdatePrestacionExitoso(prestacion);
        whenUpdatePrestacionExitoso(prestacion);
        thenUpdatePrestacionExitoso(prestacion);
    }

    @Test
    @Rollback
    @Transactional
    public void traerListaDePrestacionesTest() {
        final var cantPrestaciones = 6;
        var prestaciones = givenTraerListaDePrestaciones(cantPrestaciones);
        whenTraerListaDePrestaciones(prestaciones);
        thenTraerListaDePrestaciones(cantPrestaciones);
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

    private void whenGuardarPrestacionExitoso(Prestacion prestacion) {
        repositorioPrestacion.save(prestacion);
    }

    private void thenGuardarPrestacionExitoso(Prestacion prestacion) {
        Assertions.assertThat(repositorioPrestacion.prestacionFindById(prestacion.getId())).isNotNull();
    }

    // ------------------------------------------------

    private void givenDeletePrestacionExitoso() {
        repositorioPrestacion.save(prestacion);
    }

    private void whenDeletePrestacionExitoso(Prestacion prestacion) {
        repositorioPrestacion.delete(prestacion);
    }

    private void thenDeletePrestacionExitoso(Prestacion prestacion) {
        Assert.assertNull(repositorioPrestacion.prestacionFindById(prestacion.getId()));
    }

    // ------------------------------------------------

    private void givenUpdatePrestacionExitoso(Prestacion prestacion) {
        prestacion.setEstado(PrestacionEstado.ACTIVO.getEstado());
        repositorioPrestacion.save(prestacion);
    }

    private void whenUpdatePrestacionExitoso(Prestacion prestacion) {
        prestacion.setEstado(PrestacionEstado.FINALIZADO.getEstado());
        repositorioPrestacion.update(prestacion);
    }

    private void thenUpdatePrestacionExitoso(Prestacion prestacion) {
        Assert.assertEquals(prestacion.getEstado(), PrestacionEstado.FINALIZADO.getEstado());
    }

    // ------------------------------------------------

    private List<Prestacion> givenTraerListaDePrestaciones(int cantPrestaciones) {
        var prestaciones = new ArrayList<Prestacion>();
        for (int i = 0; i < cantPrestaciones; i++) {
            prestaciones.add(new Prestacion());
        }

        return prestaciones;
    }

    private void whenTraerListaDePrestaciones(List<Prestacion> prestaciones) {
        prestaciones.forEach(p -> repositorioPrestacion.save(p));
    }

    private void thenTraerListaDePrestaciones(int cantPrestaciones) {
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
