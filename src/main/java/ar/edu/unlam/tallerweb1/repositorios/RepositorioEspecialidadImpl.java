package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

@Repository("repositorioEspecialidad")
public class RepositorioEspecialidadImpl implements RepositorioEspecialidad {
	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioEspecialidadImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Especialidad especialidad) {
		getSession().save(especialidad);
	}

	@Override
	public void update(Especialidad especialidad) {
		getSession().update(especialidad);
	}

	@Override
	public void delete(Especialidad especialidad) {
		getSession().delete(especialidad);
	}

	@Override
	public Especialidad find(Especialidad especialidad) {
		var query = getSession().createQuery("from Especialidad where id=:id");
		query.setParameter("id", especialidad.getId());

		List<Especialidad> especialidades = query.list();

		if (especialidades.size() > 0) {
			return especialidades.get(0);
		} else {
			return null;
		}
	}
	
	//metodo que hace la precarga de los option Especialidad de la pagina de busquedaPrestadores.jsp
	@Override
	public List<Especialidad> traerEspecialidad() {
		return getSession().createCriteria(Especialidad.class).list();
	}
	
	//metodo necesario para poder evitar que el usuario pase por GET un id de un Usuario que no corresponda.
	public Especialidad traerEspecialidadPorId(Long id){
		return (Especialidad) getSession().createCriteria(Especialidad.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

}
