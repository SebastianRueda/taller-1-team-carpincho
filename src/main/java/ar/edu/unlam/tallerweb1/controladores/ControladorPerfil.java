package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioDenuncia;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ControladorPerfil {
    private ServicioPrestacion servicioPrestacion;
    private ServicioUsuario servicioUsuario;
	private ServicioDenuncia servicioDenuncia;

    @Autowired
    public ControladorPerfil(ServicioPrestacion servicioPrestacion, ServicioUsuario servicioUsuario, ServicioDenuncia servicioDenuncia) {
        this.servicioPrestacion = servicioPrestacion;
        this.servicioUsuario = servicioUsuario;
        this.servicioDenuncia = servicioDenuncia;
    }

    @RequestMapping(path = "/perfilUsuario", method = RequestMethod.GET)
    public ModelAndView IrAPerfilUsuario(HttpServletRequest request){
        HttpSession misession= request.getSession(true);
        Usuario usuarioLogueado= (Usuario) misession.getAttribute("usuarioLogueado");
        ModelMap modelo = new ModelMap();

        if (usuarioLogueado == null){
            return new ModelAndView("redirect:/");
        }

        try {
            Float promedio= servicioPrestacion.obtenerPromedioDeCalificicacionDeUnUsuario(usuarioLogueado);
            modelo.put("promedio",promedio);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Usuario usuario = servicioUsuario.usuarioFindById(usuarioLogueado.getId());
        modelo.put("usuarioEnSession",usuario);
        modelo.put("seccion", "perfil");
        return new ModelAndView("perfilUsuario", modelo);
    }

    @RequestMapping(value = "mostrar-historial", method = RequestMethod.GET)
    public ModelAndView mostrarHistorial(HttpServletRequest request) {
        HttpSession misession = request.getSession(true);
        Usuario usuarioLogueado= (Usuario) misession.getAttribute("usuarioLogueado");

        if (usuarioLogueado == null){
            return new ModelAndView("redirect:/");
        }

        var prestaciones = servicioPrestacion.listarPrestacionesContratadasPorCliente(usuarioLogueado.getId());

        ModelMap map = new ModelMap();
        map.put("historial", prestaciones);
        map.put("seccion", "historial");

        return new ModelAndView("perfilUsuario", map);
    }
    @RequestMapping(value = "mostrar-denuncias", method = RequestMethod.GET)
    public ModelAndView mostrarDenuncias(HttpServletRequest request) {
        HttpSession misession = request.getSession(true);
        Usuario usuarioLogueado = (Usuario) misession.getAttribute("usuarioLogueado");

        if (usuarioLogueado == null){
            return new ModelAndView("redirect:/");
        }

        var denuncias = servicioDenuncia.listarDenunciasPorCliente(usuarioLogueado.getId());

        ModelMap map = new ModelMap();
        map.put("denuncias", denuncias);
        map.put("seccion", "historialDenuncias");

        return new ModelAndView("perfilUsuario", map);
    }
}
