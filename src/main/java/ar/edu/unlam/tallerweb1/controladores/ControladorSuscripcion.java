package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Suscripcion;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioSuscripcion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ControladorSuscripcion {

    private ServicioSuscripcion servicioSuscripcion;
    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorSuscripcion(ServicioSuscripcion servicioSuscripcion,ServicioUsuario servicioUsuario) {
        this.servicioSuscripcion = servicioSuscripcion;
        this.servicioUsuario = servicioUsuario;
    }


    @RequestMapping("/suscripcion")
    public ModelAndView irASuscripciones() {
        ModelMap modelo = new ModelMap();

        List<Suscripcion>listaSuscripciones = servicioSuscripcion.mostrarTodasLasSuscripciones();
        modelo.put("listaSuscripcion", listaSuscripciones);
        return new ModelAndView("suscripcion", modelo);
    }

    @RequestMapping(path = "/contratar-suscripcion", method = RequestMethod.GET)
    public ModelAndView contratarSuscripcion() {
        String nombre ="suscripcion basica";
        Suscripcion suscripcion = servicioSuscripcion.buscarPorNombre(nombre);

        Long idDeUsuarioObtenidoPorSession = 2l;
        Usuario usuario = servicioUsuario.usuarioFindById(idDeUsuarioObtenidoPorSession);

        usuario.setSuscripcion(suscripcion);
        servicioUsuario.update(usuario);

        ModelMap model = new ModelMap();
        return new ModelAndView("redirect:/traerEspecialidades", model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/cancelarSuscripcion")
    public ModelAndView cancelarSuscripcion(String email) {
        ModelMap modelo = new ModelMap();


        try {
          servicioSuscripcion.cancelarSuscripcion(email);
        } catch (Exception e) {
            modelo.put("msg", "El Usuario no tiene una Suscripcion");
            return new  ModelAndView("redirect:/suscripcion", modelo);
        }
        modelo.put("msg", "Suscripcion Cancelada");
        return new ModelAndView("redirect:/traerEspecialidades", modelo);
    }
}
