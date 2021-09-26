package ar.edu.unlam.tallerweb1.servicios;

import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.Provincia;


public interface ServicioFiltro {

	Set<Prestacion> traerPrestaciones();
	Set<Provincia> traerprovincia();
	
}
