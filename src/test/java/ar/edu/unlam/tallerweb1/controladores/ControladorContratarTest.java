package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.utils.UsuarioCache;
import org.junit.Assert;
import org.junit.Before;
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
        givenElAsistenteExiste();
        var mov = whenElUsuarioSeleccionaUnAsistenteParaRealizarElServicio();
        thenLaPrestacionSeCreoExitosamanteYMeRedireccionaAlDetalle(mov);
    }

    private void givenElAsistenteExiste() {
        Mockito.when(servicioUsuario.usuarioFindById(Matchers.any())).thenReturn(new Usuario());
    }

    private ModelAndView whenElUsuarioSeleccionaUnAsistenteParaRealizarElServicio() {
        return controladorContratar.contratarPrestacion(Matchers.any());
    }

    private void thenLaPrestacionSeCreoExitosamanteYMeRedireccionaAlDetalle(ModelAndView detalle) {
        Assert.assertEquals(detalle.getViewName(), "detalle-contratacion");
        Assert.assertNotNull(detalle.getModel().get("prestacion"));
    }
}
