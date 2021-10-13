package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface RepositorioSuscripcion {

     List<Suscripcion> mostrarTodasLasSuscripciones();

    Suscripcion buscarPorNombre(String nombre);

    void guardarSuscripcion(Suscripcion suscripcion);

    Suscripcion buscarSuscripcionPorId(Long id);

    Suscripcion actualizarSuscripcionDeUsuario(Long id);
}
