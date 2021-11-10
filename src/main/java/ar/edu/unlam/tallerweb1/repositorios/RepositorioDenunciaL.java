package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Denuncia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioDenunciaL {

    List<Denuncia> mostrarHistorialDeDenunciasRealizadasPorUnUsuario(Usuario usuario);

    void guardarDenuncia(Denuncia denuncia);
}
