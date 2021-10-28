package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;

public class ControladorLoginTest {
/*
    private final DatosLogin USUARIO = usuario("prueba@gmail.com", "123123");
    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private ServicioLogin servicioLogin;
    private ModelAndView mav;
    @Autowired
    private ControladorLogin controladorLogin ;




    @Test
    @Transactional
    @Rollback
    public void queSeIngreseAHome()  {
        whenUsuarioAccedeALogin();
        thenVeoModelAndViewConUsuarioYYendoAVistaLogin();
    }
    private void whenUsuarioAccedeALogin() {
        mav = controladorLogin.irALogin();
    }

    private void thenVeoModelAndViewConUsuarioYYendoAVistaLogin() {
        assertThat(mav.getViewName()).isEqualTo("login");
        ModelMap modelo = new ModelMap();
        modelo.put("datosLogin",new DatosLogin());
        assertThat(mav.getModel()).isEqualTo(modelo);
    }


    @Test
    @Transactional
    @Rollback
    public void queSeIngreseALogin()  {
        whenUsuarioAccedeAHome();
        thenVeoModelAndViewHome();
    }

    private void whenUsuarioAccedeAHome() {
        mav = controladorLogin.irAHome();
    }

    private void thenVeoModelAndViewHome() {
        assertThat(mav.getViewName()).isEqualTo("home");
    }



    @Test
    @Transactional
    @Rollback
    public void queSeIngreseAInicio()  {
        whenUsuarioAccedeAInicio();
        thenVeoModelAndViewRedirectLogin();
    }

    private void whenUsuarioAccedeAInicio() {
       mav = controladorLogin.inicio();
    }

    private void thenVeoModelAndViewRedirectLogin() {
        assertThat(mav.getViewName()).isEqualTo("redirect:/login");
    }

    private DatosLogin usuario( String email, String clave) {
        DatosLogin usuario = new DatosLogin();
        usuario.setEmail(email);
        usuario.setPassword(clave);
        return usuario;
    }

    private void givenUsuario() {
    }
*/
}
