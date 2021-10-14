package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	Usuario buscarUsuario(String email, String password);
	void guardar(Usuario usuario);
    Usuario buscarUsuarioPorMail(String email);
	void modificar(Usuario usuario);
	List<Usuario> usuariosDeLaEspecialidadYprovincia(Long idEspecialidad, Long idProvincia);
    List<Usuario> buscarUsuarioPorRol(String rol);
    List<Usuario> buscarUsuarioConMailLike(String mail);
    void delete(Usuario usuario);

    Usuario usuarioFindById(Long id);

    List<Usuario> getAll();

    void guardarUsuario(Usuario usuario);


    List<Usuario> usuariosDeLaEspecialidad(Long idEspecialidad);

    List<Usuario> usuariosDeLaProvincia(Long idProvincia);
}
