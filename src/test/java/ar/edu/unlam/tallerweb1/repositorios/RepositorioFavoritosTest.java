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

import java.util.ArrayList;
import java.util.List;

public class RepositorioFavoritosTest extends SpringTest {
    @Autowired
    private RepositorioFavoritos repositorioFavoritos;
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    private Usuario cliente;

    @Before
    public void initCliente() {
        cliente = getNewUsuario();
    }

    @Test
    @Rollback
    @Transactional
    public void clienteAgregaAsistentenComoFavoritoTest() {
        var asisitente = givenUnAsistenten();
        var favorito = whenUnClienteAgregarAlAsistenteAFavoritos(cliente, asisitente);
        thenComprueboQueElAsistentenSeHayaAgregadoCorrectamente(favorito);
    }

    @Test
    @Rollback
    @Transactional
    public void listarAsistentesFavoritosTest() {
        var dada = givenListaDeAsistentesFavoritos();
        var obtenida = whenListoLosAsistentesFavoritos(cliente.getId());
        thenSeListaronCorrectamenteLosAsistentesFavoritos(dada, obtenida);
    }

    @Test
    @Rollback
    @Transactional
    public void removerAsistenteDeFavorito() {
        var asistente = givenUnClienteConUnSoloAsistenteFavorito(cliente);
        var seElimino = whenClienteRemueveAlAsistenteDeFavoritos(cliente, asistente);
        thenElClienteNoTieneFavoritos(cliente, seElimino);
    }

    @Test
    @Rollback
    @Transactional
    public void removerAsistenteQueNoEsFavorito() {
        var asistente = givenUnAsistenten();
        var seElimino = whenClienteRemueveAlAsistenteDeFavoritos(cliente, asistente);
        thenNoSePudoRemoverDeFavoritosAlAsistente(seElimino);
    }

    private Usuario getNewUsuario() {
        var cliente = new Usuario();
        repositorioUsuario.guardar(cliente);

        return cliente;
    }

    private Usuario givenUnAsistenten() {
        return getNewUsuario();
    }

    private Favorito whenUnClienteAgregarAlAsistenteAFavoritos(Usuario cliente, Usuario asisitente) {
        return repositorioFavoritos.clienteAgregaAsistenteASusFavoritos(cliente, asisitente);
    }

    private void thenComprueboQueElAsistentenSeHayaAgregadoCorrectamente(Favorito favorito) {
        Assert.assertNotNull(favorito.getId());
    }

    private List<Favorito> givenListaDeAsistentesFavoritos() {
        var favoritos = new ArrayList<Favorito>();

        for (int i = 0; i < 10; i++) {
            var asistente = new Usuario();
            asistente.setNombre("asistente" + i);
            repositorioUsuario.guardar(asistente);

            var favorito = repositorioFavoritos.clienteAgregaAsistenteASusFavoritos(cliente, asistente);
            favoritos.add(favorito);
        }

        return favoritos;
    }

    private List<Favorito> whenListoLosAsistentesFavoritos(Long clienteId) {
        return repositorioFavoritos.listaDeAsistentesFavotitosDe(clienteId);
    }

    private void thenSeListaronCorrectamenteLosAsistentesFavoritos(List<Favorito> dados, List<Favorito> obtenidos) {
        Assert.assertNotNull(dados);
        Assert.assertNotNull(obtenidos);
        Assert.assertEquals(dados.size(), obtenidos.size());

        for (int i = 0; i < dados.size(); i++) {
            Assert.assertEquals(dados.get(i), obtenidos.get(i));
        }
    }

    private Usuario givenUnClienteConUnSoloAsistenteFavorito(Usuario cliente) {
        var asistente = new Usuario();
        repositorioUsuario.guardar(asistente);

        repositorioFavoritos.clienteAgregaAsistenteASusFavoritos(cliente, asistente);

        return asistente;
    }

    private boolean whenClienteRemueveAlAsistenteDeFavoritos(Usuario cliente, Usuario asistente) {
        return repositorioFavoritos.removerAsistenteFavorito(cliente.getId(), asistente.getId());
    }

    private void thenElClienteNoTieneFavoritos(Usuario cliente, boolean seEliminoAlAsistente) {
        Assert.assertTrue(seEliminoAlAsistente);
        Assert.assertEquals(repositorioFavoritos.listaDeAsistentesFavotitosDe(cliente.getId()).size(), 0);
    }

    private void thenNoSePudoRemoverDeFavoritosAlAsistente(boolean seElimino) {
        Assert.assertFalse(seElimino);
    }
}