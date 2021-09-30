package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ServicioSuscripcion {
     List<Suscripcion> mostrarTodasLasSuscripciones();
     Suscripcion buscarSuscripcionPorId(Long idSuscripcion);

     Suscripcion buscarPorNombre(String nombre);
}
