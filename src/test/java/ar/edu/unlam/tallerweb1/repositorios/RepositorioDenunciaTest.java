package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Denuncia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
public class RepositorioDenunciaTest extends SpringTest {


    @Autowired
    private RepositorioDenunciaLImpl repositorioDenuncia;
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Test
    @Rollback
    @Transactional
    public void mostrarHistorialDeDenunciasHechasPorUnUsuario() {
        Usuario usuario =givenUnUsuarioConDenunciasHechas();
        List<Denuncia> listaDeDenuncias= whenRecibiListaConHistorialDeDenunciasHechasPorUnUsuario(usuario);
        thenComprobarQueLaListaNoEstaVacia(listaDeDenuncias);

    }

    private void thenComprobarQueLaListaNoEstaVacia(List<Denuncia> listaDeDenuncias) {
        Assertions.assertThat(listaDeDenuncias.size()).isEqualTo(5);
    }

    private List<Denuncia> whenRecibiListaConHistorialDeDenunciasHechasPorUnUsuario(Usuario usuario) {
        return repositorioDenuncia.mostrarHistorialDeDenunciasRealizadasPorUnUsuario(usuario);
    }

    private Usuario givenUnUsuarioConDenunciasHechas() {
        Usuario usuario = new Usuario();
        usuario.setId(1l);
        repositorioUsuario.guardarUsuario(usuario);
        for (Integer i=0; i<5; i++){
            Denuncia denuncia = new Denuncia();
            denuncia.setUsuarioDenunciante(usuario);
            repositorioDenuncia.guardarDenuncia(denuncia);
        }
        return usuario;
    }
}
