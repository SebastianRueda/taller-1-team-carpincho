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
    private Long idSuscripcionPremium=2l;
    private Long idSuscripcionBasica=1l;
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
//////////////////////////////////////////////////////////////////////////
    }
    @Test
    public void usuarioModificaSuSuscripcionBasicaAPremium() throws Exception {
        givenUsuarioConSuscripcionBasica(EMAIL);
        whenUsuarioModificaSuSuscripcionBasicaAPremium(EMAIL, idSuscripcionPremium);
        thenVerfificoQueSeLlamoALmenosUnaVezAlMetodoModificarSuscripcion();
    }

    @Test(expected = Exception.class)
    public void usuarioSinSuscripcionIntentaModificarUna() throws Exception {
        givenUsuarioSinSuscripcion(EMAIL);
        whenUsuarioModificaSuSuscripcion(EMAIL, idSuscripcionBasica);

    }

//////////////////////////////////////////////////////////////////////////

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
    private void whenUsuarioModificaSuSuscripcionBasicaAPremium(String email, Long idSuscripcionPremium) throws Exception {
        servicioSuscripcion.modificarSuscripcionBasicaAPremium(email, idSuscripcionPremium);
    }
    private void whenUsuarioModificaSuSuscripcion(String email , Long idSuscripcionPremium) throws Exception {
        servicioSuscripcion.modificarSuscripcionBasicaAPremium(email , idSuscripcionPremium);
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
    private void givenUsuarioConSuscripcionBasica(String email) {
        Usuario usuario = new Usuario();
        Suscripcion suscripcion = new Suscripcion();
        suscripcion.setId(idSuscripcionBasica);
        suscripcion.setDescripcion("suscripcion basica");
        usuario.setSuscripcion(suscripcion);
        when(repositorioUsuario.buscarUsuarioPorMail(email)).thenReturn(usuario);



    }
}
