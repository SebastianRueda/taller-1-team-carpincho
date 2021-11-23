package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFavoritos;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServicioFavoritosTest {
    private RepositorioFavoritos repositorioFavoritos = Mockito.mock(RepositorioFavoritos.class);
    private ServicioFavoritos servicioFavoritos = new ServicioFavoritosImpl(repositorioFavoritos);

    @Test
    public void clienteAgregaAsistenteASusFavoritosTest() {
        Usuario cliente = givenUnCliente();
        Usuario asistente = givenUnAsistente();
        givenUnClienteYAsistenteParaAgregarAFavoritos(cliente, asistente);
        Favorito favorito = whenClienteAgregaAUnAsistenteComoFavorito(cliente, asistente);
        thenAsistenteSeAgregoCorrectamente(favorito);
    }

    @Test
    public void asistentesFavoritosDeUnClienteTest() {
        var cliente = givenUnCliente();
        var dados = givenUnClienteCon5AsistentesFavoritos(cliente);
        var obtenitos = whenListoLosAsistentesFavoritosDe(cliente);
        thenElClienteTiene5AsistentesFavoritos(dados, obtenitos);
    }

    @Test
    public void removerAsistenteFavoritoTest() {
        var cliente = givenUnCliente();
        var asistente = givenUnAsistente();
        givenUnClienteYUnAsistenteParaRemoverDeFavoritos(cliente, asistente);
        var removio = whenClienteRemueveAUnAsistenteDeFavoritos(cliente, asistente);
        thenElClienteRemovioAlAsistenteDeFavoritos(removio);
    }

    @Test
    public void asistenteEsFavoritoDeUnClienteTest() {
        var cliente = givenUnCliente();
        var asistente = givenUnAsistente();
        givenUnClienteQueTieneAlAsistenteComoFavorito(cliente, asistente);
        var esFavorito = whenConsultoSiElAsistenteEsFavorito(cliente, asistente);
        thenElAsistenteUnFavoritoDelCliente(esFavorito);
    }

    @Test
    public void asistenteNoEsFavoritoDeUnClienteTest() {
        var cliente = givenUnCliente();
        var asistente = givenUnAsistente();
        givenUnClienteQueNoTieneAlAsistenteComoFavorito(cliente, asistente);
        var esFavorito = whenConsultoSiElAsistenteEsFavorito(cliente, asistente);
        thenElAsistenteNoEsUnFavoritoDelCliente(esFavorito);
    }

    private Usuario givenUnCliente() {
        var cliente = new Usuario();
        cliente.setId(new Random().nextLong());
        cliente.setNombre("cliente");

        return cliente;
    }

    private Usuario givenUnAsistente() {
        var asistente = new Usuario();
        asistente.setId(new Random().nextLong());
        asistente.setNombre("asistente");

        return asistente;
    }

    private void givenUnClienteYAsistenteParaAgregarAFavoritos(Usuario cliente, Usuario asistente) {
        Mockito.when(repositorioFavoritos.clienteAgregaAsistenteASusFavoritos(cliente, asistente)).thenReturn(new Favorito());
    }

    private Favorito whenClienteAgregaAUnAsistenteComoFavorito(Usuario cliente, Usuario asistente) {
        var favorito = repositorioFavoritos.clienteAgregaAsistenteASusFavoritos(cliente, asistente);

        return favorito;
    }

    private void thenAsistenteSeAgregoCorrectamente(Favorito favorito) {
        Assert.assertNotNull(favorito);
    }

    private List<Favorito> givenUnClienteCon5AsistentesFavoritos(Usuario cliente) {
        var favoritos = new ArrayList<Favorito>();

        for (int i = 0; i < 5; i++) {
            var asistente = new Usuario();
            asistente.setId((long) i);
        }

        Mockito.when(repositorioFavoritos.listaDeAsistentesFavotitosDe(cliente.getId())).thenReturn(favoritos);

        return favoritos;
    }

    private List<Favorito> whenListoLosAsistentesFavoritosDe(Usuario cliente) {
        return repositorioFavoritos.listaDeAsistentesFavotitosDe(cliente.getId());
    }

    private void thenElClienteTiene5AsistentesFavoritos(List<Favorito> dados, List<Favorito> obtenidos) {
        Assert.assertNotNull(dados);
        Assert.assertNotNull(obtenidos);
        Assert.assertEquals(dados.size(), obtenidos.size());

        for (int i = 0; i < dados.size(); i++) {
            Assert.assertEquals(dados.get(i), obtenidos.get(i));
        }
    }

    private void givenUnClienteYUnAsistenteParaRemoverDeFavoritos(Usuario cliente, Usuario asistente) {
        Mockito.when(repositorioFavoritos.removerAsistenteFavorito(cliente.getId(), asistente.getId()))
                .thenReturn(true);
    }

    private boolean whenClienteRemueveAUnAsistenteDeFavoritos(Usuario cliente, Usuario asistente) {
        return repositorioFavoritos.removerAsistenteFavorito(cliente.getId(), asistente.getId());
    }

    private void thenElClienteRemovioAlAsistenteDeFavoritos(boolean removio) {
        Assert.assertTrue(removio);
    }

    private void givenUnClienteQueTieneAlAsistenteComoFavorito(Usuario cliente, Usuario asistente) {
        Mockito.when(repositorioFavoritos.esFavorito(cliente.getId(), asistente.getId())).thenReturn(true);
    }

    private boolean whenConsultoSiElAsistenteEsFavorito(Usuario cliente, Usuario asistente) {
        return repositorioFavoritos.esFavorito(cliente.getId(), asistente.getId());
    }

    private void thenElAsistenteUnFavoritoDelCliente(boolean esFavorito) {
        Assert.assertTrue(esFavorito);
    }

    private void givenUnClienteQueNoTieneAlAsistenteComoFavorito(Usuario cliente, Usuario asistente) {
        Mockito.when(repositorioFavoritos.esFavorito(cliente.getId(), asistente.getId())).thenReturn(false);
    }

    private void thenElAsistenteNoEsUnFavoritoDelCliente(boolean esFavorito) {
        Assert.assertFalse(esFavorito);
    }
}