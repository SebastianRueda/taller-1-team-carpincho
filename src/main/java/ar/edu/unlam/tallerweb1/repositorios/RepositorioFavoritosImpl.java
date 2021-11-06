package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioFavoritos")
public class RepositorioFavoritosImpl implements RepositorioFavoritos {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioFavoritosImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void removerAsistenteDeFavoritos(Favorito favorito) {
        getSession().delete(favorito);
    }

    @Override
    public Favorito clienteAgregaAsistenteASusFavoritos(Usuario cliente, Usuario asistente) throws IllegalArgumentException {
        if (cliente.getId().equals(asistente.getId())) {
            throw new IllegalArgumentException("El cliente no puede agregarse así mismo como favorito");
        }

        var favorito = new Favorito(cliente, asistente);
        getSession().save(favorito);

        return favorito;
    }

    @Override
    public List<Favorito> listaDeAsistentesFavotitosDe(Long id) {
        var query = getSession().createQuery("FROM Favorito  where cliente.id=:id");
        query.setParameter("id", id);

        return  (List<Favorito>) query.list();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
