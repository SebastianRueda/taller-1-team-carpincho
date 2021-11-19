package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.utils.UsuarioCache;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ControladorLoginTest {

    private DatosLogin datosParaLoguearse ; 
    private Usuario usuario;
    private ServicioLogin servicioLogin=mock(ServicioLogin.class);
    private HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    private RepositorioUsuario repositorioUsuario=mock(RepositorioUsuario.class);
    private ServicioUsuario servicioUsuario=mock(ServicioUsuario.class);
    private ControladorLogin controladorLogin=new ControladorLogin(servicioLogin,servicioUsuario) ;
    
    @Before
    public void datosParaLoguearse() {
    	datosParaLoguearse=new DatosLogin();
    }
    
    @Before
    public void instanciarUsuario() {
    	Usuario usuario= new Usuario();
    	
    }
    
    @Test
    public void testQueVerificaQueUnUsuarioIngreseAHome()  {
    	givenDatosLogin();
    	Usuario usuario=whenSeVerificaUsuario(datosParaLoguearse); 
    	thenUsuarioIngresaAhome(usuario);
    }
    
    private Usuario whenSeVerificaUsuario(DatosLogin datosParaLoguearse) {
    	ModelMap model = new ModelMap();
    	usuario.setActivo(true);
    	usuario.setEmail(datosParaLoguearse.getPassword());
    	usuario.setPassword(datosParaLoguearse.getEmail());
    	UsuarioCache.setUsuario(usuario);
		request.getSession().setAttribute("ROL", usuario.getRol());
    	
    	HttpSession misession=request.getSession(usuario.activo());
    	misession.setAttribute("usuarioLogueado",usuario);
    	Mockito.when(servicioLogin.consultarUsuario(usuario.getEmail(), usuario.getPassword()))
		.thenReturn(repositorioUsuario.buscarUsuario(usuario.getEmail(), usuario.getPassword()));
    	return usuario;
		
	}

	private void givenDatosLogin() {
		datosParaLoguearse.setEmail("eric@gmail.com");
		datosParaLoguearse.setPassword("1234");
	}
	
	private void thenUsuarioIngresaAhome(Usuario logueado) {
		// TODO Auto-generated method stub
		
	}

}
