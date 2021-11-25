package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Denuncia;
import ar.edu.unlam.tallerweb1.modelo.MotivoDenuncia;

public interface ServicioDenuncia {

	List<MotivoDenuncia> traerDenuncia();

	List<Denuncia> listarDenunciasPorCliente(Long id);

	MotivoDenuncia buscarMotivoPorId(Long id);

	void guardar(Denuncia historialDenuncia);

	Denuncia buscarDenunciaPorId(Long id);
}
