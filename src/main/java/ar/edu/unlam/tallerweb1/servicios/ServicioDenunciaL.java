package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Denuncia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioDenunciaL {

    List<Denuncia> mostrarHistorialDeDenunciasRealizadasPorUnUsuario(Usuario usuario) throws Exception;
}