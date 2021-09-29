package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;

import java.util.List;

public interface RepositorioSuscripcion {

     List<Suscripcion> mostrarTodasLasSuscripciones();

    Suscripcion buscarSuscripcionPorID(Long idSuscripcion);
}
