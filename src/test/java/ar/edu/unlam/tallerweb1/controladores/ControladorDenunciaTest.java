package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import ar.edu.unlam.tallerweb1.modelo.Denuncia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioDenunciaL;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ControladorDenunciaTest {
    private ServicioDenunciaL servicioDenunciaL= mock(ServicioDenunciaL.class);
    private HttpServletRequest request = mock(HttpServletRequest.class);
    private ServicioPrestacion servicioPrestacion = mock(ServicioPrestacion.class);
    private ServicioUsuario servicioUsuario = mock(ServicioUsuario.class);
    private ServicioFavoritos servicioFavoritos = mock(ServicioFavoritos.class);
    private ControladorPerfil controladorPerfil= new ControladorPerfil(servicioPrestacion,servicioUsuario,servicioDenunciaL, servicioFavoritos);
    private HttpSession session = Mockito.mock(HttpSession.class);

    public void crearSession(Usuario usuario){
        when(session.getAttribute(Mockito.any())).thenReturn(usuario);
        when(request.getSession(true)).thenReturn(session);
    }

    @Test
    public void mostrarHistorialDeDenunciasHechasDeUnUsuario() throws Exception {
        Usuario usuario = givenUsuarioDenunciasHechas();
        ModelAndView mav = whenBuscamosDenunciasHechasDeUnUsuario(request);
        thenCompruebaQueSeListaronCorrectamenteLasPrestaciones(mav);
    }

    @Test
    public void mostrarHistorialDeUnUsuarioQueNoExiste() throws Exception {
        givenUsuarioQueNoexiste();
        ModelAndView mav = whenBuscamosDenunciasHechasDeUnUsuario(request);
        thenDaErrorAlQuererMostrarUnHistorialDeDenunciasDeUnQueNoExiste(mav);
    }

    private void thenDaErrorAlQuererMostrarUnHistorialDeDenunciasDeUnQueNoExiste(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("/");
        assertThat(mav.getModel().get("sinUsuario")).isEqualTo("Logueate perri");
    }

    private void givenUsuarioQueNoexiste() throws Exception {
        Usuario usuario = new Usuario();
        crearSession(usuario);
        doThrow(Exception.class).when(servicioDenunciaL).mostrarHistorialDeDenunciasRealizadasPorUnUsuario(usuario);
    }


    private Usuario givenUsuarioDenunciasHechas() throws Exception {
        Usuario usuario = new Usuario();
        crearSession(usuario);
        List<Denuncia> listaDeDenuncias = new ArrayList<>();
        for (Integer i=0; i<5; i++){
            Denuncia denuncia = new Denuncia();
            denuncia.setUsuarioDenunciante(usuario);
            listaDeDenuncias.add(denuncia);
        }
        when(servicioDenunciaL.mostrarHistorialDeDenunciasRealizadasPorUnUsuario(usuario)).thenReturn(listaDeDenuncias);
        return usuario;
    }

    private ModelAndView whenBuscamosDenunciasHechasDeUnUsuario(HttpServletRequest request) {
        return controladorPerfil.mostrarListaDeDenunciasRealizadasPorUnUsuario(request);
    }

    private void thenCompruebaQueSeListaronCorrectamenteLasPrestaciones(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("perfilUsuario");
        assertThat(mav.getModel().get("historialDenuncias")).isEqualTo("todas las denuncias que hiciste perri");
    }
}
