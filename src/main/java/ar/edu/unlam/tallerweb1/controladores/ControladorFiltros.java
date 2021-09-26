package ar.edu.unlam.tallerweb1.controladores;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioFiltro;

@Controller
public class ControladorFiltros {
	
	
	private ServicioFiltro servicioFiltro;
	
	@Autowired
	public ControladorFiltros(ServicioFiltro servicioFiltro) {
		this.servicioFiltro=servicioFiltro;
	}
	
	@RequestMapping("/traerPrestaciones")
	public ModelAndView listarPrestacionesDesplegable() {
		ModelMap modelo = new ModelMap();
		Set<Prestacion> lista = servicioFiltro.traerPrestaciones();
		modelo.put("prestaciones", lista);
		return new ModelAndView("busquedaPrestaciones", modelo);
	}
	
}
