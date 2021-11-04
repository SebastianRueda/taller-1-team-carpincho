package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.HistorialDenuncia;
import ar.edu.unlam.tallerweb1.modelo.MotivoDenuncia;


public interface RepositorioDenuncia {

	List<MotivoDenuncia> traerDenuncia();

	List<MotivoDenuncia> listarDenunciasPorCliente(Long id);
	}


