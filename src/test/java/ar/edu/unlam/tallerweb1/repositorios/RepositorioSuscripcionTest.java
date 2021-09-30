package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.assertj.core.api.Assertions;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioSuscripcionTest extends SpringTest {
    private Suscripcion suscripcion;

    @Before
    public void intanciarSuscripcion() {
        suscripcion = new Suscripcion();
    }

    @Autowired
    public RepositorioSuscripcion repositorioSuscripcion;

    @Test
    @Rollback
    @Transactional
    public void guardarSuscripciones(){
        whenGuardarSuscripcion(suscripcion);
        thenGuardarSuscripcionExitoso(suscripcion);
    }

    private void whenGuardarSuscripcion(Suscripcion suscripcion) {
        repositorioSuscripcion.guardarSuscripcion(suscripcion);
    }

    private void thenGuardarSuscripcionExitoso(Suscripcion suscripcion){

        Assertions.assertThat(repositorioSuscripcion.buscarSuscripcionPorId(suscripcion.getId())).isNotNull();
    }



}
