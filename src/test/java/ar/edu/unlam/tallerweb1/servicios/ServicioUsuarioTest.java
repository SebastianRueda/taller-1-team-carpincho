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



//     @Test
//     public void buscarUnUsuarioPorIdYEncuentrarlo(){
//        givenIdDeUnUsuarioQueExiste();
//        Usuario usuarioEncontrado=whenSeBuscaUsuarioPorId();
//        thenSeEncuentraAlUsuarioBuscado(usuarioEncontrado);
//     }

    private void givenIdDeUnUsuarioQueNoExiste() {

    }

//    private void givenIdDeUnUsuarioQueExiste() {
//        usuarioQueExiste.setId(1l);
//        usuarioQueExiste.setEmail("lea@lea.com");
//    }

    private Usuario whenSeBuscaUsuarioPorId() {
        servicioUsuario.save(usuarioQueExiste);
        Usuario usuarioEncontrado = servicioUsuario.usuarioFindById(usuarioQueExiste.getId());
        return usuarioEncontrado;
    }

    private void ThenNoSeEncuentraElUsuarioBuscado(Usuario usuarioEncontrado) {
        assertThat(usuarioEncontrado).isNull();
    }

//    private void thenSeEncuentraAlUsuarioBuscado(Usuario usuarioEncontrado) {
//        assertThat(usuarioEncontrado.getId()).isEqualTo(idUsuarioQueExiste);
//        assertThat(usuarioEncontrado.getId()).isEqualTo(idUsuarioQueExiste);
//    }
}
