package ar.edu.unlam.tallerweb1.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        Usuario usuario = (Usuario) model.get("command");

        Paragraph header = new Paragraph(new Chunk("Generate Pdf USing Spring Mvc", FontFactory.getFont(FontFactory.HELVETICA, 30)));
        Paragraph by = new Paragraph(new Chunk("Author " + usuario.getApellido() + " " +usuario.getApellido(),FontFactory.getFont(FontFactory.HELVETICA, 20)));

        document.add(header);
        document.add(by);

    }
}
