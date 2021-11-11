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
    public Favorito clienteAgregaAsistenteASusFavoritos(Usuario cliente, Usuario asistente) {
        if (cliente.getId().equals(asistente.getId())) {
            //throw new IllegalArgumentException("El cliente no puede agregarse así mismo como favorito");
            return null;
        }

        var favorito = new Favorito(cliente, asistente);
        getSession().save(favorito);

        return favorito;
    }

    @Override
    public List<Favorito> listaDeAsistentesFavotitosDe(Long id) {
        var query = getSession().createQuery("FROM Favorito WHERE cliente.id=:id");
        query.setParameter("id", id);

        return  (List<Favorito>) query.list();
    }

    @Override
    public boolean removerAsistenteFavorito(Long clienteId, Long asistenteId) {
        var query = getSession().createQuery("DELETE FROM Favorito " +
                "WHERE cliente.id = :clienteId AND asistente.id = :asistenteId");
        query.setParameter("clienteId", clienteId);
        query.setParameter("asistenteId", asistenteId);

        try {
            return query.executeUpdate() == 1;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public boolean esFavorito(Long clienteId, Long asistenteId) {
        var query = getSession().createQuery("FROM Favorito  WHERE  cliente.id = :clienteId AND asistente.id = :asistenteId");
        query.setParameter("clienteId", clienteId);
        query.setParameter("asistenteId", asistenteId);

        return !query.list().isEmpty();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
