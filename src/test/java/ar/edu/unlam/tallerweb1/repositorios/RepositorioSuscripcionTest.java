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

    private Suscripcion suscripcion= new Suscripcion();
    private Usuario usuario= new Usuario();

    @Autowired
    public RepositorioSuscripcion repositorioSuscripcion;

    @Autowired
    public RepositorioUsuario repositorioUsuario;

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

    @Test
    @Rollback
    @Transactional
    public void usuarioContratasuscripcionExitosamente(){
        Suscripcion suscripcion = givenUnaSuscripcion();
        Usuario usuario = givenUnUsuario();
        whenUsuarioContrataSuscripcion(suscripcion,usuario );
        thenContratacionExitosa();
    }

    @Test
    @Rollback
    @Transactional
    public void usuarioDaDeBajasuscripcionExitosamente(){
        Usuario usuario = givenUnUsuarioConSuscripcion();
        whenUsuarioDaDeBajaSuscripcion(usuario);
        thenCancelacionExitosa(usuario);
    }

    private void thenCancelacionExitosa(Usuario usuario) {
        assertThat(usuario.getSuscripcion()).isNull();
    }

    private void whenUsuarioDaDeBajaSuscripcion(Usuario usuario) {
        usuario.setSuscripcion(null);
        repositorioUsuario.modificar(usuario);
    }

    private Usuario givenUnUsuarioConSuscripcion() {
        this.suscripcion.setId(10l);
        this.suscripcion.setDescripcion("mega");
        repositorioSuscripcion.guardarSuscripcion(suscripcion);

        this.usuario.setId(10l);
        this.usuario.setEmail("lea@lea.com");
        this.usuario.setSuscripcion(suscripcion);
        repositorioUsuario.guardarUsuario(usuario);

        return usuario;
    }

    private Suscripcion givenUnaSuscripcion() {
        //Suscripcion suscripcion = new Suscripcion();
        this.suscripcion.setId(3l);
        this.suscripcion.setDescripcion("mega");

        repositorioSuscripcion.guardarSuscripcion(suscripcion);

        return suscripcion;
    }

    private Usuario givenUnUsuario() {
        //Usuario usuario = new Usuario();
        //this.usuario.setId(5l);
        this.usuario.setEmail("lea@lea.com");
        repositorioUsuario.guardar(usuario);
        return usuario;
    }

    private void whenUsuarioContrataSuscripcion(Suscripcion suscripcion, Usuario usuario) {
        usuario.setSuscripcion(suscripcion);
        repositorioUsuario.modificar(usuario);
    }

    private void thenContratacionExitosa() {
        assertThat(this.usuario.getSuscripcion().getId()).isEqualTo(suscripcion.getId());
    }

}
