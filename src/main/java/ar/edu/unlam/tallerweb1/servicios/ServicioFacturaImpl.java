package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Factura;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

import static java.time.LocalDate.*;



@Service("servicioFactura")
@Transactional
public class ServicioFacturaImpl implements ServicioFactura{
    private RepositorioFactura repositorioFactura;
    @Autowired
    public ServicioFacturaImpl(RepositorioFactura repositorioFactura) {
        this.repositorioFactura=repositorioFactura;
    }


    @Override
    public void generarFactura(Usuario usuario) {

        Factura factura = new Factura();
        factura.setSuscripcion(usuario.getSuscripcion());
        factura.setUsuarioQuePaga(usuario);

        long ctm=System.currentTimeMillis();
        Date d= new Date(ctm);
        LocalDate localDate = d.toLocalDate();
        Date fechaActual = Date.valueOf(localDate);
        factura.setFecha(fechaActual);
        repositorioFactura.generarFactura(factura);
    }
}
