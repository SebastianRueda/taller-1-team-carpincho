package ar.edu.unlam.tallerweb1;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.utils.SessionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtilsTest {
    private HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private HttpSession httpSession = new HttpSessionFake();

    @Test
    public void crearSesionTest() {
        Usuario dado = givenUsuarioGuardadoEnSession();
        Usuario obtenido = whenTraigoElUsuarioEnSession();
        thenCompruboQueElUsuarioEnSessionSeaCorrecto(dado, obtenido);
    }

    @Test
    public void cerrarSesionTest() {
        givenUsuarioGuardadoEnSession();
        whenCierroLaSesion();
        Usuario obtenito = SessionUtils.getCurrentUserSession(httpServletRequest);
        thenComprueboQueLaSesionSeHayaCerrado(obtenito);
    }

    private Usuario givenUsuarioGuardadoEnSession() {
        var usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Noob Saibot");

        Mockito.when(httpServletRequest.getSession(true)).thenReturn(httpSession);
        Mockito.when(httpServletRequest.getSession()).thenReturn(httpSession);

        SessionUtils.createSession(httpServletRequest, usuario);

        return usuario;
    }

    private Usuario whenTraigoElUsuarioEnSession() {
        return SessionUtils.getCurrentUserSession(httpServletRequest);
    }

    private void thenCompruboQueElUsuarioEnSessionSeaCorrecto(Usuario dado, Usuario obtenido) {
        Assert.assertEquals(dado, obtenido);
    }

    private void whenCierroLaSesion() {
        SessionUtils.closeSession(httpServletRequest);
    }

    private void thenComprueboQueLaSesionSeHayaCerrado(Usuario obtenito) {
        Assert.assertNull(obtenito);
    }
}
