package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Suscripcion;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacion;
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

    public ModelAndView clienteCalificaPrestacion(long idPrestacion, Integer calificacion) {
        ModelMap model = new ModelMap();
        try {
            servicioPrestacion.ClienteCalificaPrestacion(idPrestacion,calificacion);
            return new ModelAndView("redirect:/mostrar-historial");
        } catch (Exception e) {
            model.put("error","error de rango de calificacion");
            return new ModelAndView("perfilUsuario",model);
        }

    }
}
