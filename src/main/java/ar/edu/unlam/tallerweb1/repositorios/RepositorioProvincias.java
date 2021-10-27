package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Provincia;

public interface RepositorioProvincias {
	List<Provincia> traerProvincia();
	void save(Provincia provincia);
	void delete(Provincia provinciaExistente);
	void update(Provincia provinciaExistente);
}
