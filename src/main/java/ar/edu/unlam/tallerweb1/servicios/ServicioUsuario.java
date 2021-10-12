package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioUsuario {
    void save(Usuario nuevoUsuario);
    void delete(Usuario usuario);
    void update(Usuario usuario);
    List<Usuario> getAll();
    Usuario usuarioFindById(Long id);
    Usuario buscarUsuarioPorMail(String email);
}

