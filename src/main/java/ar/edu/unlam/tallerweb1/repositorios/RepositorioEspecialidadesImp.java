package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import org.hibernate.SessionFactory;

@Repository("repositorioEspecialidades")
public class RepositorioEspecialidadesImp implements RepositorioEspecialidades {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioEspecialidadesImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Especialidad> traerEspecialidad() {
		return sessionFactory.getCurrentSession().createCriteria(Especialidad.class).list();
	}

}
