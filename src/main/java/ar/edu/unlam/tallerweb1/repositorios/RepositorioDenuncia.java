package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Denuncia;
import ar.edu.unlam.tallerweb1.modelo.MotivoDenuncia;


public interface RepositorioDenuncia {

	List<MotivoDenuncia> traerDenuncia();

	List<Denuncia> listarDenunciasPorCliente(Long id);

	MotivoDenuncia buscarPorId(Long id);

	void guardar(Denuncia historialDenuncia);
}


