package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSuscripcion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioSuscripcionTest {
    public static final String EMAIL1 = "emiliano";
    private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
    private RepositorioSuscripcion repositorioSuscripcion = mock(RepositorioSuscripcion.class);
    private ServicioSuscripcion servicioSuscripcion = new ServicioSuscripcionImpl
                                                        (repositorioSuscripcion,repositorioUsuario);
    private static final String EMAIL = "emiliano@hotmail.com";

    @Test
    public void cancelarSuscripcionDeUnUsuarioQueTieneUna() throws Exception{
        givenUsuarioConSuscripcion(EMAIL);
        whenUsuarioCancelaSuSuscripcion(EMAIL);
        thenVerfificoQueSeLlamoALmenosUnaVezAlMetodoCancelar();

    }


    @Test(expected = Exception.class)
    public void UsuarioSinSuscripcionNoPuedeCancelar() throws Exception {
        givenUsuarioSinSuscripcion(EMAIL);
        whenUsuarioQuiereCancelarSuscripcion(EMAIL);

    }
    @Test
    public void usuarioModificaSuSuscripcion() throws Exception {
        givenUsuarioConSuscripcion(EMAIL);
        whenUsuarioModificaSuSuscripcion(EMAIL);
        thenVerfificoQueSeLlamoALmenosUnaVezAlMetodoModificarSuscripcion();
    }
    @Test(expected = Exception.class)
    public void usuarioSinSuscripcionIntentaModificarUna() throws Exception {
        givenUsuarioSinSuscripcion(EMAIL);
        whenUsuarioModificaSuSuscripcion(EMAIL);

    }

    private void thenVerfificoQueSeLlamoALmenosUnaVezAlMetodoModificarSuscripcion() {
        verify(repositorioUsuario,times(1)).modificar(anyObject());
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
    private void whenUsuarioModificaSuSuscripcion(String email) throws Exception {
        servicioSuscripcion.modificarSuscripcion(email);
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
