package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorContratar {

    private ServicioPrestacion servicioPrestacion;
    private ServicioUsuario servicioUsuario;
    private ServicioLogin servicioLogin;

    @Autowired
    public ControladorContratar(ServicioPrestacion servicioPrestacion) {
        this.servicioPrestacion = servicioPrestacion;
    }

    @RequestMapping(path = "/contratar/{id}", method = RequestMethod.GET)
    public ModelAndView contratarPrestacion(@PathVariable("id") Long id) {
        ModelMap model = new ModelMap();
        Prestacion prestacion = servicioPrestacion.prestacionFindById(id);
        prestacion.setEspecialidad("");




        servicioPrestacion.save(prestacion);
        return new ModelAndView("serviciosContratados", model);

    }



}
