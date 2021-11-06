package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEspecialidadTest extends SpringTest {
    @Autowired
    private RepositorioEspecialidad repositorioEspecialidad;

    private Especialidad especialidad;

    @Before
    public void instanciarEspecialidad() {
        especialidad = new Especialidad();
        especialidad.setDescripcion("Sub-Zero");
    }

    @Test
    @Rollback
    @Transactional
    public void guardarEspecialidad() {
        whenGuardoLaEspecialidad(especialidad);
        thenSeGuardoCorrectamente(especialidad);
    }

    @Test
    @Rollback
    @Transactional
    public void buscarEspecialidadPorId() {
        givenEspecialidadQueSeVaAGuardar(especialidad);
        var especialidadObtenidad = whenBuscaLaEspecialidadCon(especialidad.getId());
        thenLaEspecialidadSeGuardoCorrectamente(especialidad, especialidadObtenidad);
    }

    @Test
    @Rollback
    @Transactional
    public void borrarUnaEspecialidad() {
        givenEspecialidadQueSeVaAGuardar(especialidad);
        whenBorroLaEspecialidad(especialidad);
        thenComprueboQueSeHayaEliminadoLaEspecialidadCon(especialidad.getId());
    }

    @Test
    @Rollback
    @Transactional
    public void actualizarEspecialidad() {
        var especialidadOriginal = clone(especialidad);
        givenEspecialidadQueSeVaAGuardar(especialidad);
        var especialidadActualizada = whenActualizoLaDescripcionDeLaEspecialidad(especialidad);
        thenComprueboQueSeHayaActualizadoLaEspecialidad(especialidadOriginal, especialidadActualizada);
    }

    @Test
    @Rollback
    @Transactional
    public void listarEspecialidadesTest() {
        var especialidadesGuardadas = givenUnaListaDeEspecialidades();
        var especialidadesObtenidas = whenTraigoLaListaDeEspecialidades();
        thenSeListoTodasLasEspecialidades(especialidadesGuardadas, especialidadesObtenidas);
    }

    private void whenGuardoLaEspecialidad(Especialidad especialidad) {
        repositorioEspecialidad.save(especialidad);
    }

    private void thenSeGuardoCorrectamente(Especialidad especialidad) {
        Assert.assertNotNull(especialidad.getId());
    }

    private void givenEspecialidadQueSeVaAGuardar(Especialidad especialidad) {
        repositorioEspecialidad.save(especialidad);
    }

    private Especialidad whenBuscaLaEspecialidadCon(Long id) {
        return repositorioEspecialidad.traerEspecialidadPorId(id);
    }

    private void thenLaEspecialidadSeGuardoCorrectamente(Especialidad guardada, Especialidad obtenidad) {
        Assert.assertNotNull(obtenidad);
        Assert.assertEquals(guardada, obtenidad);
    }

    private void whenBorroLaEspecialidad(Especialidad especialidad) {
        repositorioEspecialidad.delete(especialidad);
    }

    private void thenComprueboQueSeHayaEliminadoLaEspecialidadCon(Long id) {
        var especialidadObtenida = repositorioEspecialidad.traerEspecialidadPorId(id);
        Assert.assertNull(especialidadObtenida);
    }

    private Especialidad whenActualizoLaDescripcionDeLaEspecialidad(Especialidad guardada) {
        guardada.setDescripcion("Scorpion");
        repositorioEspecialidad.update(guardada);

        return repositorioEspecialidad.traerEspecialidadPorId(guardada.getId());
    }

    private void thenComprueboQueSeHayaActualizadoLaEspecialidad(Especialidad guardada, Especialidad obtenida) {
        Assert.assertNotEquals(guardada, obtenida);
    }

    // para no "ensuciar" la clase con Clonnable uso un método
    private Especialidad clone(Especialidad especialidad) {
        var clonada = new Especialidad();
        clonada.setId(especialidad.getId());
        clonada.setDescripcion(especialidad.getDescripcion());

        return clonada;
    }

    private List<Especialidad> givenUnaListaDeEspecialidades() {
        var especialidades = new ArrayList<Especialidad>();

        for (int i = 0; i < 10; i++) {
            var especialidad = new Especialidad();
            especialidades.add(especialidad);
            repositorioEspecialidad.save(especialidad);
        }

        return especialidades;
    }

    private List<Especialidad> whenTraigoLaListaDeEspecialidades() {
        return repositorioEspecialidad.traerEspecialidad();
    }

    private void thenSeListoTodasLasEspecialidades(List<Especialidad> guardada, List<Especialidad> obtenidas) {
        Assert.assertNotNull(obtenidas);
        Assert.assertEquals(guardada.size(), obtenidas.size());
    }
}
