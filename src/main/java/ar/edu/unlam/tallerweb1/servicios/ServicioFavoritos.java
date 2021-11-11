package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioFavoritos {
    Favorito clienteAgregaAsistenteASusFavoritos(Usuario cliente, Usuario asistente);
    List<Favorito> listaDeAsistentesFavotitosDe(Long id);
    boolean removerAsistenteFavorito(Long clienteId, Long asistenteId);
    boolean esFavorito(Long clienteId, Long asistenteId);
}
