package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Denuncia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDenuncia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDenunciaL;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class ServicioDenunciaTest {

    private RepositorioDenunciaL repositorioDenuncia = mock(RepositorioDenunciaL.class);
    private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
    private ServicioDenunciaL servicioDenuncia= new ServicioDenunciaLImpl(repositorioDenuncia);

    @Test
    public  void traerHistorialDeDenunciasQueRealiazoUnUsuario() throws Exception {
        Usuario usuario = givenUsuarioQueRealizoDenuncias();
        List<Denuncia> denunciasRealizadasPorElUsuario= whenTraeHistorialDeDenunciasQueRealiazoUnUsuario(usuario);
        thenVerficarQueLaListaDeDenunciasRealizadasPorElUsuarioNoVieneVacias(denunciasRealizadasPorElUsuario);

    }
    @Test(expected = Exception.class)
    public  void traerHistorialDeDenunciasQueRealizoUnUsuarioQueNoExiste() throws Exception {
        Usuario usuario =givenUnUsuarioQueNoExiste();
        whenTraeHistorialDeDenunciasQueRealiazoUnUsuario(usuario);


    }

    private Usuario givenUnUsuarioQueNoExiste() throws Exception {
        Usuario usuario = new Usuario();
        return usuario;
    }

    private void thenVerficarQueLaListaDeDenunciasRealizadasPorElUsuarioNoVieneVacias(List<Denuncia> denunciasRealizadasPorElUsuario) {

        assertThat(denunciasRealizadasPorElUsuario.size()).isEqualTo(5);
    }

    private List<Denuncia> whenTraeHistorialDeDenunciasQueRealiazoUnUsuario(Usuario usuario) throws Exception {
        return   servicioDenuncia.mostrarHistorialDeDenunciasRealizadasPorUnUsuario(usuario);

    }

    private Usuario givenUsuarioQueRealizoDenuncias() throws Exception {
        List<Denuncia> ListaDedenuncias= new ArrayList<>() ;
        Usuario usuario= new Usuario();
        usuario.setId(1l);
        usuario.setApellido("hola");
        for (Integer i=0; i<5; i++){

            Denuncia denuncia = new Denuncia();
            denuncia.setUsuarioDenunciante(usuario);
            ListaDedenuncias.add(denuncia);
        }
        when(servicioDenuncia.mostrarHistorialDeDenunciasRealizadasPorUnUsuario(usuario)).thenReturn(ListaDedenuncias);
        return  usuario;
    }


}