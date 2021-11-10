/*
package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import java.util.List;
import org.junit.Assert;
import java.util.ArrayList;
import org.mockito.Mockito;
import org.assertj.core.api.Assertions;
import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import static org.assertj.core.api.Assertions.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;


public class ControladorPrestacionTest {
    private ServicioPrestacion servicioPrestacion = Mockito.mock(ServicioPrestacion.class);
    private ServicioUsuario servicioUsuario = Mockito.mock(ServicioUsuario.class);
    private ControladorPerfil controlador = new ControladorPerfil(servicioPrestacion, servicioUsuario);
    private HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    private ControladorPrestacion controladorPrestacion= new ControladorPrestacion(servicioPrestacion,servicioUsuario,request);

    private Long USUARIO_ID = 12L;


    @Test
    public void mostrarHistorialDeContratacionesDeUnUsuario() {
        var prestaciones = givenUsuarioConPrestaciones();
        ModelAndView mav = whenListarPrestacionesDelUsuarioCon();
        thenCompruebaQueSeListaronCorrectamenteLasPrestaciones(mav, prestaciones.size());
    }

    @Test
    public void usuarioCalificaUnPrestacion() throws Exception {
        Prestacion pretacion = giveUnUsuarioConPrestacion();
        ModelAndView mav=whenUsuarioCalifica(pretacion);
        thenCalificaExistosamente(mav);
    }

    @Test
    public void usuarioCalificaConValorFueraDeRango() throws Exception {
        Prestacion prestacion = giveUnUsuarioConPrestacionACalificar();
        ModelAndView mav=whenUsuarioCalifica(prestacion);
        thenCalificaErroneamente(mav);
    }

    private Prestacion giveUnUsuarioConPrestacionACalificar() throws Exception {
        Usuario usuarioConPrestacion = new Usuario();
        Prestacion prestacion = new Prestacion();
        prestacion.setId(10l);
        prestacion.setUsuarioSolicitante(usuarioConPrestacion);
        prestacion.setEstado("finalizado");
        prestacion.setCalificacionDadaPorElCliente(null);

        doThrow(Exception.class).when(servicioPrestacion).ClienteCalificaPrestacion(prestacion.getId(),8);
        return prestacion;
    }

    private void thenCalificaErroneamente(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("redirect:/perfilUsuario");
    }

    private Prestacion giveUnUsuarioConPrestacion() throws Exception {
        Usuario usuarioConPrestacion = new Usuario();

        Prestacion prestacion = new Prestacion();
        prestacion.setId(10l);
        prestacion.setUsuarioSolicitante(usuarioConPrestacion);
        prestacion.setEstado("finalizado");
        prestacion.setCalificacionDadaPorElCliente(null);

        return prestacion;
    }

    private ModelAndView whenUsuarioCalifica(Prestacion prestacion) {
        return controladorPrestacion.clienteCalificaPrestacion(prestacion);
    }

    private void thenCalificaExistosamente(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("redirect:/perfilUsuario");
    }


    private List<Prestacion> givenUsuarioConPrestaciones() {
        var cliente = new Usuario();
        cliente.setId(USUARIO_ID);

        var session = Mockito.mock(HttpSession.class);
        when(session.getAttribute(Mockito.any())).thenReturn(cliente);
        when(request.getSession(true)).thenReturn(session);
        final var prestaciones = new ArrayList<Prestacion>();

        for (int i = 0; i < 10; i++) {
            prestaciones.add(new Prestacion());
        }

        when(servicioPrestacion.listarPrestacionesContratadasPorCliente(cliente.getId())).thenReturn(prestaciones);
        return prestaciones;
    }

    private ModelAndView whenListarPrestacionesDelUsuarioCon() {
        return controlador.mostrarHistorial(request);
    }

    private void thenCompruebaQueSeListaronCorrectamenteLasPrestaciones(ModelAndView mav, int cantPrestaciones) {
        Assert.assertEquals(mav.getViewName(), "perfilUsuario");
        var prestaciones = (List<Prestacion>) mav.getModel().get("historial");
        Assertions.assertThat(prestaciones).isNotNull();
        Assertions.assertThat(prestaciones).isInstanceOf(List.class);
        Assertions.assertThat(prestaciones).hasSize(cantPrestaciones);
    }
}*/
