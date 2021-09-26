package ar.edu.unlam.tallerweb1.servicios;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.Provincia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEspecialidades;
@Service("ServicioFiltro")
@Transactional
public class ServicioFiltroImp implements ServicioFiltro{
	private RepositorioEspecialidades repositorioEspecialidades;
	
	@Autowired
	public ServicioFiltroImp(RepositorioEspecialidades repositorioEspecialidades) {
		this.repositorioEspecialidades=repositorioEspecialidades;
	}
	
	@Override
	public Set<Prestacion> traerPrestaciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Provincia> traerprovincia() {
		// TODO Auto-generated method stub
		return null;
	}

}
