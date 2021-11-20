package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.HttpSessionFake;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.utils.UsuarioCache;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;

public class ControladorLoginTest {

    private DatosLogin datosParaLoguearse; 
    private Usuario usuario;
    private Rol rol;
    private ServicioLogin servicioLogin=mock(ServicioLogin.class);
    private HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
	private HttpSession httpSession = new HttpSessionFake();
    private RepositorioUsuario repositorioUsuario=mock(RepositorioUsuario.class);
    private ServicioUsuario servicioUsuario=mock(ServicioUsuario.class);
    private ControladorLogin controladorLogin=new ControladorLogin(servicioLogin,servicioUsuario) ;
	
    
    @Before
    public void datosParaLoguearse() {
    	datosParaLoguearse=new DatosLogin();
    }
    
    @Before
    public void instanciarUsuario() {
    	usuario= new Usuario();
    	
    }
    
    @Before
    public void instanciarRol() {
    	rol = new Rol();
    	
    }
    
    @Test
    public void testQueVerificaQueUnUsuarioIngreseAHome()  {
    	givenDatosLogin();
    	ModelAndView mav=whenSeVerificaUsuario(datosParaLoguearse); 
    	thenUsuarioIngresaAhome(mav);
    }

	@Test
	public void contraseniaIncorrectaTest() {
		DatosLogin datosLogin = givenDatosDeLoginErroneos();
		ModelAndView modelAndView = whenSeVerificaUsuario(datosLogin);
		thenVerificoQueElModeloContengaUnError(modelAndView);
	}

	private void givenDatosLogin() {
		datosParaLoguearse.setEmail("eric@gmail.com");
		datosParaLoguearse.setPassword("1234");
		rol.setId(1L);
		rol.setDescripcion("cliente");
		this.usuario.setActivo(true);
    	this.usuario.setRol(rol);
		this.usuario.setEmail(datosParaLoguearse.getEmail());
		this.usuario.setPassword(datosParaLoguearse.getPassword());

		Mockito.when(servicioLogin.consultarUsuario(datosParaLoguearse.getEmail(), datosParaLoguearse.getPassword()))
		.thenReturn(this.usuario);

		Mockito.when(httpServletRequest.getSession()).thenReturn(httpSession);
		Mockito.when(httpServletRequest.getSession(true)).thenReturn(httpSession);
	}
    
    private ModelAndView whenSeVerificaUsuario(DatosLogin datosParaLoguearse) {
    	return controladorLogin.validarLogin(datosParaLoguearse, httpServletRequest);
	}

	
	private void thenUsuarioIngresaAhome(ModelAndView mav) {
		Assertions.assertThat(!mav.isEmpty());
		Assertions.assertThat(mav.getViewName()).isEqualTo("redirect:/traerEspecialidades");
		Assertions.assertThat(mav.getModel().get("usuarioLogueado")).isNotNull();
		Assertions.assertThat(mav.getModel().get("usuarioLogueado")).hasFieldOrPropertyWithValue("email", "eric@gmail.com");
		Assertions.assertThat(mav.getModel().get("usuarioLogueado")).hasFieldOrPropertyWithValue("password", "1234");
	}

	private DatosLogin givenDatosDeLoginErroneos() {
		datosParaLoguearse.setEmail("eric@gmail.com");
		datosParaLoguearse.setPassword("4321");

		Mockito.when(servicioLogin.consultarUsuario(datosParaLoguearse.getEmail(), datosParaLoguearse.getPassword()))
				.thenReturn(null);

		return datosParaLoguearse;
	}

	private void thenVerificoQueElModeloContengaUnError(ModelAndView mav) {
		Assert.assertNotNull(mav);

		var model = mav.getModel();
		var error = model.get("error");
		Assert.assertNotNull(error);
	}
}