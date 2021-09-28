package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class ControladorContratar {

    private ServicioPrestacion servicioPrestacion;

    @Autowired
    public ControladorContratar(ServicioPrestacion servicioPrestacion) {
        this.servicioPrestacion = servicioPrestacion;
    }

    @RequestMapping(path="borrar-prestacion/{id}")
    public ModelAndView deletePrestacionContratada(@PathVariable("id")Long id){
        Prestacion prestacion = servicioPrestacion.prestacionFindById(id);
        servicioPrestacion.delete(prestacion);
        return new ModelAndView("redirect:/detalle-contratacion");
    }

    @RequestMapping(path="editar-prestacion/{id}")
    public ModelAndView editarPrestacion(@PathVariable("id")Long id){
        ModelMap modelo = new ModelMap();
        Prestacion prestacion = servicioPrestacion.prestacionFindById(id);
        modelo.put("prestacion",prestacion);
        return new ModelAndView("prestaciones",modelo);
    }

    @RequestMapping(path = "contratar-prestacion/{id}", method = RequestMethod.GET)
    public ModelAndView contratarPrestacion(@ModelAttribute("contratarPrestacion") @PathVariable("id") Long id) {
        Prestacion prestacion = servicioPrestacion.prestacionFindById(id);
        servicioPrestacion.save(prestacion);
        return new ModelAndView("redirect:/detalle-contratacion");
    }

    @RequestMapping(path = "/buscar-prestacion/{especialidad}", method = RequestMethod.GET)
    public ModelAndView buscarPorEspecialidad(@PathVariable("especialidad") Especialidad especialidad){
        ModelMap modelo = new ModelMap();
        List<Prestacion> prestacion = servicioPrestacion.prestacionFindByEspecialidad(especialidad);
        modelo.put("prestacion",prestacion);
        return new ModelAndView("prestaciones", modelo);
    }

    @RequestMapping(path = "/detalle-prestacion/{id}", method = RequestMethod.GET)
    public ModelAndView obtenerListaPrestaciones(@PathVariable("id") Long id){
        ModelMap modelo = new ModelMap();
        List <Prestacion> prestacion = servicioPrestacion.getAll();
        modelo.put("prestacion", prestacion);
        return new ModelAndView("prestaciones", modelo);
    }

}
