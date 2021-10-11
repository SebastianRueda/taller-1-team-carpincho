package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSuscripcion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioSuscripcionTest {
    private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
    private RepositorioSuscripcion repositorioSuscripcion = mock(RepositorioSuscripcion.class);
    private ServicioSuscripcion servicioSuscripcion = new ServicioSuscripcionImpl
                                                        (repositorioSuscripcion,repositorioUsuario);


    @Test
    public void cancelarSuscripcionDeUnUsuarioQueTieneUna() throws Exception{
        givenUsuarioConSuscripcion("emiliano");
        whenUsuarioCancelaSuSuscripcion("emiliano");
        thenVerfificoQueSeLlamoALmenosUnaVezAlMetodoCancelar();

    }


    @Test(expected = Exception.class)
    public void UsuarioSinSuscripcionNoPuedeCancelar() throws Exception {
        givenUsuarioSinSuscripcion("emiliano");
        whenUsuarioQuiereCancelarSuscripcion("emiliano");

    }


    private void thenVerfificoQueSeLlamoALmenosUnaVezAlMetodoCancelar() throws Exception {

        verify(repositorioUsuario,times(1)).modificar(anyObject());
    }


    public void whenUsuarioQuiereCancelarSuscripcion(String email) throws Exception{
        servicioSuscripcion.cancelarSuscripcion(email);
    }
    private void whenUsuarioCancelaSuSuscripcion(String emiliano) throws Exception {
        servicioSuscripcion.cancelarSuscripcion(emiliano);
    }

    private void givenUsuarioConSuscripcion(String email) {
        Usuario usuario = new Usuario();
        Suscripcion suscripcion = new Suscripcion();
        usuario.setSuscripcion(suscripcion);
        when(repositorioUsuario.buscarUsuarioPorMail(email)).thenReturn(usuario);

    }
    private void givenUsuarioSinSuscripcion(String email) {

        when(repositorioUsuario.buscarUsuarioPorMail(email)).thenReturn(new Usuario());
    }
}
