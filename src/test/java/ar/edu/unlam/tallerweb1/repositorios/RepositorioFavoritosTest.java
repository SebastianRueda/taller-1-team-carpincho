package ar.edu.unlam.tallerweb1.repositorios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import org.springframework.test.annotation.Rollback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class RepositorioFavoritosTest extends SpringTest {
    @Autowired
    private RepositorioFavoritos repositorioFavoritos;
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    private Usuario cliente;

    @Before
    public void initCliente() {
        cliente = new Usuario();
        repositorioUsuario.guardar(cliente);
    }

    @Test
    @Rollback
    @Transactional
    public void clienteAgregaAsistentenComoFavoritoTest() {
        var cliente = getNewUsuario();
        var asisitente = getNewUsuario();

        var favorito = whenUnClienteAgregarAlAsistenteAFavoritos(cliente, asisitente);
        thenComprueboQueElAsistentenSeHayaAgregadoCorrectamente(favorito);
    }

    @Test
    @Rollback
    @Transactional
    public void listarAsistentesFavoritosTest() {
        /*givenListaDeAsistentes()
        when*/
    }

    private Usuario getNewUsuario() {
        var cliente = new Usuario();
        repositorioUsuario.guardar(cliente);

        return cliente;
    }

    private Favorito whenUnClienteAgregarAlAsistenteAFavoritos(Usuario cliente, Usuario asisitente) {
        return repositorioFavoritos.clienteAgregaAsistenteASusFavoritos(cliente, asisitente);
    }

    private void thenComprueboQueElAsistentenSeHayaAgregadoCorrectamente(Favorito favorito) {
        Assert.assertNotNull(favorito.getId());
    }
}