package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.PrestacionEstado;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.utils.UsuarioCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class ControladorContratar {

    private ServicioPrestacion servicioPrestacion;
    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorContratar(ServicioPrestacion servicioPrestacion, ServicioUsuario servicioUsuario) {
        this.servicioPrestacion = servicioPrestacion;
        this.servicioUsuario = servicioUsuario;
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

    @RequestMapping(path = "/contratar-prestacion", method = RequestMethod.GET)
    public ModelAndView contratarPrestacion(@RequestParam(value = "asistente-id") Long id) {
        var asistente = servicioUsuario.usuarioFindById(id);

        if (asistente == null) {
            throw new IllegalArgumentException("Error no asistente");
        }

        Prestacion prestacion = new Prestacion();//servicioPrestacion.prestacionFindById(asistente.getEspecialidad().getId());
        prestacion.setEstado(PrestacionEstado.ACTIVO.getEstado());
        prestacion.setEspecialidad(asistente.getEspecialidad());
        prestacion.setUsuarioAsistente(asistente);

        var cliente = UsuarioCache.getUsuario();

        prestacion.setUsuarioSolicitante(cliente);

        servicioPrestacion.save(prestacion);

        prestacion.getId();

        var model = new ModelMap();
        model.put("prestacion", prestacion);

        return new ModelAndView("detalle-contratacion", model);
    }

    @RequestMapping(path = "/ir-detalle-contratacion", method = RequestMethod.GET)
    public ModelAndView irDetalleContratacion() {
        return new ModelAndView("detalle-contratacion");
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

    @RequestMapping(path = "/perfilUsuario", method = RequestMethod.GET)
    public ModelAndView IrAPerfilUsuario(){

        ModelMap modelo = new ModelMap();
        return new ModelAndView("perfilUsuario", modelo);
    }
}
