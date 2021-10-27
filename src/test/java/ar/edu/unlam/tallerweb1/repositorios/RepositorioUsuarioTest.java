package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;

import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioUsuarioTest extends SpringTest {


    private final Usuario USUARIO = usuario(11L, "prueba@gmail.com", "123123");
    private final Usuario USUARIO2 = usuario2(12L, "prueba2@gmail.com", "456456");


    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public RepositorioUsuarioTest() {
    }

    @Test
    @Transactional
    @Rollback
    public void poderGuardarUsuario() {
        givenUsuarioValido();
        whenGuardoUsuario(USUARIO);
        thenLoPuedoBuscarPorId(USUARIO.getId());
    }

    private void givenUsuarioValido() {
    }

    private void whenGuardoUsuario(Usuario usuario) {
        repositorioUsuario.guardar(usuario);
    }

    private void thenLoPuedoBuscarPorId(Long id) {
        assertThat(repositorioUsuario.usuarioFindById(id)).isEqualTo(USUARIO);
    }


    @Test
    @Transactional
    @Rollback
    public void buscarUsuarioQUeNoExisteNoDevuelveUnUsuario() {
        givenUsuarioValido();
        whenNoGuardoUsuario();
        thenNoEncuentraUsuario(334L);
    }

    private void whenNoGuardoUsuario() {
    }

    private void thenNoEncuentraUsuario(Long id) {
        assertThat(repositorioUsuario.usuarioFindById(id)).isNull();
    }



    @Test
    @Transactional
    @Rollback
    public void queSePuedaBuscarUsuarioPorMail(){
        givenUsuarioValido();
        whenGuardoUsuario(USUARIO);
        thenEncuentroUsuario("prueba@gmail.com");
    }

    private void thenEncuentroUsuario(String email) {
        assertThat(repositorioUsuario.buscarUsuarioPorMail(email)).isEqualTo(USUARIO);
    }


    @Test
    @Transactional
    @Rollback
    public void queSePuedaBorrarUnUsuario() {
        givenUsuariosGuardados(USUARIO, USUARIO2);
        whenBorroUnUsuario(USUARIO);
        thenNoExiste(11L);
    }

    private void givenUsuariosGuardados(Usuario usuario,Usuario usuario2) {
        repositorioUsuario.guardar(usuario);
        repositorioUsuario.guardar(usuario2);
    }

    private void whenBorroUnUsuario(Usuario usuario) {
        repositorioUsuario.delete(usuario);
    }

    private void thenNoExiste(Long id) {

        assertThat(repositorioUsuario.usuarioFindById(id)).isNull();
    }



    @Test
    @Transactional
    @Rollback
    public void queSePuedaActualizarUsuario() {
        givenUsuarioGuardado();
        whenActualizoUsuario("sasa@gmail.com");
        thenVeoUsuarioActualizado(USUARIO.getId());
    }

    private void givenUsuarioGuardado() {

        repositorioUsuario.guardar(USUARIO);
    }

    private void whenActualizoUsuario(String s) {
        USUARIO.setEmail(s);
        repositorioUsuario.modificar(USUARIO);
    }

    private void thenVeoUsuarioActualizado(Long id) {
        assertThat(repositorioUsuario.usuarioFindById(id).getEmail()).isEqualTo("sasa@gmail.com");
    }


    @Test
    @Transactional
    @Rollback
    public void queAgregueSuscripcion() {
        Usuario usuario = givenUsuario();

        whenGuardoUsuarioParaGenerarSuscripcion(usuario);
        thenVeoQueElUsuarioPoseeBilletera(usuario);
    }

    private void whenGuardoUsuarioParaGenerarSuscripcion(Usuario usuario) {
        usuario.setSuscripcion(new Suscripcion());
        session().save(usuario);
    }

    private void thenVeoQueElUsuarioPoseeBilletera(Usuario usuario) {
        assertThat(usuario.getSuscripcion()).isNotNull();
    }


    private Usuario givenUsuario() {
        return USUARIO;
    }



    private Usuario usuario(long id, String email, String clave) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setEmail(email);
        usuario.setPassword(clave);
        return usuario;
    }

    private Usuario usuario2(long id, String email, String clave) {
        Usuario usuario2 = new Usuario();
        usuario2.setId(id);
        usuario2.setEmail(email);
        usuario2.setPassword(clave);
        return usuario2;
    }



}
