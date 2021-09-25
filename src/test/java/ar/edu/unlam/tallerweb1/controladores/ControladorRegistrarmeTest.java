package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ControladorRegistrarmeTest {

    private ServicioLogin servicioLogin = mock(ServicioLogin.class);
    private ControladorRegistrarme controladorRegistrarme = new ControladorRegistrarme(servicioLogin);
    private static final DatosRegistro USUARIO_CON_MAIL_INCORRECTO
            = new DatosRegistro("seba.com", "1234", "1234");;
    private static final DatosRegistro USUARIO
            = new DatosRegistro("seba@seba.com", "1234", "1234");

    @Test
    public void puedoRegistrarmeConUsuarioNuevoYClaveCorrecta() {
        givenQueElUsuarioNoExiste(USUARIO);
        ModelAndView mav = whenRegistroElUsuario(USUARIO);
        thenElRegistroEsExitoso(mav);
    }

    @Test
    public void noPuedoRegistrarmeConMailDeUsuarioIncorrecto(){
        ModelAndView mav = whenRegistroElUsuario(USUARIO_CON_MAIL_INCORRECTO);
        thenElRegistroFallaConError(mav, "Registro Fallido por mail incorrecto");
    }

    @Test
    public void alRegistrarmeConUnUsuarioExistenteDaError() throws Exception {
        givenQueElUsuarioExiste(USUARIO);
        ModelAndView mav = whenRegistroElUsuario(USUARIO);
        thenElRegistroFallaConError(mav, "El usuario ya existe");
    }

    private void givenQueElUsuarioExiste(DatosRegistro usuario) throws Exception {
        doThrow(Exception.class).when(servicioLogin).registrar(USUARIO.getEmail(), USUARIO.getClave());
    }

    private void givenQueElUsuarioNoExiste(DatosRegistro usuario) {
    }

    private ModelAndView whenRegistroElUsuario(DatosRegistro datos) {
        return controladorRegistrarme.registrarUsuario(datos);
    }

    private void thenElRegistroEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("redirect:/login");
        assertThat(mav.getModel().get("msg")).isEqualTo("Registro Exitoso");
        assertThat(mav.getModel().get("email")).isEqualTo(USUARIO.getEmail());
    }

    private void thenElRegistroFallaConError(ModelAndView mav, String error) {
        assertThat(mav.getViewName()).isEqualTo("registro-usuario");
        assertThat(mav.getModel().get("msg")).isEqualTo(error);
    }
}
