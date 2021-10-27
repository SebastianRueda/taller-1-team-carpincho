package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.Provincia;

@Repository("repositorioProvincias")
public class RepositorioProvinciasImp implements RepositorioProvincias{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioProvinciasImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Provincia> traerProvincia() {
		return sessionFactory.getCurrentSession().createCriteria(Provincia.class).list();
	}
	@Override
	public void save(Provincia provincia) {
		sessionFactory.getCurrentSession().save(provincia);	
	}

	@Override
    public void delete(Provincia provinciaExistente) { 
		sessionFactory.getCurrentSession().delete(provinciaExistente);
    }

	@Override
    public void update(Provincia provinciaExistente) {
		sessionFactory.getCurrentSession().update(provinciaExistente);
    }

}
