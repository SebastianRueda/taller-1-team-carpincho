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
@Transactional
public class ServicioSuscripcionImpl implements ServicioSuscripcion {


    private RepositorioSuscripcion repositorioSuscripcion;
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioSuscripcionImpl(RepositorioSuscripcion repositorioSuscripcion, RepositorioUsuario repositorioUsuario) {
        this.repositorioSuscripcion = repositorioSuscripcion;
        this.repositorioUsuario = repositorioUsuario;
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
    public void cancelarSuscripcion(String email) throws Exception {
        Usuario usuario = repositorioUsuario.buscarUsuarioPorMail(email);
        if (usuario.getSuscripcion() == null) {
            throw new Exception();
        } else {
            usuario.setSuscripcion(null);
            repositorioUsuario.modificar(usuario);
        }

    }

    @Override
    public void modificarSuscripcionBasicaAPremium(String email, Suscripcion suscripcionPremium) throws Exception {
        Usuario usuario = repositorioUsuario.buscarUsuarioPorMail(email);
        if (usuario.getSuscripcion() == null ) {
            throw new Exception();
        } else {
            usuario.setSuscripcion(suscripcionPremium);
            repositorioUsuario.modificar(usuario);
        }
    }

    @Override
    public void upGradeSuscripcionBasicaAPremium(Usuario usuarioEnSession, Suscripcion suscripcionPremium) throws Exception{
        if (suscripcionPremium.getId() == 1l) {
            throw new Exception();
        }
        usuarioEnSession.setSuscripcion(suscripcionPremium);
        repositorioUsuario.modificar(usuarioEnSession);
    }

    @Override
    public void downGradeSuscripcionBasicaAPremium(Usuario usuarioEnSession, Suscripcion suscripcionBasica) throws Exception {
        if (suscripcionBasica.getId() == 2l) {
            throw new Exception();
        }
        usuarioEnSession.setSuscripcion(suscripcionBasica);
        repositorioUsuario.modificar(usuarioEnSession);
    }


}
