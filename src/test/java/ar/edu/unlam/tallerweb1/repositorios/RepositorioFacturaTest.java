package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Factura;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class RepositorioFacturaTest extends SpringTest {

    @Autowired
    private RepositorioFactura repositorioFactura;
    @Autowired
    private RepositorioSuscripcion repositorioSuscripcion;
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Test
    @Rollback
    @Transactional
    public void generarUnaFacturaYGuardarla(){
     Factura factura=  givenUnUsuarioConSuscripcion();
        whenGeneroUnFacturaYLaGuardo(factura);
        thenVerficoQueLaFacturaSeGuardoCorrectamente(factura);


    }

    private void thenVerficoQueLaFacturaSeGuardoCorrectamente(Factura factura) {
        Assertions.assertThat(repositorioFactura.buscarFacturaPorId(factura.getId())).isNotNull();
    }

    private void whenGeneroUnFacturaYLaGuardo(Factura factura) {
        repositorioFactura.generarFactura(factura);
    }

    private Factura givenUnUsuarioConSuscripcion() {
        Usuario usuario= new Usuario();
        Suscripcion suscripcion= new Suscripcion();
        suscripcion.setId(1l);
        suscripcion.setDescripcion("basica");
        usuario.setId(1l);
        usuario.setSuscripcion(suscripcion);

        Factura factura = new Factura();
        factura.setId(1l);
        factura.setUsuarioQuePaga(usuario);
        factura.setSuscripcion(suscripcion);
        repositorioSuscripcion.guardarSuscripcion(suscripcion);
        repositorioUsuario.guardarUsuario(usuario);
        return factura;
    }

}
