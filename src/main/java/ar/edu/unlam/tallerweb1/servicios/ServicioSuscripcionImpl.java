package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSuscripcion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioSuscripcion")

public class ServicioSuscripcionImpl implements ServicioSuscripcion{


    private RepositorioSuscripcion repositorioSuscripcion;
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioSuscripcionImpl(RepositorioSuscripcion repositorioSuscripcion){
        this.repositorioSuscripcion = repositorioSuscripcion;
    }

    public ServicioSuscripcionImpl(RepositorioSuscripcion repositorioSuscripcion, RepositorioUsuario repositorioUsuario) {
        this.repositorioSuscripcion = repositorioSuscripcion;
        this.repositorioUsuario = repositorioUsuario;
    }

    public ServicioSuscripcionImpl() {
    }

    @Override
    public List<Suscripcion> mostrarTodasLasSuscripciones() {
        List<Suscripcion> listaDeSuscripciones = repositorioSuscripcion.mostrarTodasLasSuscripciones();
        return listaDeSuscripciones;
    }

    @Override
    public Suscripcion buscarSuscripcionPorId(Long idSuscripcion) {
        Suscripcion suscripcion = repositorioSuscripcion.buscarSuscripcionPorId(idSuscripcion);
        return suscripcion;
    }

    @Override
    public Suscripcion buscarPorNombre(String nombre) {
        Suscripcion suscripcion = repositorioSuscripcion.buscarPorNombre(nombre);
        return suscripcion;
    }

    @Override
    public Usuario cancelarSuscripcion(String email) {
        Usuario usuario=    repositorioUsuario.buscar(email);
        usuario.setSuscripcion(null);
        repositorioUsuario.modificar(usuario);
        return usuario;
    }


}
