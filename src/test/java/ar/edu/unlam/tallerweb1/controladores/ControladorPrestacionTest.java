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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class ControladorPrestacionTest {
    private ServicioPrestacion servicioPrestacion = Mockito.mock(ServicioPrestacion.class);
    private ServicioUsuario servicioUsuario = Mockito.mock(ServicioUsuario.class);

    private ControladorPerfil controlador = new ControladorPerfil(servicioPrestacion, servicioUsuario);

    private HttpServletRequest request = Mockito.mock(HttpServletRequest.class);

    private Long USUARIO_ID = 12L;


    @Test
    public void mostrarHistorialDeContratacionesDeUnUsuario() {
        var prestaciones = givenUsuarioConPrestaciones();
        ModelAndView mav = whenListarPrestacionesDelUsuarioCon();
        thenCompruebaQueSeListaronCorrectamenteLasPrestaciones(mav, prestaciones.size());
    }

    private List<Prestacion> givenUsuarioConPrestaciones() {
        var cliente = new Usuario();
        cliente.setId(USUARIO_ID);

        var session = Mockito.mock(HttpSession.class);
        Mockito.when(session.getAttribute(Mockito.any())).thenReturn(cliente);

        Mockito.when(request.getSession(true)).thenReturn(session);

        final var prestaciones = new ArrayList<Prestacion>();

        for (int i = 0; i < 10; i++) {
            prestaciones.add(new Prestacion());
        }

        Mockito.when(servicioPrestacion.listarPrestacionesContratadasPorCliente(cliente.getId())).thenReturn(prestaciones);

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
}