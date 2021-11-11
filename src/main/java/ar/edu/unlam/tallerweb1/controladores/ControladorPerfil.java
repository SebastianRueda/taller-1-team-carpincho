package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Denuncia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioDenuncia;
import ar.edu.unlam.tallerweb1.servicios.ServicioDenunciaL;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ControladorPerfil {
    private ServicioPrestacion servicioPrestacion;
    private ServicioUsuario servicioUsuario;
	private ServicioDenunciaL servicioDenunciaL;
    private ServicioFavoritos servicioFavoritos;

    @Autowired
    public ControladorPerfil(ServicioPrestacion servicioPrestacion, ServicioUsuario servicioUsuario, ServicioDenunciaL servicioDenunciaL, ServicioFavoritos servicioFavoritos) {
        this.servicioPrestacion = servicioPrestacion;
        this.servicioUsuario = servicioUsuario;
        this.servicioFavoritos = servicioFavoritos;
        this.servicioDenunciaL = servicioDenunciaL;
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
        modelo.put("irAsistentePerfilRequest", new IrAsistentePerfilRequest());

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
    /*@RequestMapping(value = "mostrar-denuncias", method = RequestMethod.GET)
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
    }*/

    @RequestMapping(value = "mostrar-denuncias", method = RequestMethod.GET)
    public ModelAndView mostrarListaDeDenunciasRealizadasPorUnUsuario(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        HttpSession misession = request.getSession(true);
        Usuario usuarioLogueado= (Usuario) misession.getAttribute("usuarioLogueado");

        try {
            List<Denuncia> listaDenunciasHechas = servicioDenunciaL.mostrarHistorialDeDenunciasRealizadasPorUnUsuario(usuarioLogueado);
            model.put("listaDenunciasHechas", listaDenunciasHechas);
            model.put("historialDenuncias", "todas las denuncias que hiciste perri");
            model.put("seccion", "historialDenuncias");
            return new ModelAndView("perfilUsuario", model);
        } catch (Exception e) {
            model.put("sinUsuario", "Logueate perri");
            return new ModelAndView("/", model);
        }

    }

    @RequestMapping(value = "mostrar-favoritos", method = RequestMethod.GET)
    public ModelAndView mostrarFavoritos(HttpServletRequest request) {
        HttpSession misession = request.getSession(true);
        Usuario usuarioLogueado= (Usuario) misession.getAttribute("usuarioLogueado");

        if (usuarioLogueado == null){
            return new ModelAndView("redirect:/");
        }

        var favoritos = servicioFavoritos.listaDeAsistentesFavotitosDe(usuarioLogueado.getId());

        ModelMap map = new ModelMap();
        map.put("favoritos", favoritos);
        map.put("seccion", "favoritos");
        map.put("irAsistentePerfilRequest", new IrAsistentePerfilRequest());

        return new ModelAndView("perfilUsuario", map);
    }

    @RequestMapping(path = "/removerFavoritoUsuarioPerfil", method = RequestMethod.POST)
    public ModelAndView removerAsistenteAFavoritosUsuarioPerfil(HttpServletRequest request, @ModelAttribute("irAsistenPerfilRequest") IrAsistentePerfilRequest irAsistentePerfilRequest) {
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

        final var favoritos = servicioFavoritos.listaDeAsistentesFavotitosDe(usuario.getId());

        model.put("favoritos", favoritos);
        model.put("seccion", "favoritos");
        model.put("irAsistentePerfilRequest", new IrAsistentePerfilRequest());

        return new ModelAndView("perfilUsuario", model);
    }
}
