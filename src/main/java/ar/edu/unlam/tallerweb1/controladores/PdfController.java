package ar.edu.unlam.tallerweb1.controladores;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class PdfController {

    @RequestMapping(value = "/generate/pdf.htm", method = RequestMethod.GET)
    ModelAndView generatePdf(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        System.out.println("Calling generatePdf()...");

        Usuario usuario = new Usuario();
        usuario.setApellido("hola");

        ModelAndView modelAndView = new ModelAndView("pdfView", "command",usuario);

        return modelAndView;
    }

}
