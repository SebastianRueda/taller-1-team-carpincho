package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;

@Repository("repositorioPrestaciones")

public class RepositorioEspecialidadesImp implements RepositorioEspecialidades {
	
	private SessionFactory sessionFactory;
	@Autowired
	public RepositorioEspecialidadesImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Prestacion> traerPrestaciones() {
		// TODO Auto-generated method stub
		return null;
	}

}
