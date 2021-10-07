package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;


public interface ServicioSuscripcion {
     List<Suscripcion> mostrarTodasLasSuscripciones();
     Suscripcion buscarSuscripcionPorId(Long idSuscripcion);

     Suscripcion buscarPorNombre(String nombre);


    Usuario cancelarSuscripcion(String email);
}
