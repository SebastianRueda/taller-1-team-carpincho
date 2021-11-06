package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface RepositorioFavoritos {
    void removerAsistenteDeFavoritos(Favorito favorito);
    Favorito clienteAgregaAsistenteASusFavoritos(Usuario cliente, Usuario asistente) throws IllegalArgumentException;
    List<Favorito> listaDeAsistentesFavotitosDe(Long id);
}
