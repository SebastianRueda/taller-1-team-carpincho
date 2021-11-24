package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFactura;
import ar.edu.unlam.tallerweb1.servicios.ServicioSuscripcion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorSuscripcionTest {

    private static final String EMAIL = "emiliano@gmail.com";
    private Long idSuscripcionPremium=2l;
    private Long idSuscripcionBasica=1l;
    private String nombreSuscripcionPremium = "suscripcion premium";
    private String nombreSuscripcionBasica = "suscripcion basica";
    private ServicioSuscripcion servicioSuscripcion = mock(ServicioSuscripcion.class);
    private ServicioUsuario servicioUsuario = mock(ServicioUsuario.class);
    private HttpServletRequest request = mock(HttpServletRequest.class);
    private ServicioFactura servicioFactura= mock(ServicioFactura.class);
    private ControladorSuscripcion controladorSuscripcion = new ControladorSuscripcion(request,servicioSuscripcion, servicioUsuario,servicioFactura);
    private HttpSession session = Mockito.mock(HttpSession.class);

    public void crearSession(Usuario usuario){

        when(session.getAttribute(Mockito.any())).thenReturn(usuario);
        when(request.getSession(true)).thenReturn(session);
    }


    @Test
    public void contratarSuscripcionTest(){
        Suscripcion suscripcion =givenUsuarioConSuscripcion();
      ModelAndView mav=  whenUsuarioContrataSuscripcionYSeGeneraUnaFactura(suscripcion);
        thenContratacionDeSuscripcionYGeneracionDeFacturaExitosa(mav);
    }

    private void thenContratacionDeSuscripcionYGeneracionDeFacturaExitosa(ModelAndView mav) {
        String ruta = "redirect:/perfilUsuario";
        assertThat(mav.getViewName()).isEqualTo(ruta);
    }

    private ModelAndView whenUsuarioContrataSuscripcionYSeGeneraUnaFactura(Suscripcion suscripcion) {
        return    controladorSuscripcion.contratarSuscripcion(suscripcion);

    }

    private Suscripcion  givenUsuarioConSuscripcion() {
        Usuario usuario = new Usuario();
        Suscripcion suscripcionBasica = new Suscripcion();
        usuario.setEmail(EMAIL);
        usuario.setSuscripcion(suscripcionBasica);
        crearSession(usuario);

        Suscripcion suscripcion= new Suscripcion();
        suscripcion.setId(1l);
        suscripcion.setDescripcion(this.nombreSuscripcionBasica);
        when(servicioSuscripcion.buscarPorNombre(this.nombreSuscripcionBasica)).thenReturn(suscripcion);

        return suscripcion;
    }

    @Test
    public void usuarioCancelaSuscripcion() throws Exception {
        givenUsuarioConSuscripcionbasica(EMAIL);
        ModelAndView mav = whenUsuarioCancelaSuSuscripcion(EMAIL);
        thenCancelacionDeSuscripcionBasicaExitosa(mav);
    }

    @Test
    public void usuarioSinSuscripcionIntentaCancelar() throws Exception {
        givenUsuarioSinSuscripcion(EMAIL);
        ModelAndView mav = whenUsuarioCancelaSuSuscripcion(EMAIL);
        thenCancelacionDeSuscripcionDaError(mav);
    }

    @Test
    public void usuarioConSuscripcionBasicaCambiaAPremium() throws Exception {
        givenUsuarioConSuscripcionbasica(EMAIL);
        ModelAndView mav = whenUsuarioCambiaSuSuscripcionBasicaPorUnaPremium();
        thenUpgradeDeSuscripcionBasicaExitosa(mav);
    }

    @Test
    public void usuarioConSuscripcionBasicaQuiereCAmbiarABasica() throws Exception {
        givenUsuarioConSuscripcionbasicaQueIntentaModificarPorLaMismaSuscripcion(EMAIL);
        ModelAndView mav = whenUsuarioConSuscripcionBasicaIntentaCambiarASuscripcionBasica();
        thenUpgradeDeSuscripcionBasicaFallida(mav);


    }
    ///////////////////////////////


    private void givenUsuarioConSuscripcionbasicaQueIntentaModificarPorLaMismaSuscripcion(String email) throws Exception {
      Usuario usuario = new Usuario();
       crearSession(usuario);
        doThrow(Exception.class).when(servicioSuscripcion).modificarSuscripcionBasicaAPremium(anyString(),anyObject() );
    }

    private void givenUsuarioSinSuscripcion(String email) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        crearSession(usuario);
        doThrow(Exception.class).when(servicioSuscripcion).cancelarSuscripcion(email);
    }

    private void givenUsuarioConSuscripcionbasica(String email) throws Exception {
        Usuario usuario = new Usuario();
        Suscripcion suscripcionBasica = new Suscripcion();
        usuario.setEmail(email);
        usuario.setSuscripcion(suscripcionBasica);

        crearSession(usuario);
        when(servicioUsuario.buscarUsuarioPorMail(email)).thenReturn(usuario);

    }
/////////////////////////////
    private ModelAndView whenUsuarioCancelaSuSuscripcion(String email) {
        ModelAndView mav = controladorSuscripcion.cancelarSuscripcion(email);
        return mav;
    }

    private ModelAndView whenUsuarioCambiaSuSuscripcionBasicaPorUnaPremium() {
        return controladorSuscripcion.modificarSuscripcionBasicaAPremium();
    }

    private ModelAndView whenUsuarioConSuscripcionBasicaIntentaCambiarASuscripcionBasica() {
        return  controladorSuscripcion.modificarSuscripcionBasicaAPremium();
    }
    /////////////////////////////
    private void thenCancelacionDeSuscripcionDaError(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("redirect:/perfilUsuario");
        assertThat(mav.getModel().get("msgCancelacionErronia")).isEqualTo("No tienes una Suscripcion");
    }
    private void thenCancelacionDeSuscripcionBasicaExitosa(ModelAndView mav) {
       assertThat(mav.getViewName()).isEqualTo("redirect:/perfilUsuario");
    }

    private void thenUpgradeDeSuscripcionBasicaExitosa(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("redirect:/perfilUsuario");
    }


    private void thenUpgradeDeSuscripcionBasicaFallida(ModelAndView mav) throws Exception {
        assertThat(mav.getViewName()).isEqualTo("redirect:/perfilUsuario");
    }


}
