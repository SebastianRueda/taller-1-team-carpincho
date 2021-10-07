package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ServicioUsuarioTest
{
    private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
    private ServicioUsuarioImpl servicioUsuario = new ServicioUsuarioImpl(repositorioUsuario);
    private Long idUsuarioQueNoExiste=8l;
    private Long idUsuarioQueExiste=1l;
    private Usuario usuarioQueExiste = new Usuario();

    @Test
     public void buscarUnUsuarioPorIdYNoSeEncuentra(){

        givenIdDeUnUsuarioQueNoExiste();
        Usuario usuarioEncontrado = whenSeBuscaUsuarioPorId();
        ThenNoSeEncuentraElUsuarioBuscado(usuarioEncontrado);

     }

     @Test
     public void buscarUnUsuarioPorIdYEncuentrarlo(){
        givenIdDeUnUsuarioQueExiste(usuarioQueExiste);
        Usuario usuarioEncontrado=whenSeBuscaUsuarioPorId();
        thenSeEncuentraAlUsuarioBuscado(usuarioEncontrado);
     }

    private void givenIdDeUnUsuarioQueNoExiste() {

    }

    private void givenIdDeUnUsuarioQueExiste(Usuario usuarioQueExiste) {
        usuarioQueExiste.setId(1l);
        usuarioQueExiste.setEmail("lea@lea.com");
        servicioUsuario.save(usuarioQueExiste);
    }

    private Usuario whenSeBuscaUsuarioPorId() {
        Usuario usuarioEncontrado = servicioUsuario.usuarioFindById(idUsuarioQueExiste);
        return usuarioEncontrado;
    }

    private void ThenNoSeEncuentraElUsuarioBuscado(Usuario usuarioEncontrado) {
        assertThat(usuarioEncontrado).isNull();
    }

    private void thenSeEncuentraAlUsuarioBuscado(Usuario usuarioEncontrado) {
        assertThat(usuarioEncontrado.getId()).isEqualTo(idUsuarioQueExiste);
//        assertThat(usuarioEncontrado.getId()).isEqualTo(idUsuarioQueExiste);
    }
}
