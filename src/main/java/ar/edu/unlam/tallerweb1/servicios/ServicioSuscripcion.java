package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;


public interface ServicioSuscripcion {
    List<Suscripcion> mostrarTodasLasSuscripciones();

    Suscripcion buscarSuscripcionPorId(Long idSuscripcion);

    Suscripcion buscarPorNombre(String nombre);

    void cancelarSuscripcion(String email) throws Exception;

    void modificarSuscripcionBasicaAPremium(String email, Suscripcion suscripcionPremium) throws Exception;

    void upGradeSuscripcionBasicaAPremium(Usuario usuarioEnSession, Suscripcion suscripcionPremium) throws Exception;

    void downGradeSuscripcionBasicaAPremium(Usuario usuarioEnSession, Suscripcion suscripcionBasica) throws Exception;

    void verificarSuscripcionActiva(Usuario usuarioLogueado);
}
