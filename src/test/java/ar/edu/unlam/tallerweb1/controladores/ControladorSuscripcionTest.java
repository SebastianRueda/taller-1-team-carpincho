package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioSuscripcion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorSuscripcionTest {

    private static final String EMAIL = "emiliano@gmail.com";
    private ServicioSuscripcion servicioSuscripcion = mock(ServicioSuscripcion.class);
    private ServicioUsuario servicioUsuario = mock(ServicioUsuario.class);
    private ControladorSuscripcion controladorSuscripcion = new ControladorSuscripcion(servicioSuscripcion, servicioUsuario);


    @Test
    public void usuarioCancelaSuscripcion() throws Exception {
        givenUsuarioConSuscripcionbasica(EMAIL);
        ModelAndView mav = whenUsuarioCancelaSuSuscripcion(EMAIL);
        thenCancelacionDeSuscripcionBasicaExitosa(mav);
    }

    @Test
    public void UsuarioSinSuscripcionIntentaCancelar() throws Exception {
        givenUsuarioSinSuscripcion(EMAIL);
        ModelAndView mav = whenUsuarioCancelaSuSuscripcion(EMAIL);
        thenCancelacionDeSuscripcionDaError(mav);
    }

    private void givenUsuarioSinSuscripcion(String email) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);

        doThrow(Exception.class).when(servicioSuscripcion).cancelarSuscripcion(email);
    }

    private void givenUsuarioConSuscripcionbasica(String email) throws Exception {
        Usuario usuario = new Usuario();
        Suscripcion suscripcionBasica = new Suscripcion();
        usuario.setEmail(email);
        usuario.setSuscripcion(suscripcionBasica);
        when(servicioUsuario.buscarUsuarioPorMail(email)).thenReturn(usuario);
    }

    private ModelAndView whenUsuarioCancelaSuSuscripcion(String email) {
        ModelAndView mav = controladorSuscripcion.cancelarSuscripcion(email);
        return mav;
    }

    private void thenCancelacionDeSuscripcionDaError(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("perfilUsuario");
        assertThat(mav.getModel().get("msgCancelacionErronia")).isEqualTo("¡No tienes una Suscripcion!");
    }

    private void thenCancelacionDeSuscripcionBasicaExitosa(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("perfilUsuario");
        assertThat(mav.getModel().get("msgCancelacionExitosa")).isEqualTo(null);//cambiar null por mensaje
    }

}
