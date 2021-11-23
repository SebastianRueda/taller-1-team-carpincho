package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.EstadoFactura;
import ar.edu.unlam.tallerweb1.modelo.Factura;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;

public interface RepositorioFactura {

    void generarFactura(Factura factura);

    Factura buscarFacturaPorId(Long id);

    EstadoFactura buscarEstadoFacturaPorId(Long idEstadoFactura);
}
