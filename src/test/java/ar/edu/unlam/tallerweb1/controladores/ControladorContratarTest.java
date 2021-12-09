package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.utils.SessionUtils;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorContratarTest {
    private ServicioPrestacion servicioPrestacion = Mockito.mock(ServicioPrestacion.class);
    private ServicioUsuario servicioUsuario = Mockito.mock(ServicioUsuario.class);
    private ControladorContratar controladorContratar = new ControladorContratar(servicioPrestacion, servicioUsuario);
    private Long idPrestacion=1l;
    private Long idPrestacionFinalizada=20l;

    private Usuario cliente;
    private HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private HttpSession httpSession = Mockito.mock(HttpSession.class);

    @Before
    public void initSession() {
        cliente = new Usuario();
        cliente.setId(1L);

        Mockito.when(httpServletRequest.getSession(Mockito.anyBoolean())).thenReturn(httpSession);
        Mockito.when(httpSession.getAttribute(SessionUtils.USER_LOGGED)).thenReturn(cliente);
    }

    @Test
    public void clienteSinSuscripcionIntentaContratarUnAsistente() {
        final var asistente = givenUnClienteSinSuscripcionYUnAsistente();
        final var mav = whenSeCreaUnaPrestacionCon(asistente.getId());
        thenClienteNoPudoContratarAlAsistentePorNoTenerSuscripcion(mav);
    }

    @Test
    public void clienteConSuscripcionPremiumContratarUnaPrestacionParaSuscripcionBasica() {
        final var asistente = givenClienteConSuscripcionPremiumYUnAsistenteConEspecialidadParaSuscripcionesBasicas(cliente);
        final var mov = whenSeCreaUnaPrestacionCon(asistente.getId());
        thenLaPrestacionSeCreoExitosamanteYMeRedireccionaAlDetalle(mov, cliente, asistente);
    }

    @Test
    public void clienteConSuscripcionBasicaIntentaContratarUnaPrestacionParaSuscripcionPremium() {
        final var asistente = givenClienteConSuscripcionBasicaYUnAsistenteConEspecialidadParaSuscripcionesPremium(cliente);
        final var mav = whenSeCreaUnaPrestacionCon(asistente.getId());
        thenClienteNoPudoContratarPorQueSuTipoSuscripcionNoLePermitio(mav);
    }

    @Test
    public void noSePudoCrearLaPrestacionPorQueNoSeEncontroElAsistente() {
        final var asistenteInexistenteId = 1L;

        givenClientePremiumYUnAsistenteInexistente(cliente);
        final var mov = whenSeCreaUnaPrestacionCon(asistenteInexistenteId);
        thenNoSePudoCrearLaPrestacion(mov);
    }

    /*@Test
    public void finalizarPrestacion() throws Exception {
        Prestacion prestacion = givenPrestacionActiva(idPrestacion);
        ModelAndView mav =whenFinalizaPrestacion(prestacion);
        thenLaPrestacionFinalizoCorrectacmente(mav,prestacion);
    }*/

 /*  @Test
    public void finalizarPrestacionDaError() throws Exception {
       Prestacion prestacionFinalizada = new Prestacion();
       prestacionFinalizada.setId(idPrestacionFinalizada);
       prestacionFinalizada.setEstado("finalizado");

        givenPrestacionFinalizada(prestacionFinalizada);
        ModelAndView mav = whenFinalizaUnaPrestacionQueYaEstaFinalizada(prestacionFinalizada);
        thenPrestacionDaErrorAlFinalizar(mav);
    }*/

    @Test
    public void clienteIntentaContratarAUnMismoAsistenteYaConUnaContratacionEnCurso() {
        final var asistente = new Usuario();
        asistente.setId(103L);

        givenClienteYaContratoAlAsistenteA(cliente, asistente);
        final var mav = whenClienteIntentaContratarAlAsistenteA(asistente, httpServletRequest);
        thenClienteNoPudoContratarAlAsistenteA(mav);
    }

    private void thenPrestacionDaErrorAlFinalizar(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("perfilUsuario");
        assertThat(mav.getModel().get("msgFinalizacionDeContratacionErronea")).isEqualTo("Error al finalizar la Prestacion ");
    }

    private ModelAndView whenFinalizaUnaPrestacionQueYaEstaFinalizada(Prestacion prestacionFinalizada) {
        return controladorContratar.finalizarPrestacion(prestacionFinalizada);
    }

    private void givenPrestacionFinalizada(Prestacion prestacionFinalizada) throws Exception {
        when(servicioPrestacion.prestacionFindById(idPrestacion)).thenReturn(prestacionFinalizada);
        doThrow(Exception.class).when(servicioPrestacion).finalizarPrestacion(prestacionFinalizada);
    }

    private void thenLaPrestacionFinalizoCorrectacmente(ModelAndView mav,Prestacion prestacion ) throws Exception {
       // assertThat(mav.getViewName()).isEqualTo("redirect:/irADetallePrestacionFinalida?prestacion=" + 1l );
        assertThat(mav.getModel().get("msgFinalizacionDeContratacion")).isEqualTo("Prestacion finalizada correctamente");
    }

    private ModelAndView whenFinalizaPrestacion(Prestacion prestacion){
      return controladorContratar.finalizarPrestacion(prestacion);
    }

    private Prestacion givenPrestacionActiva(Long idPrestacion) throws Exception {
        Prestacion prestacion = new Prestacion();
        prestacion.setId(idPrestacion);
        prestacion.setEstado("activo");
        return prestacion;
    }


    private Usuario givenClienteConSuscripcionPremiumYUnAsistenteConEspecialidadParaSuscripcionesBasicas(Usuario cliente) {
        final var premium = new Suscripcion();
        premium.setId(2L);

        cliente.setSuscripcion(premium);

        final var asistente = new Usuario();
        asistente.setId(2L);

        final var especialidad = new Especialidad();
        especialidad.setId(1L);

        final var basica = new Suscripcion();
        basica.setId(1L);

        especialidad.setSuscripcion(basica);

        asistente.setEspecialidad(especialidad);
        Mockito.when(servicioUsuario.usuarioFindById(Matchers.any())).thenReturn(asistente);

        return asistente;
    }

    private ModelAndView whenSeCreaUnaPrestacionCon(Long asistenteId) {
        return controladorContratar.contratarPrestacion(asistenteId, httpServletRequest);
    }

    private void thenLaPrestacionSeCreoExitosamanteYMeRedireccionaAlDetalle(ModelAndView detalle, Usuario cliente, Usuario asistente) {
        Assert.assertEquals(detalle.getViewName(), "detalle-contratacion");
        var prestacion = detalle.getModel().get("prestacion");
        Assert.assertNotNull(prestacion);
        Assert.assertTrue(prestacion instanceof Prestacion);
        Assert.assertEquals(((Prestacion) prestacion).getUsuarioSolicitante(), cliente);
        Assert.assertEquals(((Prestacion) prestacion).getUsuarioAsistente(), asistente);
    }

    private void givenClientePremiumYUnAsistenteInexistente(Usuario cliente) {
        final var premium = new Suscripcion();
        premium.setId(1L);

        cliente.setSuscripcion(premium);

        Mockito.when(servicioUsuario.usuarioFindById(Matchers.any())).thenReturn(null);
    }

    private void thenNoSePudoCrearLaPrestacion(ModelAndView view) {
        Assert.assertEquals(view.getViewName(), "detalle-contratacion");
        Assert.assertEquals(view.getModel().get("error"), "No se pudo encontrar los datos del asistente para completar la operacion");
    }

    private void givenClienteYaContratoAlAsistenteA(Usuario cliente, Usuario asistente) {
        final var prestacion = new Prestacion();
        prestacion.setUsuarioSolicitante(cliente);
        prestacion.setUsuarioAsistente(asistente);
        prestacion.setEstado(PrestacionEstado.ACTIVO.getEstado());

        final var prestaciones = new ArrayList<Prestacion>();
        prestaciones.add(prestacion);

        Mockito.when(servicioUsuario.usuarioFindById(asistente.getId())).thenReturn(asistente);
        Mockito.when(servicioPrestacion.getAll()).thenReturn(prestaciones);
    }

    private ModelAndView whenClienteIntentaContratarAlAsistenteA(Usuario asistente, HttpServletRequest httpServletRequest) {
        return controladorContratar.contratarPrestacion(asistente.getId(), httpServletRequest);
    }

    private void thenClienteNoPudoContratarAlAsistenteA(ModelAndView mav) {
        Assertions.assertThat(mav).isNotNull();
        final var model = mav.getModel();
        Assertions.assertThat(model).isNotNull();
        Assertions.assertThat(model.get("error")).isNotNull();
    }

    private Usuario givenClienteConSuscripcionBasicaYUnAsistenteConEspecialidadParaSuscripcionesPremium(Usuario cliente) {
        final var basica = new Suscripcion();
        basica.setId(1L);

        cliente.setSuscripcion(basica);

        final var asistente = new Usuario();
        asistente.setId(2L);

        final var especialidad = new Especialidad();
        especialidad.setId(1L);

        final var premium = new Suscripcion();
        premium.setId(2L);

        especialidad.setSuscripcion(premium);

        asistente.setEspecialidad(especialidad);
        Mockito.when(servicioUsuario.usuarioFindById(asistente.getId())).thenReturn(asistente);

        return asistente;
    }

    private void thenClienteNoPudoContratarPorQueSuTipoSuscripcionNoLePermitio(ModelAndView modelAndView) {
        Assert.assertNotNull(modelAndView);
        Assert.assertEquals(modelAndView.getViewName(), "detalle-contratacion");

        final var error = modelAndView.getModel().get("error");
        Assert.assertNotNull(error);
        Assert.assertEquals(error, "Necesitas una suscripción Premium para realizar la contratación");
    }

    private Usuario givenUnClienteSinSuscripcionYUnAsistente() {
        final var asistente = new Usuario();
        asistente.setId(2L);

        final var especialidad = new Especialidad();
        especialidad.setId(1L);

        final var basica = new Suscripcion();
        basica.setId(1L);

        especialidad.setSuscripcion(basica);
        asistente.setEspecialidad(especialidad);

        Mockito.when(servicioUsuario.usuarioFindById(asistente.getId())).thenReturn(asistente);

        return asistente;
    }

    private void thenClienteNoPudoContratarAlAsistentePorNoTenerSuscripcion(ModelAndView modelAndView) {
        Assert.assertNotNull(modelAndView);
        Assert.assertEquals(modelAndView.getViewName(), "detalle-contratacion");

        final var error = modelAndView.getModel().get("error");
        Assert.assertEquals(error, "Necesitas tener una subscripción para contratar un servicio");
    }
}