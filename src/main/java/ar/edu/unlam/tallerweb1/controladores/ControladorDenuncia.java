package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Denuncia;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Provincia;
import ar.edu.unlam.tallerweb1.servicios.ServicioFiltro;
import ar.edu.unlam.tallerweb1.servicios.ServicioDenuncia;

@Controller
public class ControladorDenuncia {

	private ServicioDenuncia servicioDenuncia;
	private ServicioFiltro servicioFiltro;
	
	@Autowired
	public ControladorDenuncia(ServicioDenuncia servicioDenuncia,ServicioFiltro servicioFiltro) {
		this.servicioDenuncia=servicioDenuncia;
		this.servicioFiltro=servicioFiltro;
	}
	
	@RequestMapping("/denunciarAsistente")
	public ModelAndView listaDenunciasDesplegable() {
		ModelMap modelo = new ModelMap();
		List<Especialidad> lista = servicioFiltro.traerEspecialidad();
		modelo.put("especialidades", lista);
		List<Provincia> listaProv=servicioFiltro.traerprovincia();
		modelo.put("provincias", listaProv);
		List<Denuncia> listaDenuncias = servicioDenuncia.traerDenuncia();
		modelo.put("denuncias", listaDenuncias);
		return new ModelAndView("generarDenuncia", modelo);
	}
}
