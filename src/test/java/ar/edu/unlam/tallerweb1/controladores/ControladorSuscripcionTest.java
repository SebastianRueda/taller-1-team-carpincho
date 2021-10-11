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

    private static final String EMAIL= "emiliano@gmail.com";
    private ServicioSuscripcion servicioSuscripcion = mock(ServicioSuscripcion.class);
    private ServicioUsuario servicioUsuario = mock(ServicioUsuario.class);
    private ControladorSuscripcion controladorSuscripcion = new ControladorSuscripcion(servicioSuscripcion,servicioUsuario);


// @Test
// public void usuarioCancelaSuSuscripcion() throws Exception {
//     givenUsuarioConSuscripcion(EMAIL);
//     ModelAndView mav = whenUsuarioCancelaSuscripcion(EMAIL);
//     thenCancelacionDeSuscripcionExitosa(mav);
// }
 @Test
 public void UsuarioSinSuscripcionIntentaCancelar() throws Exception {
     givenUsuarioSinSuscripcion(EMAIL);
    ModelAndView mav = whenUsuarioCancelaSuscripcion(EMAIL);
    thenCancelacionDeSuscripcionDaError(mav);

 }

    private void thenCancelacionDeSuscripcionDaError(ModelAndView mav) {

     assertThat(mav.getViewName()).isEqualTo("redirect:/suscripcion");
     assertThat(mav.getModel().get("msg")).isEqualTo("El Usuario no tiene una Suscripcion");
    }


    private void givenUsuarioSinSuscripcion(String email) throws Exception {
     doThrow(Exception.class).when(servicioSuscripcion).cancelarSuscripcion(email);

    }

    private void givenUsuarioConSuscripcion(String email) throws Exception {
        Usuario usuario= new Usuario();
        Suscripcion suscripcion = new Suscripcion();
        usuario.setSuscripcion(suscripcion);


    }

    private ModelAndView whenUsuarioCancelaSuscripcion(String email) {

        return controladorSuscripcion.cancelarSuscripcion(email);
    }
    private void thenCancelacionDeSuscripcionExitosa(ModelAndView mav) {
     assertThat(mav.getViewName()).isEqualTo("redirect:/traerEspecialidades");
     assertThat(mav.getModel().get("msg")).isEqualTo("Suscripcion Cancelada");
    }
}
