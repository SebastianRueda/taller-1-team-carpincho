package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
	public Usuario buscar(String email) {
		return (Usuario) sessionFactory.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("email", email))
				.uniqueResult();
	}

	@Override
	public void modificar(Usuario usuario) {
		sessionFactory.getCurrentSession().update(usuario);
	}

	@Override
	public List<Usuario> buscarUsuarioPorRol(String rol) {
		final Session session = sessionFactory.getCurrentSession();
//		final Query namedQuery = session.getNamedQuery("userByRol");
//		namedQuery.setParameter("lalala", rol);
//		return namedQuery.list();
		/*var query = session.createQuery("" +
						"from Usuario u " +
						"join Rol r on r.id = u.rol.id " +
						"where r.descripcion = :r_description")
				.setParameter("r_description", rol);*/
		var list = session.createCriteria(Usuario.class)
				//.add(Restrictions.eq("rol", rol))
				.list();

		var usuarios = new ArrayList<Usuario>();
		list.forEach(e -> {
			var u = (Usuario) e;
			if (u.getRol().getDescripcion().equals(rol)) {
				usuarios.add(u);
			}
		});

		return usuarios;

		/*var usuarios = new ArrayList<Usuario>();

		query.list().forEach(o -> usuarios.add((Usuario) o));

		return usuarios;*/
	}

	@Override
	public List<Usuario> buscarUsuarioConMailLike(String mail) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Usuario.class)
				.add(Restrictions.like("email", "%" + mail + "%"))
				.list();
	}

}
