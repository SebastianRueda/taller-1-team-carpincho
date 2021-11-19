package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFactura;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.assertThat;


public class ServicioFacturaTest {
        private RepositorioFactura repositorioFactura= mock(RepositorioFactura.class);
        private ServicioFactura servicioFactura = new ServicioFacturaImpl(repositorioFactura);


    @Test
    public void seGeneraUnaFacturaCuandoElUsuarioContrataSuscripcion(){
       Usuario usuario= givenUnUsuarioConSuscripcion();
        whenElUsuarioContrataSuscripcionSeGeneraUnaFactura(usuario);
        thenVerificoQueSeLlamoAGenerarFactura();
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



}
