package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioSuscripcion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ControladorPrestacion {

    private ServicioPrestacion servicioPrestacion;
    private ServicioUsuario servicioUsuario;
    private HttpServletRequest session;

    @Autowired
    public ControladorPrestacion(ServicioPrestacion servicioPrestacion, ServicioUsuario servicioUsuario,HttpServletRequest session) {
        this.servicioPrestacion = servicioPrestacion;
        this.servicioUsuario = servicioUsuario;
        this.session=session;
    }

    @RequestMapping(path = "/irADetallePrestacionFinalida",method = RequestMethod.GET)
    public ModelAndView irADetallePrestacionFinalida(@RequestParam(value = "prestacion") Long prestacionId) {
        ModelMap model = new ModelMap();
        Prestacion prestacion = servicioPrestacion.buscarPrestacionPorId(prestacionId);
        model.put("prestacion" ,prestacion );

        return new ModelAndView("detallePrestacionFinalizada",model);
    }


    @RequestMapping(path = "/clienteCalifica",method = RequestMethod.POST)
    public ModelAndView clienteCalificaPrestacion(Long idPrestacion, Integer calificacion) {
        ModelMap model = new ModelMap();
        try {
            servicioPrestacion.ClienteCalificaPrestacion(5l,5);
        } catch (Exception e) {
            model.put("error","error de rango de calificacion");
            return new ModelAndView("redirect:/perfilUsuario",model);
        }
        return new ModelAndView("redirect:/perfilUsuario");
    }
}
