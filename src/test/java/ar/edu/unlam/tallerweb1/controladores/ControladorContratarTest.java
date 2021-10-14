package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

public class ControladorContratarTest {
    ServicioPrestacion servicioPrestacion = Mockito.mock(ServicioPrestacion.class);
    ServicioUsuario servicioUsuario = Mockito.mock(ServicioUsuario.class);
    ControladorContratar controladorContratar = new ControladorContratar(servicioPrestacion, servicioUsuario);

    @Test
    public void crearPrestacionTest() {
        final var asistente = givenElAsistenteExiste();
        final var mov = whenSeCreaUnaPrestacionCon(asistente);
        thenLaPrestacionSeCreoExitosamanteYMeRedireccionaAlDetalle(mov);
    }

    @Test
    public void noSePudoCrearLaPrestacionPorQueNoSeEncontroElAsistente() {
        final var asistente = givenNoSeEncontroAlAsistente();
        final var mov = whenSeCreaUnaPrestacionCon(asistente);
        thenNoSePudoCrearLaPrestacion(mov);
    }

    private Usuario givenElAsistenteExiste() {
        var asistente = new Usuario();

        Mockito.when(servicioUsuario.usuarioFindById(Matchers.any())).thenReturn(asistente);

        return asistente;
    }

    private ModelAndView whenSeCreaUnaPrestacionCon(Usuario asistente) {
        return controladorContratar.contratarPrestacion(asistente.getId());
    }

    private void thenLaPrestacionSeCreoExitosamanteYMeRedireccionaAlDetalle(ModelAndView detalle) {
        Assert.assertEquals(detalle.getViewName(), "detalle-contratacion");
        Assert.assertNotNull(detalle.getModel().get("prestacion"));
    }

    private Usuario givenNoSeEncontroAlAsistente() {
        final var asistente = new Usuario();

        Mockito.when(servicioUsuario.usuarioFindById(Matchers.any())).thenReturn(null);

        return asistente;
    }

    private void thenNoSePudoCrearLaPrestacion(ModelAndView view) {
        Assert.assertEquals(view.getViewName(), "detalle-contratacion");
        Assert.assertEquals(view.getModel().get("error"), "No se pudo encontrar los datos del asistente para completar la operación");
    }
}