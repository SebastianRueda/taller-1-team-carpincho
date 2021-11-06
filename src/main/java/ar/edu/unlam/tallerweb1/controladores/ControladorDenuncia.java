package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Denuncia;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Provincia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFiltro;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioDenuncia;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorDenuncia {

	private ServicioDenuncia servicioDenuncia;
	private ServicioFiltro servicioFiltro;
	private ServicioUsuario servicioUsuario;
	private ServicioPrestacion servicioPrestacion;
	
	@Autowired
	public ControladorDenuncia(ServicioDenuncia servicioDenuncia,ServicioFiltro servicioFiltro,ServicioPrestacion servicioPrestacion, ServicioUsuario servicioUsuario) {
		this.servicioDenuncia=servicioDenuncia;
		this.servicioFiltro=servicioFiltro;
		this.servicioPrestacion = servicioPrestacion;
        this.servicioUsuario = servicioUsuario;
	}
	
	@RequestMapping(path = "/denunciarAsistente", method = RequestMethod.GET)
	public ModelAndView listaDenunciasDesplegable(HttpServletRequest request) {
		HttpSession misession= request.getSession(true);
        Usuario usuarioLogueado= (Usuario) misession.getAttribute("usuarioLogueado");

        if (usuarioLogueado == null){
            return new ModelAndView("redirect:/");
        }
        var prestaciones = servicioPrestacion.listarPrestacionesContratadasPorCliente(usuarioLogueado.getId());
        Usuario usuario = servicioUsuario.usuarioFindById(usuarioLogueado.getId());

		ModelMap modelo = new ModelMap();
        modelo.put("usuarioEnSession",usuario);
        modelo.put("listaPrestaciones", prestaciones);
		List<Especialidad> lista = servicioFiltro.traerEspecialidad();
		modelo.put("especialidades", lista);
		List<Provincia> listaProv=servicioFiltro.traerprovincia();
		modelo.put("provincias", listaProv);
		List<Denuncia> listaDenuncias = servicioDenuncia.traerDenuncia();
		modelo.put("denuncias", listaDenuncias);
		return new ModelAndView("generarDenuncia", modelo);
	}
}
