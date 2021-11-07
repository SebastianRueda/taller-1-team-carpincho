package ar.edu.unlam.tallerweb1.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.modelo.HistorialDenuncia;
import ar.edu.unlam.tallerweb1.modelo.MotivoDenuncia;
import ar.edu.unlam.tallerweb1.modelo.Prestacion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

@Repository("repositorioDenuncia")
public class RepositorioDenunciaImpl implements RepositorioDenuncia {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioDenunciaImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<MotivoDenuncia> traerDenuncia() {
		return sessionFactory.getCurrentSession().createCriteria(MotivoDenuncia.class).list();
	}

	@Override
	public List<HistorialDenuncia> listarDenunciasPorCliente(Long id) {
		final Session session = sessionFactory.getCurrentSession();

        List denuncias = session.createCriteria(HistorialDenuncia.class)
                .add(Restrictions.eq("usuarioSolicitante.id", id))
                .list();

		return denuncias;
	}

	@Override
	public MotivoDenuncia buscarPorId(Long id) {
		final var session = sessionFactory.getCurrentSession();

		return (MotivoDenuncia) session.createCriteria(MotivoDenuncia.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void guardar(HistorialDenuncia historialDenuncia) {
		sessionFactory.getCurrentSession().save(historialDenuncia);
	}
}
