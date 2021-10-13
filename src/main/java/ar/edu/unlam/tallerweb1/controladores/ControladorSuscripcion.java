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
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ControladorSuscripcion {

    private ServicioSuscripcion servicioSuscripcion;
    private ServicioUsuario servicioUsuario;
    private String mailPrueba = "emiliano@alumno.unlam.edu.ar";

    @Autowired
    public ControladorSuscripcion(ServicioSuscripcion servicioSuscripcion, ServicioUsuario servicioUsuario) {
        this.servicioSuscripcion = servicioSuscripcion;
        this.servicioUsuario = servicioUsuario;
    }


    @RequestMapping("/suscripcion")
    public ModelAndView irASuscripciones(HttpServletRequest request) {
        ModelMap modelo = new ModelMap();
        request.getAttribute("user");

        List<Suscripcion> listaSuscripciones = servicioSuscripcion.mostrarTodasLasSuscripciones();
        modelo.put("listaSuscripcion", listaSuscripciones);
        return new ModelAndView("suscripcion", modelo);
    }

    @RequestMapping(path = "/contratar-suscripcion", method = RequestMethod.GET)
    public ModelAndView contratarSuscripcion() {
        String nombre = "suscripcion basica";
        Suscripcion suscripcion = servicioSuscripcion.buscarPorNombre(nombre);

        Long idDeUsuarioObtenidoPorSession = 4l;
        Usuario usuario = servicioUsuario.usuarioFindById(idDeUsuarioObtenidoPorSession);

        usuario.setSuscripcion(suscripcion);

        servicioUsuario.update(usuario);

        ModelMap model = new ModelMap();
        return new ModelAndView("redirect:/traerEspecialidades", model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/cancelarSuscripcion")
    public ModelAndView cancelarSuscripcion(String mailPrueba) {

        ModelMap modelo = new ModelMap();
        Usuario usuario = servicioUsuario.buscarUsuarioPorMail(this.mailPrueba);

        try {
            servicioSuscripcion.cancelarSuscripcion(usuario.getEmail());
        } catch (Exception e) {
            modelo.put("usuarioEnSession", usuario);
            modelo.put("msgCancelacionErronia", "¡No tienes una Suscripcion!");
            return new ModelAndView("redirect:/perfilUsuario", modelo);
        }

        Usuario usuarioActualizadoSinSuscripcion = servicioUsuario.buscarUsuarioPorMail(this.mailPrueba);
        modelo.put("usuarioEnSession",usuarioActualizadoSinSuscripcion);
        modelo.put("msgCancelacionExitosa", "¡Cancelacion exitosa! rata de alcatarilla");
        return new ModelAndView("redirect:/perfilUsuario", modelo);
    }


}
