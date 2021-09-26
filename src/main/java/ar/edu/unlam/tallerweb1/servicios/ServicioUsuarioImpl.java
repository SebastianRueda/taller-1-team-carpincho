package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

import java.util.List;

public class ServicioUsuarioImpl implements ServicioUsuario {

    private RepositorioUsuario usuarioDao;

    @Override
    public void save(Usuario nuevoUsuario) {
        usuarioDao.guardar(nuevoUsuario);
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);

    }

    @Override
    public void update(Usuario usuario) {
        usuarioDao.modificar(usuario);

    }

    @Override
    public List<Usuario> getAll() {
        List<Usuario>usuarios = usuarioDao.getAll();
        return usuarios;
    }

    @Override
    public Usuario usuarioFindById(Long id) {
        return usuarioDao.usuarioFindById(id);
    }
}
