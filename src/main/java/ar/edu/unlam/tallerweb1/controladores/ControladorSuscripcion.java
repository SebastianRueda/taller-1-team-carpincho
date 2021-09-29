package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Suscripcion;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioSuscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ControladorSuscripcion {

    private ServicioSuscripcion servicioSuscripcion;

    @Autowired
    public ControladorSuscripcion(ServicioSuscripcion servicioSuscripcion) {
        this.servicioSuscripcion = servicioSuscripcion;
    }


    @RequestMapping("/suscripcion")
    public ModelAndView irASuscripciones() {
        ModelMap modelo = new ModelMap();


//        Usuario usuario = new Usuario();
//        usuario.setId(1l);
//        usuario.setEmail("lea@lea.com");
//        usuario.setPassword("123465");

        List<Suscripcion>listaSuscripciones = servicioSuscripcion.mostrarTodasLasSuscripciones();

//        modelo.put("usuario",usuario );
        modelo.put("listaSuscripcion", listaSuscripciones);

        return new ModelAndView("suscripcion", modelo);
    }

    @RequestMapping(path = "/contratar-suscripcion", method = RequestMethod.POST)
    public ModelAndView contratarSuscripcion() {
        return null;
    }
}
