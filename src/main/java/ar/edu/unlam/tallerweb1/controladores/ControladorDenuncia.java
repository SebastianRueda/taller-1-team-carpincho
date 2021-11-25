package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.modelo.request.DenunciaDetalleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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

	private long IdprestacionADenunciar = 2;

	@Autowired
	public ControladorDenuncia(ServicioDenuncia servicioDenuncia, ServicioFiltro servicioFiltro,
			ServicioPrestacion servicioPrestacion, ServicioUsuario servicioUsuario) {
		this.servicioDenuncia = servicioDenuncia;
		this.servicioFiltro = servicioFiltro;
		this.servicioPrestacion = servicioPrestacion;
		this.servicioUsuario = servicioUsuario;
	}

	//////////////////////////////////////////// -----------------------------------------------------------
	@RequestMapping(path = "/denunciarAsistente", method = RequestMethod.GET)
	public ModelAndView listaDenunciasDesplegable(HttpServletRequest request, @RequestParam(value = "prestacion-id") Long id) {
		HttpSession misession = request.getSession(true);
		Usuario usuarioLogueado = (Usuario) misession.getAttribute("usuarioLogueado");

		if (usuarioLogueado == null) {
			return new ModelAndView("redirect:/");
		}

		ModelMap modelo = new ModelMap();

		var prestacion = servicioPrestacion.buscarPrestacionPorId(id);
		var asistente = prestacion.getUsuarioAsistente();

		var prestaciones = servicioPrestacion.listarPrestacionesContratadasPorCliente(usuarioLogueado.getId());
		Usuario usuario = servicioUsuario.usuarioFindById(usuarioLogueado.getId());

		modelo.put("prestacionId", id);
		modelo.put("usuarioEnSession", usuario);
		modelo.put("listaPrestaciones", prestaciones);
		List<Especialidad> lista =
				servicioFiltro.traerEspecialidad();
		modelo.put("especialidades", lista);
		List<Provincia> listaProv = servicioFiltro.traerprovincia();
		modelo.put("provincias", listaProv);
		List<MotivoDenuncia> listaDenuncias = servicioDenuncia.traerDenuncia();
		modelo.put("motivoDenuncias", listaDenuncias);
		modelo.put("asistente", asistente);

		var denunciaRequest = new DenunciaRequest();
		modelo.put("denunciaRequest", denunciaRequest);

		return new ModelAndView("generarDenuncia", modelo);
	}

	@RequestMapping(path = "/denunciaRealizada", method = RequestMethod.POST)
	public ModelAndView denunciaRealizada(HttpServletRequest request, @ModelAttribute("denunciaRealizada") DenunciaRequest denunciaRequest) {
		var historialDenuncia = new Denuncia();

		historialDenuncia.setPrestacion(servicioPrestacion.buscarPrestacionPorId(denunciaRequest.getPrestacionId()));
		historialDenuncia.setUsuarioDenunciante(servicioUsuario.usuarioFindById(denunciaRequest.getClienteId()));
		historialDenuncia.setUsuarioDenunciado(servicioUsuario.usuarioFindById(denunciaRequest.getAsistenteId()));
		historialDenuncia.setComentario(denunciaRequest.getComentario());
		historialDenuncia.setMotivoDenuncia(servicioDenuncia.buscarMotivoPorId(denunciaRequest.getMotivoId()));

		servicioDenuncia.guardar(historialDenuncia);

		return new ModelAndView("redirect: mostrar-denuncias");
	}

	@RequestMapping(path="detalleDenunciaRealizada",method = RequestMethod.POST)
	public ModelAndView IrDetalleDenunciaRealizada(HttpServletRequest request, @ModelAttribute("denunciaDetalleRequest") DenunciaDetalleRequest denunciaDetalleRequest){
		var denuncia = servicioDenuncia.buscarDenunciaPorId(denunciaDetalleRequest.getDenunciaId());

		var model = new ModelMap();

		if (denuncia != null) {
			model.put("denuncia", denuncia);
		} else {
			model.put("error", "No se pudo encontrar la denuncia");
		}

		return new ModelAndView("detalleDenunciaRealizada", model);
	}


}

	 
	  
	/*
	 * @RequestMapping(path = "/denunciarAsistente", method = RequestMethod.GET)
	 * public ModelAndView denunciarAsistente(HttpServletRequest request){
	 * HttpSession misession= request.getSession(true); Usuario usuarioLogueado=
	 * (Usuario) misession.getAttribute("usuarioLogueado"); ModelMap modelo = new
	 * ModelMap(); if (usuarioLogueado == null){ return new
	 * ModelAndView("redirect:/"); }
	 * 
	 * Prestacion prestacionDenunciada =
	 * servicioPrestacion.buscarPrestacionPorId(IdprestacionADenunciar);
	 * modelo.put("prestacionDenunciada", prestacionDenunciada); List<Denuncia>
	 * listaDenuncias =servicioDenuncia.traerDenuncia(); modelo.put("denuncias",
	 * listaDenuncias); return new ModelAndView ("generarDenuncia",modelo); }
	 */


/*
 * @RequestParam(value = ${}, required = false) Long especialidadBuscada,
 * 
 * @RequestParam(value = "listaProvinciaDesplegable", required = false) Long
 * provinciaBuscada) {
 * 
 * ModelMap modelo = new ModelMap(); List<Usuario>
 * listaUsuarios=servicioFiltro.usuariosDeLaEspecialidadYprovincia(
 * especialidadBuscada,provinciaBuscada); modelo.put("resultadoUsuarios",
 * listaUsuarios); if(listaUsuarios.size()==0) { ModelMap model=new ModelMap();
 * model.put(
 * "error","El tipo de Especialidad no se encuentra disponible en este momento"
 * + "puede optar por otras opciones desde la pagina Anterior" );
 * model.put("volver","Volver A La Pagina Anterior" ); return new ModelAndView
 * ("excepcionFiltro",model); } return new
 * ModelAndView("resultadoPrestadores",modelo); }
 * 
 * }
 */
