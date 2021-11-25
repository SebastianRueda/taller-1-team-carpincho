package ar.edu.unlam.tallerweb1.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.unlam.tallerweb1.modelo.Factura;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import com.lowagie.text.Chunk;






public class PDFView extends AbstractPdfView {


    @Override
    protected void buildPdfDocument(Map model,
                                    Document document, PdfWriter writer, HttpServletRequest req,
                                    HttpServletResponse resp) throws Exception {


        Factura factura = (Factura) model.get("command");
        String titulo= "Factura del cliente: "+factura.getUsuarioQuePaga().fullName();

        Paragraph header = new Paragraph(new Chunk(titulo, FontFactory.getFont(FontFactory.HELVETICA, 30)));
        Paragraph fecha = new Paragraph(new Chunk(" Fecha Facturacion: " + factura.getFecha(),FontFactory.getFont(FontFactory.HELVETICA, 20)));
        Paragraph suscripcion = new Paragraph(new Chunk(" Tipo Suscripcion: " + factura.getSuscripcion().getDescripcion() ,FontFactory.getFont(FontFactory.HELVETICA, 20)));
        Paragraph precio  = new Paragraph(new Chunk(" Precio: $" + factura.getSuscripcion().getPrecio() +"/Mes",FontFactory.getFont(FontFactory.HELVETICA, 20)));
        Paragraph estadoFactura = new Paragraph(new Chunk(" Estado de la Factura: " + factura.getEstadoFactura().getEstado() ,FontFactory.getFont(FontFactory.HELVETICA, 20)));

        document.add(header);
        document.add(suscripcion);
        document.add(precio);
        document.add(estadoFactura);
        document.add(fecha);

    }
}
