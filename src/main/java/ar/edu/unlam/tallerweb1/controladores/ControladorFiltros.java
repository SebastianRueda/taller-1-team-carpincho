package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Provincia;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFiltro;
import ar.edu.unlam.tallerweb1.utils.SessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ControladorFiltros {
	
	
	private ServicioFiltro servicioFiltro;
	private HttpServletRequest request;


	@Autowired
	public ControladorFiltros(ServicioFiltro servicioFiltro) {
		this.servicioFiltro=servicioFiltro;
	}

	@RequestMapping("/usuarioEspecialidades")
	public ModelAndView usuariosPorEspecialidad() {
		ModelMap modelo = new ModelMap();
		List<Especialidad> lista = servicioFiltro.traerEspecialidad();
		if (lista.size()!=7)
			modelo.put("mensaje", "la lista de especialidades esta siendo mal cargada");
		modelo.put("especialidades", lista);
		return new ModelAndView("busquedaPrestadores", modelo);
	}

	@RequestMapping("/usuarioEspecialidadElegida")
	public ModelAndView listaEspecialistas(
			@RequestParam(value = "usuarioEspecialidades", required = false) Long especialidadBuscada){
		ModelMap modelo = new ModelMap();
		List<Usuario> listaUsuarios=servicioFiltro.usuariosDeLaEspecialidad(especialidadBuscada);
		modelo.put("resultadoUsuarios", listaUsuarios);
		if(listaUsuarios.size()==0) {
			ModelMap model=new ModelMap();
			model.put("error","El tipo de Especialidad no se encuentra disponible en este momento," +
					"puede optar por otras opciones desde la pagina Anterior" );
			model.put("volver","Volver A La Pagina Anterior" );
			return new ModelAndView ("excepcionFiltro",model);
		}
		return new ModelAndView("resultadoPrestadores",modelo);
	}

	@RequestMapping("/usuarioProvincia")
	public ModelAndView usuariosPorProvincia() {
		ModelMap modelo = new ModelMap();
		List<Provincia> listaProv=servicioFiltro.traerprovincia();
		modelo.put("provincias", listaProv);
		return new ModelAndView("busquedaPrestadores", modelo);
	}

	@RequestMapping("/usuarioProvinciaElegida")
	public ModelAndView listaporProvincia(
			@RequestParam(value ="usuarioProvincia", required = false) Long provinciaBuscada){
		ModelMap modelo = new ModelMap();
		List<Usuario> listaUsuarios=servicioFiltro.usuariosDeLaProvincia(provinciaBuscada);
		modelo.put("resultadoUsuarios", listaUsuarios);
		if(listaUsuarios.size()==0) {
			ModelMap model=new ModelMap();
			model.put("error","El tipo de Especialidad no se encuentra disponible en este momento," +
					"puede optar por otras opciones desde la pagina Anterior" );
			model.put("volver","Volver A La Pagina Anterior" );
			return new ModelAndView ("excepcionFiltro",model);
		}
		return new ModelAndView("resultadoPrestadores",modelo);
	}


	@RequestMapping("/traerEspecialidades")
	public ModelAndView listaEspecialidadesDesplegable(HttpServletRequest httpServletRequest) {
		ModelMap modelo = new ModelMap();
		List<Especialidad> lista = servicioFiltro.traerEspecialidad();
		modelo.put("especialidades", lista);
		List<Provincia> listaProv=servicioFiltro.traerprovincia();
		modelo.put("provincias", listaProv);

		return new ModelAndView("busquedaPrestadores", modelo);
	}
	
	@RequestMapping("/especialidadElegida")
	public ModelAndView listaEspecialistas(
			@RequestParam(value = "listaEspecialidadDesplegable", required = false) Long especialidadBuscada,

			@RequestParam(value = "listaProvinciaDesplegable", required = false) Long provinciaBuscada)
		{	 

		ModelMap modelo = new ModelMap();
		List<Usuario> listaUsuarios=servicioFiltro.usuariosDeLaEspecialidadYprovincia(especialidadBuscada,provinciaBuscada);
		modelo.put("resultadoUsuarios", listaUsuarios);
		if(listaUsuarios.size()==0) {
			ModelMap model=new ModelMap();
			model.put("error","El tipo de Especialidad no se encuentra disponible en este momento" +
					"puede optar por otras opciones desde la pagina Anterior" );
			model.put("volver","Volver A La Pagina Anterior" );
			return new ModelAndView ("excepcionFiltro",model);
		}
		return new ModelAndView("resultadoPrestadores",modelo);
	}
	
	@RequestMapping(path = "/establecerUbicacion", method = RequestMethod.GET)
    public ModelAndView establecerUbicacion(
    		HttpServletRequest request,@RequestParam(value = "latitud") Double latitud,@RequestParam(value = "longitud") Double longitud) {
        var usuarioLogueado = SessionUtils.getCurrentUserSession(request);
        usuarioLogueado.setLatitud(latitud);
        usuarioLogueado.setLongitud(longitud);
        SessionUtils.createSession(request, usuarioLogueado);
        return new ModelAndView("redirect:/traerEspecialidades");
    
	}    
	
	
}
