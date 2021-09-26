package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioSuscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

        List suscripciones = new ArrayList();


        Date fecha = new Date();

        Suscripcion sub1 = new Suscripcion(1L, "Suscripcion standar", 10L, fecha, null, false);
        Suscripcion sub2 = new Suscripcion(2L, "Suscripcion PREMIUM MAESTRO!!!", 100L, fecha, null, false);

        suscripciones.add(sub1);
        suscripciones.add(sub2);
        //List<Suscripcion>listaSuscripciones = servicioSuscripcion.mostrarTodasLasSuscripciones();


        modelo.put("listaSuscripcion", suscripciones);
        return new ModelAndView("suscripcion", modelo);
    }


}
