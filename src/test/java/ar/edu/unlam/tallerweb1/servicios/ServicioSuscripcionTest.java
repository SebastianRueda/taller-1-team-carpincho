package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSuscripcion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioSuscripcionTest {
    private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
    private RepositorioSuscripcion repositorioSuscripcion = mock(RepositorioSuscripcion.class);
    private ServicioSuscripcion servicioSuscripcion = new ServicioSuscripcionImpl
                                                        (repositorioSuscripcion,repositorioUsuario);

    @Test
    public void cancelarSuscripcionDeUnUsuario() throws Exception {
        givenUsuarioConSuscripcion("emiliano");
       Usuario usuarioSinSuscripcion = whenCanceloSuscripcionDelUsuario("emiliano");
        thenBuscoAlUsuarioYVerificoQueNoTieneSuscripcion(usuarioSinSuscripcion);

    }

    @Test(expected = Exception.class)
    public void UsuarioSinSuscripcionNoPuedeCancelar() throws Exception {
        givenUsuarioSinSuscripcion("emiliano");
        whenUsuarioQuiereCancelarSuscripcion("emiliano");

    }
    public void whenUsuarioQuiereCancelarSuscripcion(String email) throws Exception{
        servicioSuscripcion.cancelarSuscripcion(email);
    }

    private void givenUsuarioSinSuscripcion(String email) {
        when(repositorioUsuario.buscar(email)).thenReturn(new Usuario());
    }

    private void thenBuscoAlUsuarioYVerificoQueNoTieneSuscripcion(Usuario usuario) {
        assertThat(usuario.getSuscripcion()).isNull();
        assertThat(usuario).isNotNull();

    }

    private Usuario whenCanceloSuscripcionDelUsuario(String email) throws Exception {

        return servicioSuscripcion.cancelarSuscripcion(email);

    }

    private void givenUsuarioConSuscripcion(String email) {
        Usuario usuario = new Usuario();
        Suscripcion suscripcion = new Suscripcion();
        usuario.setSuscripcion(suscripcion);
        when(repositorioUsuario.buscar(email)).thenReturn(usuario);

    }
}
