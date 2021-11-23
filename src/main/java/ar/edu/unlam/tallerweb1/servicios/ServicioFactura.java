package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Factura;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioFactura{

    void generarFactura(Usuario usuario);
    Factura buscarFacturaPorId(Long idFactura);
}
