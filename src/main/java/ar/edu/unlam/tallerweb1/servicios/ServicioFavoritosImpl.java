package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFavoritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("servicioFavoritos")
public class ServicioFavoritosImpl implements ServicioFavoritos {
    private RepositorioFavoritos repositorioFavoritos;

    @Autowired
    public ServicioFavoritosImpl(RepositorioFavoritos repositorioFavoritos) {
        this.repositorioFavoritos = repositorioFavoritos;
    }

    @Override
    public Favorito clienteAgregaAsistenteASusFavoritos(Usuario cliente, Usuario asistente) {
        return repositorioFavoritos.clienteAgregaAsistenteASusFavoritos(cliente, asistente);
    }

    @Override
    public List<Favorito> listaDeAsistentesFavotitosDe(Long id) {
        return repositorioFavoritos.listaDeAsistentesFavotitosDe(id);
    }

    @Override
    public boolean removerAsistenteFavorito(Long clienteId, Long asistenteId) {
        return repositorioFavoritos.removerAsistenteFavorito(clienteId,asistenteId);
    }

    @Override
    public boolean esFavorito(Long clienteId, Long asistenteId) {
        return repositorioFavoritos.esFavorito(clienteId, asistenteId);
    }
}
