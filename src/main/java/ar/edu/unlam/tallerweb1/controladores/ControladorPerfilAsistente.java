package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.request.IrAsistentePerfilRequest;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorPerfilAsistente {
    private ServicioPrestacion servicioPrestacion;
    private ServicioUsuario servicioUsuario;
    private ServicioFavoritos servicioFavoritos;

    @Autowired
    public ControladorPerfilAsistente(ServicioPrestacion servicioPrestacion, ServicioUsuario servicioUsuario, ServicioFavoritos servicioFavoritos) {
        this.servicioPrestacion = servicioPrestacion;
        this.servicioUsuario = servicioUsuario;
        this.servicioFavoritos = servicioFavoritos;
    }

    @RequestMapping(path = "/asistentePerfil", method = RequestMethod.GET)
    public ModelAndView irAsistentePerfil(@RequestParam("asistente-id") Long asistenteId, HttpServletRequest httpServletRequest) {
        final var model = new ModelMap();
        final var asistente = servicioUsuario.usuarioFindById(asistenteId);

        if (asistente == null) {
            // TODO: vista de error
            return null;
        }

        final var usuario = (Usuario) httpServletRequest.getSession(true).getAttribute("usuarioLogueado");
        model.put("usuarioLogueado", usuario != null);
        model.put("asistente", asistente);
        if (usuario != null) {
            model.put("esFavorito", servicioFavoritos.esFavorito(usuario.getId(), asistenteId));
        }
        model.put("seccion", "perfil");
        model.put("irAsistentePerfilRequest", new IrAsistentePerfilRequest());

        return new ModelAndView("perfilAsistente", model);
    }

    @RequestMapping(path = "/adherirFavorito", method = RequestMethod.POST)
    public ModelAndView adherirAsistenteAFavoritos(HttpServletRequest request, @ModelAttribute("irAsistenPerfilRequest") IrAsistentePerfilRequest irAsistentePerfilRequest) {
        final var model = new ModelMap();
        final var usuario = (Usuario) request.getSession(true).getAttribute("usuarioLogueado");

        if (usuario == null) {
            // TODO: agregar una vista de error
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        final var asistente = servicioUsuario.usuarioFindById(irAsistentePerfilRequest.getAsistenteId());

        if (asistente == null) {
            // TODO: agregar una vista de error
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        model.put("usuarioLogueado", true);
        model.put("asistente", asistente);
        if (servicioFavoritos.clienteAgregaAsistenteASusFavoritos(usuario, asistente) != null) {
            model.put("esFavorito", true);
        } else {
            model.put("error", "No se pudo agregar a tus favoritos");
        }
        model.put("seccion", "perfil");
        model.put("irAsistentePerfilRequest", new IrAsistentePerfilRequest());

        return new ModelAndView("perfilAsistente", model);
    }

    @RequestMapping(path = "/removerFavorito", method = RequestMethod.POST)
    public ModelAndView removerAsistenteAFavoritos(HttpServletRequest request, @ModelAttribute("irAsistenPerfilRequest") IrAsistentePerfilRequest irAsistentePerfilRequest) {
        final var model = new ModelMap();
        final var usuario = (Usuario) request.getSession(true).getAttribute("usuarioLogueado");

        if (usuario == null) {
            // TODO: agregar una vista de error
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        final var asistente = servicioUsuario.usuarioFindById(irAsistentePerfilRequest.getAsistenteId());

        if (asistente == null) {
            // TODO: agregar una vista de error
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        model.put("usuarioLogueado", true);
        model.put("asistente", asistente);

        if (servicioFavoritos.removerAsistenteFavorito(usuario.getId(), irAsistentePerfilRequest.getAsistenteId())) {
            model.put("esFavorito", false);
        } else {
            model.put("error", "No se pudo remover de la lista de tus favoritos");
        }

        model.put("seccion", "perfil");
        model.put("irAsistentePerfilRequest", new IrAsistentePerfilRequest());

        return new ModelAndView("perfilAsistente", model);
    }
}
