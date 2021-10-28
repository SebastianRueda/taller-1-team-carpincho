package ar.edu.unlam.tallerweb1.repositorios;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Provincia;

public class RepositorioProvinciaTest extends SpringTest{
	
	private static final Integer cantProvincias = 24;
	Provincia provincia=new Provincia();
	private List<Provincia> provincias= new ArrayList <Provincia>();
	
	@Autowired
	RepositorioProvincias repositorioProvincias;
	
	@Test
    @Rollback
    @Transactional
    public void guardarProvinciaTest() {
        givenGuardarProvinciaExitosamente(provincia);
        Provincia encontrada = whenBuscoLaPresatacionQueGuarde(this.provincia);
        thenComparoQueSeanLasMismasLaPrestacionGuardadaConLaObtenida(this.provincia, encontrada);
    }

    @Test
    @Rollback
    @Transactional
    public void actualizarProvinciaTest() {
        var original = clone(provincia);
        givenGuardarProvinciaExitosamente(provincia);
        whenActualizoLaProvincia(provincia);
        thenComparoQueLaProvinciaSeHayaActualizado(original, provincia);
    }

    @Test
    @Rollback
    @Transactional
    public void testQueVerificaQueTraeLasProvinciasGuardadas() {
        givenGuardarListaDeProvincias(cantProvincias);
        provincias = whenTraerTodasLasProvincias();
        thenComprueboQueLaCantidadDeProvinciasSeaLaMismaQueGuardada(provincias, cantProvincias);
    }

    @Test
    @Rollback
    @Transactional
    public void eliminarProviciaTest() {
        givenGuardarProvinciaExitosamente(provincia);
        whenEliminoLaProvincia(provincia);
        thenCompruboQueSeHayaEliminadoLaProvincia(provincia);
    }

	private void givenGuardarProvinciaExitosamente(Provincia provincia) {
		repositorioProvincias.save(provincia);
	}
	
	private Provincia whenBuscoLaPresatacionQueGuarde(Provincia provincia) {
		return repositorioProvincias.buscarProvinciaPorId(provincia);
	}
	
	private void thenComparoQueSeanLasMismasLaPrestacionGuardadaConLaObtenida(Provincia guardada, Provincia obtenida) {
        Assert.assertEquals(guardada, obtenida);
	}
	
	private void givenGuardarListaDeProvincias(int cantProvincias) {
        for (int i = 0; i < cantProvincias; i++) {
            Provincia provincia = new Provincia();
            this.provincias.add(provincia);
            repositorioProvincias.save(provincia);
        }
    }

    private List<Provincia> whenTraerTodasLasProvincias() {
        return repositorioProvincias.traerProvincia();
    }

    private void thenComprueboQueLaCantidadDeProvinciasSeaLaMismaQueGuardada(List<Provincia> provincias, int cantProvincias) {
    	Assertions.assertThat((List<?>) provincias).hasSize(24);
    	Assert.assertEquals(provincias.size(), cantProvincias);
        Assertions.assertThat(provincias).hasOnlyElementsOfType(Provincia.class);
        Assertions.assertThat(provincias).isInstanceOf(List.class);
    }

    private void whenActualizoLaProvincia(Provincia provincia) {
        repositorioProvincias.actualizar(provincia);
    }

    private void thenComparoQueLaProvinciaSeHayaActualizado(Provincia original, Provincia actualizada) {
        Assert.assertNotNull(actualizada);
        Assert.assertNotEquals(original, actualizada);
    }

    private void whenEliminoLaProvincia(Provincia provincia) {
        repositorioProvincias.delete(provincia);
    }

    private void thenCompruboQueSeHayaEliminadoLaProvincia(Provincia provincia) {
        var p = repositorioProvincias.buscarProvinciaPorId(provincia);
        Assert.assertNull(p);
    }

    private Provincia clone(Provincia provincia) {
        var clone = new Provincia();
        clone.setId(provincia.getId());
        clone.setNombre(provincia.getNombre());

        return clone;
    }
}
