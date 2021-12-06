package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.request.EditarUsuarioRequest;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorEditarUsuario {
    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorEditarUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @RequestMapping(path = "/editarUsuario", method = RequestMethod.GET)
    private ModelAndView editarUsuario(HttpServletRequest httpServletRequest) {
        Usuario usuario = SessionUtils.getCurrentUserSession(httpServletRequest);
        if (usuario == null) {
            // redirect
        }

        final var model = new ModelMap();
        model.put("request", new EditarUsuarioRequest());
        model.put("usuario", usuario);

        return new ModelAndView("editarUsuario", model);
    }

    @RequestMapping(path = "/editarUsuario", method = RequestMethod.POST)
    private ModelAndView editarUsuario(HttpServletRequest httpServletRequest,
                                       @ModelAttribute("request") EditarUsuarioRequest request) {
        Usuario current = SessionUtils.getCurrentUserSession(httpServletRequest);
        if (current == null) {
            return new ModelAndView("redirect:/");
        }

        current.setNombre(request.getNombre());
        current.setImagen(request.getImagen());

        servicioUsuario.update(current);

        return new ModelAndView("redirect:/perfilUsuario");
    }
}
