package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Suscripcion;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFactura;
import ar.edu.unlam.tallerweb1.servicios.ServicioSuscripcion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ControladorSuscripcion {
    private HttpServletRequest request;
    private ServicioSuscripcion servicioSuscripcion;
    private ServicioUsuario servicioUsuario;
    private ServicioFactura servicioFactura;

    private String emailDeLUsuarioDeLaSesion = "ecuevas@alumno.unlam.edu.ar";

    private Long idSuscripcionBasica=1l;
    private Long idSuscripcionPremium=2l;

    @Autowired
    public ControladorSuscripcion(HttpServletRequest request, ServicioSuscripcion servicioSuscripcion, ServicioUsuario servicioUsuario, ServicioFactura servicioFactura) {
        this.request = request;
        this.servicioSuscripcion = servicioSuscripcion;
        this.servicioUsuario = servicioUsuario;
        this.servicioFactura=servicioFactura;
    }


    @RequestMapping("/suscripcion")
    public ModelAndView irASuscripciones(HttpServletRequest request) {
        ModelMap modelo = new ModelMap();
        HttpSession misession= request.getSession(true);
        Usuario usuarioLogueado= (Usuario) misession.getAttribute("usuarioLogueado");

        if (usuarioLogueado == null){
            return new ModelAndView("redirect:/");
        }

        List<Suscripcion> listaSuscripciones = servicioSuscripcion.mostrarTodasLasSuscripciones();
        modelo.put("listaSuscripcion", listaSuscripciones);
        return new ModelAndView("suscripcion", modelo);
    }

    @RequestMapping(path = "/contratar-suscripcion-basica", method = RequestMethod.POST)
    public ModelAndView contratarSuscripcion(@ModelAttribute("suscripcion") Suscripcion suscripcionAContratar) {
        String suscripcionBasica = "suscripcion basica";
        Suscripcion suscripcion = servicioSuscripcion.buscarPorNombre(suscripcionBasica);
        HttpSession misession= this.request.getSession(true);
        Usuario usuarioLogueado= (Usuario) misession.getAttribute("usuarioLogueado");

        String ruta= "redirect:/irAFactura/" +suscripcion.getId();

        usuarioLogueado.setSuscripcion(suscripcion);
        servicioUsuario.update(usuarioLogueado);
        servicioFactura.generarFactura(usuarioLogueado);

        ModelMap model = new ModelMap();
        return new ModelAndView(ruta, model);
    }

    @RequestMapping(path = "/contratar-suscripcion-premium", method = RequestMethod.POST)
    public ModelAndView contratarSuscripcionPremium(@ModelAttribute("suscripcion") Suscripcion suscripcionAContratar) {
        String suscripcionPremium = "suscripcion premium";
        Suscripcion suscripcion = servicioSuscripcion.buscarPorNombre(suscripcionPremium);
        HttpSession misession= this.request.getSession(true);
        Usuario usuarioLogueado= (Usuario) misession.getAttribute("usuarioLogueado");

        usuarioLogueado.setSuscripcion(suscripcion);
        servicioUsuario.update(usuarioLogueado);

        ModelMap model = new ModelMap();
        return new ModelAndView("redirect:/perfilUsuario", model);
    }



    @RequestMapping(method = RequestMethod.POST, path = "/cancelarSuscripcion")
    public ModelAndView cancelarSuscripcion(String email) {

        ModelMap modelo = new ModelMap();

        HttpSession misession= this.request.getSession(true);
        Usuario usuarioLogueado= (Usuario) misession.getAttribute("usuarioLogueado");

        try {
            servicioSuscripcion.cancelarSuscripcion(usuarioLogueado.getEmail());
        } catch (Exception e) {
            modelo.put("usuarioEnSession", usuarioLogueado);
            modelo.put("msgCancelacionErronia", "No tienes una Suscripcion");
            return new ModelAndView("redirect:/perfilUsuario", modelo);
        }

        Usuario usuarioActualizadoSinSuscripcion = servicioUsuario.buscarUsuarioPorMail(usuarioLogueado.getEmail());
        modelo.put("usuarioEnSession",usuarioActualizadoSinSuscripcion);
        modelo.put("msgCancelacionExitosa", "¡Cancelacion exitosa! rata de alcatarilla");

        return new ModelAndView("redirect:/perfilUsuario", modelo);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/modificarSuscripcionBasicaUsuario")
    public ModelAndView modificarSuscripcionBasicaAPremium() {
        ModelMap modelo = new ModelMap();
        String nombre = "suscripcion premium";
        Suscripcion suscripcionPremium = servicioSuscripcion.buscarPorNombre(nombre);

        HttpSession misession= this.request.getSession(true);
        Usuario usuarioLogueado= (Usuario) misession.getAttribute("usuarioLogueado");

        try {
            servicioSuscripcion.upGradeSuscripcionBasicaAPremium(usuarioLogueado,suscripcionPremium);
        } catch (Exception e) {
            modelo.put("msgModificacionSuscripcion","Upgrade fallido");
            return new ModelAndView("redirect:/perfilUsuario", modelo);
        }

        modelo.put("msgModificacionSuscripcion","Upgrade exitosa");
        return new ModelAndView("redirect:/perfilUsuario", modelo);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/modificarSuscripcionPremiumUsuario")
    public ModelAndView modificarSuscripcionPremiumABasica() {
        ModelMap modelo = new ModelMap();
        String nombre = "suscripcion basica";
        Suscripcion suscripcionBasica = servicioSuscripcion.buscarPorNombre(nombre);

        HttpSession misession= this.request.getSession(true);
        Usuario usuarioLogueado= (Usuario) misession.getAttribute("usuarioLogueado");

        try {
            servicioSuscripcion.downGradeSuscripcionBasicaAPremium(usuarioLogueado,suscripcionBasica);
        } catch (Exception e) {
            modelo.put("msgModificacionSuscripcion","downGrade fallido");
            return new ModelAndView("redirect:/perfilUsuario", modelo);
        }

        modelo.put("msgModificacionSuscripcion","downGrade exitosa");
        return new ModelAndView("redirect:/perfilUsuario", modelo);
    }
}
