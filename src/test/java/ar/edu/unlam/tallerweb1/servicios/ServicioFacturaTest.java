package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Factura;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFactura;
import org.junit.Test;
import org.mockito.Mock;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.assertThat;


public class ServicioFacturaTest {
        private RepositorioFactura repositorioFactura= mock(RepositorioFactura.class);
        private ServicioFactura servicioFactura = new ServicioFacturaImpl(repositorioFactura);

/*
    @Test
    public void seGeneraUnaFacturaCuandoElUsuarioContrataSuscripcion(){
       Usuario usuario= givenUnUsuarioConSuscripcion();
        whenElUsuarioContrataSuscripcionSeGeneraUnaFactura(usuario);
        thenVerificoQueSeLlamoAGenerarFactura();
    }

    @Test
    public void mostrarLaUltimaFacturaDelUsuario(){
      Usuario usuario=  givenUnUsuarioQueTieneFactura();
      Factura factura=  whenBuscoLaUltimaFacturaDelUsuario(usuario);
        thenVerficoQueObtuveUnaFactura(factura);
    }

    private void thenVerficoQueObtuveUnaFactura( Factura factura) {
        assertThat(factura.getFecha().getMonth()).isEqualTo(3);
    }

    private Usuario givenUnUsuarioQueTieneFactura() {
        Usuario usuario = new Usuario();
        long ctm=System.currentTimeMillis();
        Date d= new Date(ctm);
        LocalDate localDate = d.toLocalDate();
        Date fechaActual = Date.valueOf(localDate);
        List<Factura>facturas= new ArrayList<>();
        for (int i=1; i<4; i++){
            fechaActual.setMonth(i);
            Factura factura1 = new Factura();
            factura1.setFecha(fechaActual);
            factura1.setUsuarioQuePaga(usuario);
            facturas.add(factura1);
            repositorioFactura.generarFactura(factura1);
        }


        when(repositorioFactura.buscarUltimaFacturaPorUsuario(usuario)).thenReturn(facturas.get(2));
        return usuario;
    }

    private Factura whenBuscoLaUltimaFacturaDelUsuario(Usuario usuario) {
        return servicioFactura.buscarUltimaFacturaPorUsuario(usuario);
    }

    private Usuario givenUnUsuarioConSuscripcion() {
        Usuario usuario = new Usuario();
        usuario.setId(1l);
        Suscripcion suscripcion= new Suscripcion();
        suscripcion.setId(1l);
        usuario.setSuscripcion(suscripcion);
        return usuario;
    }



    private void whenElUsuarioContrataSuscripcionSeGeneraUnaFactura( Usuario usuario) {
        servicioFactura.generarFactura(usuario);

    }
    private void thenVerificoQueSeLlamoAGenerarFactura() {
       verify(repositorioFactura,times(1)).generarFactura(anyObject());
    }


*/
}
