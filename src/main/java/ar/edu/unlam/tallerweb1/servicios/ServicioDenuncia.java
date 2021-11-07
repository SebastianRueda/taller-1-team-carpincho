package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.HistorialDenuncia;
import ar.edu.unlam.tallerweb1.modelo.MotivoDenuncia;

public interface ServicioDenuncia {

	List<MotivoDenuncia> traerDenuncia();

	List<HistorialDenuncia> listarDenunciasPorCliente(Long id);

	MotivoDenuncia buscarPorId(Long id);

	void guardar(HistorialDenuncia historialDenuncia);
}
