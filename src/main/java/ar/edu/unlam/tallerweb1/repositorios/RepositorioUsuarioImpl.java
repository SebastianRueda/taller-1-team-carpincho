package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// implelemtacion del repositorio de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
@Repository("repositorioUsuario")
public class RepositorioUsuarioImpl implements RepositorioUsuario {

	// Maneja acciones de persistencia, normalmente estara inyectado el session factory de hibernate
	// el mismo esta difinido en el archivo hibernateContext.xml
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioUsuarioImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Usuario buscarUsuario(String email, String password) {

		// Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
		// de busqueda de Usuario donde el email y password sean iguales a los del objeto recibido como parametro
		// uniqueResult da error si se encuentran mas de un resultado en la busqueda.
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password))
				.uniqueResult();
	}

	@Override
	public void guardar(Usuario usuario) {
		sessionFactory.getCurrentSession().save(usuario);
	}

	@Override
	public Usuario buscarUsuarioPorMail(String email) {
		return (Usuario) sessionFactory.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("email", email))
				.uniqueResult();
	}

	@Override
	public void modificar(Usuario usuario) {
		sessionFactory.getCurrentSession().update(usuario);
	}

	@Override
	public List usuariosDeLaEspecialidadYprovincia(Long idEspecialidad, Long idProvincia){
		return sessionFactory.getCurrentSession().createCriteria(Usuario.class)
				.createAlias("especialidad", "especialidadBuscada")
				.createAlias("provincia","provinciaBuscada")
				.add(Restrictions.eq("especialidadBuscada.id",idEspecialidad))
				.add(Restrictions.eq("provinciaBuscada.id", idProvincia))
				.list();
	}

	@Override
	public List<Usuario> buscarUsuarioPorRol(String rol) {
		return null;
	}

	@Override
	public List<Usuario> buscarUsuarioConMailLike(String mail) {
		return null;
	}


	@Override
	public void delete(Usuario usuario) {
			sessionFactory.getCurrentSession().delete(usuario);
	}

	@Override
	public Usuario usuarioFindById(Long id) {
		return (Usuario) sessionFactory.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public List<Usuario> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Usuario.class).list();
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().save(usuario);
	}

	@Override
	public List<Usuario> usuariosDeLaEspecialidad(Long idEspecialidad) {
		return sessionFactory.getCurrentSession().createCriteria(Usuario.class)
				.createAlias("especialidad", "especialidadBuscada")
				.add(Restrictions.eq("especialidadBuscada.id",idEspecialidad))
				.list();
	}

	@Override
	public List <Usuario> usuariosDeLaProvincia(Long idProvincia) {
		return sessionFactory.getCurrentSession().createCriteria(Usuario.class)
				.createAlias("provincia","provinciaBuscada")
				.add(Restrictions.eq("provinciaBuscada.id",idProvincia))
				.list();
	}


//	@Override
//	public Usuario buscarUsuarioPorMail(String rol) {
//		return null;
//	}
}
