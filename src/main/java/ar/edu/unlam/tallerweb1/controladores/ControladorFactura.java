package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Suscripcion;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFactura;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioSuscripcion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class ControladorFactura {


    private ServicioFactura servicioFactura;
    private ServicioSuscripcion servicioSuscripcion;

    @Autowired
    public ControladorFactura(ServicioFactura servicioFactura,ServicioSuscripcion servicioSuscripcion){
        this.servicioFactura = servicioFactura;
        this.servicioSuscripcion= servicioSuscripcion;
    }


    @RequestMapping(path ="/irAFactura/{id}", method = RequestMethod.GET)
    public ModelAndView irAFactura(HttpServletRequest request , @PathVariable("id")Long idSuscripcion) {

        ModelMap model = new ModelMap();
        String saludo = "Aloha";
        HttpSession misession= request.getSession(true);
        Usuario usuarioLogueado= (Usuario) misession.getAttribute("usuarioLogueado");

        Suscripcion suscripcion = servicioSuscripcion.buscarSuscripcionPorId(idSuscripcion);
        long ctm=System.currentTimeMillis();
        Date d= new Date(ctm);
        LocalDate localDate = d.toLocalDate();
        Date fechaActual = Date.valueOf(localDate);

        model.put("saludo", saludo);
        model.put("suscripcion", suscripcion);
        model.put("usuarioLogueado", usuarioLogueado);
        model.put("fechaActual", fechaActual);

        return new ModelAndView("factura", model);

    }


}
