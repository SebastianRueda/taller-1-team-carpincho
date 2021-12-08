package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.request.EditarUsuarioRequest;
import ar.edu.unlam.tallerweb1.servicios.ServicioProvincia;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorEditarUsuario {
    private ServicioUsuario servicioUsuario;
    private ServicioProvincia servicioProvincia;

    @Autowired
    public ControladorEditarUsuario(ServicioUsuario servicioUsuario, ServicioProvincia servicioProvincia) {
        this.servicioUsuario = servicioUsuario;
        this.servicioProvincia = servicioProvincia;
    }

    @RequestMapping(path = "/ir-a-editar-usuario", method = RequestMethod.GET)
    private ModelAndView irAEditarUsuario(HttpServletRequest httpServletRequest) {
        Usuario usuario = SessionUtils.getCurrentUserSession(httpServletRequest);
        if (usuario == null) {
            return new ModelAndView("redirect:/");
        }

        final var model = new ModelMap();
        model.put("request", new EditarUsuarioRequest());
        model.put("usuario", usuario);

        final var provincias = servicioProvincia.traerProvincia();
        model.put("provicincias", provincias);

        return new ModelAndView("editarUsuario", model);
    }

    @RequestMapping(path = "/editar-usuario", method = RequestMethod.POST)
    private ModelAndView editarUsuario(HttpServletRequest httpServletRequest,
                                       @ModelAttribute("request") EditarUsuarioRequest request) {
        Usuario current = SessionUtils.getCurrentUserSession(httpServletRequest);
        if (current == null) {
            return new ModelAndView("redirect:/");
        }

        if (request.getNombre() != null && !request.getNombre().isBlank()) {
            current.setNombre(request.getNombre());
        }

        if (request.getApellido() != null && !request.getApellido().isBlank()) {
            current.setApellido(request.getApellido());
        }

        if (request.getEmail() != null && !request.getEmail().isBlank()) {
            current.setEmail(request.getEmail());
        }

        if (request.getProvinciaId() != null && request.getProvinciaId() >= 0) {
            final var provincia = servicioProvincia.buscarProvinciaPorId(request.getProvinciaId());
            if (provincia != null) {
                current.setProvincia(provincia);
            }
        }

        /*if (request.getImagen() != null && !request.getImagen().isBlank()) {
            current.setImagen(request.getImagen());
        }*/

        servicioUsuario.update(current);

        return new ModelAndView("redirect:/perfilUsuario");
    }
}
