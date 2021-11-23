package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.request.AgregarRemoverAsistenteFavoritoRequest;
import ar.edu.unlam.tallerweb1.servicios.ServicioDenunciaL;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.utils.SessionUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ControlladorPerfilTest {
    private ServicioPrestacion servicioPrestacion = Mockito.mock(ServicioPrestacion.class);
    private ServicioUsuario servicioUsuario = Mockito.mock(ServicioUsuario.class);
    private ServicioDenunciaL servicioDenuncia = Mockito.mock(ServicioDenunciaL.class);
    private ServicioFavoritos servicioFavoritos = Mockito.mock(ServicioFavoritos.class);
    private ControladorPerfil controladorPerfil = new ControladorPerfil(servicioPrestacion, servicioUsuario,
            servicioDenuncia, servicioFavoritos);

    private static HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private static HttpSession httpSession = Mockito.mock(HttpSession.class);

    @BeforeClass
    public static void setupSesion() {
        Mockito.when(httpServletRequest.getSession(Mockito.anyBoolean())).thenReturn(httpSession);
    }

    @Test
    public void mostrarAsistentesFavoritosDelClienteTest() {
        givenUnClienteCon5AsistentesFavoritosEnSession();
        var mav = whenTraigoLaListaDeAsistentesFavoritosDelCliente();
        thenElClienteTiene5AsistentesFavoritos(mav);
    }

    @Test
    public void mostrarAsistentesFavoritosSinEstarLoggeadoTest() {
        givenUnSesionNoIniciada();
        var mav = whenIntentoListarLosAsistentesFavoritos();
        thenElUsuarioEsRedireccionadoAlLogin(mav);
    }

    @Test
    public void removerAsistenteFavoritoTest() {
        var request = givenUnClienteCon5AsistentesFavoritosRemueveAUno();
        var mav = whenElClienteRemueveAUnAsistente(request);
        thenAsistenteYaNoEsFavorito(mav);
    }

    private void givenUnClienteCon5AsistentesFavoritosEnSession() {
        var cliente = new Usuario();
        cliente.setId(203L);
        cliente.setNombre("cliente");

        var favoritos = new ArrayList<Favorito>();

        for (int i = 0; i < 5; i++) {
            var asisitente = new Usuario();
            asisitente.setId((long) i);
            asisitente.setNombre("asistente - " + i);

            var favorito = new Favorito();
            favorito.setId((long) i);
            favorito.setCliente(cliente);
            favorito.setAsistente(asisitente);

            favoritos.add(favorito);
        }

        Mockito.when(httpSession.getAttribute(SessionUtils.USER_LOGGED)).thenReturn(cliente);
        Mockito.when(servicioFavoritos.listaDeAsistentesFavotitosDe(cliente.getId())).thenReturn(favoritos);
    }

    private ModelAndView whenTraigoLaListaDeAsistentesFavoritosDelCliente() {
        return controladorPerfil.mostrarFavoritos(httpServletRequest);
    }

    private void thenElClienteTiene5AsistentesFavoritos(ModelAndView mav) {
        Assert.assertNotNull(mav);

        var model = mav.getModel();

        var favoritos = (List<Favorito>) model.get("favoritos");
        Assert.assertEquals(5, favoritos.size());

        var session = model.get("seccion");
        Assert.assertEquals("favoritos", session);

        var request = model.get("agregarRemoverAsistenteFavoritoRequest");
        Assert.assertNotNull(request);
        Assert.assertTrue(request instanceof AgregarRemoverAsistenteFavoritoRequest);
    }

    private void givenUnSesionNoIniciada() {
        Mockito.when(httpSession.getAttribute(SessionUtils.USER_LOGGED)).thenReturn(null);
    }

    private ModelAndView whenIntentoListarLosAsistentesFavoritos() {
        return controladorPerfil.mostrarFavoritos(httpServletRequest);
    }

    private void thenElUsuarioEsRedireccionadoAlLogin(ModelAndView mav) {
        Assert.assertNotNull(mav);

        var model = mav.getModel();

        var request = model.get("datosLogin");
        Assert.assertNotNull(request);
        Assert.assertTrue(request instanceof DatosLogin);

        var mesage = model.get("mensaje");
        Assert.assertNotNull(mesage);
        Assert.assertEquals("Para poder acceder al perfil necesitas estar logueado", mesage);
    }

    private AgregarRemoverAsistenteFavoritoRequest givenUnClienteCon5AsistentesFavoritosRemueveAUno() {
        var cliente = new Usuario();
        cliente.setId(103L);

        var asistenteRemovido = new Usuario();
        asistenteRemovido.setId(203L);

        var favoritos = new ArrayList<Favorito>();

        for (int i = 0; i < 4; i++) {
            var asistente = new Usuario();
            asistente.setId((long) i);

            var favorito = new Favorito();
            favorito.setCliente(cliente);
            favorito.setAsistente(asistente);

            favoritos.add(favorito);
        }

        var request = new AgregarRemoverAsistenteFavoritoRequest();
        request.setAsistenteId(asistenteRemovido.getId());

        Mockito.when(httpSession.getAttribute(SessionUtils.USER_LOGGED)).thenReturn(cliente);
        Mockito.when(servicioUsuario.usuarioFindById(asistenteRemovido.getId()))
                .thenReturn(asistenteRemovido);
        Mockito.when(servicioFavoritos.removerAsistenteFavorito(cliente.getId(), asistenteRemovido.getId()))
                .thenReturn(true);
        Mockito.when(servicioFavoritos.listaDeAsistentesFavotitosDe(cliente.getId()))
                .thenReturn(favoritos);

        return request;
    }

    private ModelAndView whenElClienteRemueveAUnAsistente(AgregarRemoverAsistenteFavoritoRequest request) {
        return controladorPerfil.removerAsistenteAFavoritosUsuarioPerfil(httpServletRequest, request);
    }

    private void thenAsistenteYaNoEsFavorito(ModelAndView mav) {
        Assert.assertNotNull(mav);

        var model = mav.getModel();

        Assert.assertNotNull(model.get("usuarioLogueado"));

        var favoritos = model.get("favoritos");
        Assert.assertNotNull(favoritos);

        var request = model.get("agregarRemoverAsistenteFavoritoRequest");
        Assert.assertNotNull(request);
    }
}