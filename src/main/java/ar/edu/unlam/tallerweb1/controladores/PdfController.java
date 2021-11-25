package ar.edu.unlam.tallerweb1.controladores;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.unlam.tallerweb1.modelo.EstadoFactura;
import ar.edu.unlam.tallerweb1.modelo.Factura;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFactura;
import ar.edu.unlam.tallerweb1.servicios.ServicioSuscripcion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.time.LocalDate;


@Controller
public class PdfController {
    private ServicioFactura servicioFactura;

    @Autowired
    public PdfController( ServicioFactura servicioFactura) {
        this.servicioFactura=servicioFactura;
    }

    @RequestMapping(value = "/generate/pdf.htm", method = RequestMethod.GET)
    ModelAndView generatePdf(@ModelAttribute("factura") Factura facturaGenerada,
                            HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        /*System.out.println("Calling generatePdf()...");
        Suscripcion suscripcion = new Suscripcion();

        suscripcion.setDescripcion("suscripcion basica");
        suscripcion.setPrecio(100l);

        Usuario usuario =new Usuario();
        usuario.setNombre("Rolo");
        usuario.setApellido("Jota");

        EstadoFactura estadoFactura = new EstadoFactura();
        estadoFactura.setEstado("pago");
        estadoFactura.setId(1l);

        Factura factura = new Factura();
        factura.setUsuarioQuePaga(usuario);
        factura.setSuscripcion(suscripcion);
        factura.setId(2l);
        factura.setEstadoFactura(estadoFactura);

        long ctm=System.currentTimeMillis();
        Date d= new Date(ctm);
        LocalDate localDate = d.toLocalDate();
        Date fechaActual = Date.valueOf(localDate);
        factura.setFecha(fechaActual);*/

       Factura factura = servicioFactura.buscarFacturaPorId(facturaGenerada.getId());


        ModelAndView modelAndView = new ModelAndView("pdfView", "command",factura);

        return modelAndView;
    }

}
