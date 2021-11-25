package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.EstadoFactura;
import ar.edu.unlam.tallerweb1.modelo.Factura;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


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

        EstadoFactura estadoFactura = repositorioFactura.buscarEstadoFacturaPorId(1l);

        Factura factura = new Factura();
        factura.setSuscripcion(usuario.getSuscripcion());
        factura.setUsuarioQuePaga(usuario);
        factura.setEstadoFactura(estadoFactura);

        long ctm=System.currentTimeMillis();
        Date d= new Date(ctm);
        LocalDate localDate = d.toLocalDate();
        Date fechaActual = Date.valueOf(localDate);
        factura.setFecha(fechaActual);
        repositorioFactura.generarFactura(factura);
    }

    @Override
    public Factura buscarFacturaPorId(Long idFactura) {
        return repositorioFactura.buscarFacturaPorId(idFactura);
    }

    @Override
    public Factura buscarUltimaFacturaPorUsuario(Usuario usuario) {
        List<Factura> facturas =repositorioFactura.buscarUltimaFacturaPorUsuario(usuario);

        Factura factura= facturas.get(0);
        return factura;

    }
}
