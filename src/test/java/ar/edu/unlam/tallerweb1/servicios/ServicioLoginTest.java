package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioLoginTest {

    public static final String EMAIL = "seba@seba.com";
    private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
    private ServicioLogin servicioLogin = new ServicioLoginImpl(repositorioUsuario);

    @Test(expected = Exception.class)
    public void siMeRegistroConUsuarioExistenteDaError() throws Exception {
        givenUsuarioYaExiste(EMAIL);
        whenResgistro(EMAIL);
        thenElUsuarioNoSeGuarda();
    }

    @Test
    public void deberiaRegistrarUsuarioSiNoExiste() throws Exception {
        givenUsuarioNoExiste(EMAIL);
        Usuario creado = whenResgistro(EMAIL);
        thenElRegistroEsExitoso(creado);
    }

    private void givenUsuarioNoExiste(String email) {
        when(repositorioUsuario.buscar(email)).thenReturn(null);
    }

    private void givenUsuarioYaExiste(String email) {
        when(repositorioUsuario.buscar(email)).thenReturn(new Usuario());
    }

    private Usuario whenResgistro(String email) throws Exception {
        return servicioLogin.registrar(email, "67447");
    }

    private void thenElUsuarioNoSeGuarda() {
        verify(repositorioUsuario, never()).guardar(any());
    }

    private void thenElRegistroEsExitoso(Usuario creado) {
        assertThat(creado).isNotNull();
        assertThat(creado.getEmail()).isEqualTo(EMAIL);
        verify(repositorioUsuario, times(1)).guardar(any());
    }
}
