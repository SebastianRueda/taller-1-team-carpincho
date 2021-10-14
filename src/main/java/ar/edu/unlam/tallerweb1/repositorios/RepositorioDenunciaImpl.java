package ar.edu.unlam.tallerweb1.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.modelo.Denuncia;
import java.util.List;

import org.hibernate.SessionFactory;

@Repository("repositorioDenuncia")
public class RepositorioDenunciaImpl implements RepositorioDenuncia {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioDenunciaImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Denuncia> traerDenuncia() {
		return sessionFactory.getCurrentSession().createCriteria(Denuncia.class).list();
	}
}
