package ar.edu.unlam.tallerweb1.controladores;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import java.util.ArrayList;
import org.mockito.Mockito;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Provincia;
import ar.edu.unlam.tallerweb1.utils.SessionUtils;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioProvincia;
import ar.edu.unlam.tallerweb1.modelo.request.EditarUsuarioRequest;


public class ControladorEditarUsuarioTest {
    private Usuario usuario;

    private HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private HttpSession httpSession = Mockito.mock(HttpSession.class);

    private ServicioUsuario servicioUsuario = Mockito.mock(ServicioUsuario.class);
    private ServicioProvincia servicioProvincia = Mockito.mock(ServicioProvincia.class);
    private ControladorEditarUsuario controladorEditarUsuario = new ControladorEditarUsuario(servicioUsuario, servicioProvincia);

    @Before
    public void setupUsuario() {
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("nombre");
        usuario.setApellido("apellido");
        usuario.setEmail("email");

        final var provincia = new Provincia();
        provincia.setId(1L);
        provincia.setNombre("provincia");

        usuario.setProvincia(provincia);
    }

    @Before
    public void setupSession() {
        Mockito.when(httpSession.getAttribute(SessionUtils.USER_LOGGED)).thenReturn(usuario);
        Mockito.when(httpServletRequest.getSession(Mockito.anyBoolean())).thenReturn(httpSession);
    }

    @Test
    public void irAEditarUsuarioTest() {
        final var mav = whenSeALaVistaDeEditarDatos();
        thenLaVistaSeVisualizoCorrectamente(mav);
    }

    @Test
    public void editarDatosDelUsuarioTest() {
        final var request = givenLosDatosModificadosDelUsuario();
        final var mav = whenSeIntentaModificarLosDatosDelUsuario(httpServletRequest, request);
        thenSeGuardaronLosDatosDelUsuarioCorrectamente(mav);
    }

    @Test
    public void redireccionaAlHomeCuandoNohayUnUsuarioLogueado() {
        givenUnUsuarioDeslogueado();
        final var mav = whenSeALaVistaDeEditarDatos();
        thenSeRedireccionaAlHome(mav);
    }

    private EditarUsuarioRequest givenLosDatosModificadosDelUsuario() {
        final var request = new EditarUsuarioRequest();
        request.setNombre("nombre editado");
        request.setApellido("apellido editado");
        request.setEmail("email editado");

        request.setProvinciaId(2L);

        return request;
    }

    private ModelAndView whenSeIntentaModificarLosDatosDelUsuario(HttpServletRequest httpServletRequest, EditarUsuarioRequest request) {
        Mockito.when(servicioProvincia.traerProvincia()).thenReturn(new ArrayList<>());

        return controladorEditarUsuario.editarUsuario(httpServletRequest, request);
    }

    private void thenSeGuardaronLosDatosDelUsuarioCorrectamente(ModelAndView model) {
        Assert.assertNotNull(model);
        Assert.assertEquals(model.getViewName(), "redirect:/perfilUsuario");
    }

    private ModelAndView whenSeALaVistaDeEditarDatos() {
        return controladorEditarUsuario.irAEditarUsuario(httpServletRequest);
    }

    private void thenLaVistaSeVisualizoCorrectamente(ModelAndView modelAndView) {
        Assert.assertNotNull(modelAndView);
        Assert.assertEquals(modelAndView.getViewName(), "editarUsuario");

        final var model = modelAndView.getModel();
        Assert.assertNotNull(model);

        final var request = model.get("request");
        Assert.assertNotNull(request);
        Assert.assertTrue(request instanceof EditarUsuarioRequest);

        final var _usuario = model.get("usuario");
        Assert.assertNotNull(_usuario);
        Assert.assertTrue(_usuario instanceof Usuario);
        Assert.assertEquals(_usuario, usuario);

        Assert.assertNotNull(model.get("provincias"));
    }

    private void givenUnUsuarioDeslogueado() {
        Mockito.when(httpSession.getAttribute(SessionUtils.USER_LOGGED)).thenReturn(null);
    }

    private void thenSeRedireccionaAlHome(ModelAndView modelAndView) {
        Assert.assertNotNull(modelAndView);
        Assert.assertEquals(modelAndView.getViewName(), "redirect:/");
    }
}
