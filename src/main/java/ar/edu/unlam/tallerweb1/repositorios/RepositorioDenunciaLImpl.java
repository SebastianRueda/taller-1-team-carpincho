package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.modelo.Denuncia;
import java.util.List;

import org.hibernate.SessionFactory;

@Repository("repositorioDenunciaL")
public class RepositorioDenunciaLImpl implements RepositorioDenunciaL {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioDenunciaLImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Denuncia> mostrarHistorialDeDenunciasRealizadasPorUnUsuario(Usuario usuario) {
        return sessionFactory.getCurrentSession().createCriteria(Denuncia.class)
                .add(Restrictions.eq("usuarioDenunciante.id",usuario.getId())).list();
    }

    @Override
    public void guardarDenuncia(Denuncia denuncia) {
        sessionFactory.getCurrentSession().save(denuncia);

    }
}
