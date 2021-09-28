package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Provincia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFiltro;

@Controller
public class ControladorFiltros {
	
	
	private ServicioFiltro servicioFiltro;
	
	@Autowired
	public ControladorFiltros(ServicioFiltro servicioFiltro) {
		this.servicioFiltro=servicioFiltro;
	}
	
	@RequestMapping("/traerEspecialidades")
	public ModelAndView listaEspecialidadesDesplegable() {
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
		return new ModelAndView("resultadoPrestadores",modelo);
	}
	
}
