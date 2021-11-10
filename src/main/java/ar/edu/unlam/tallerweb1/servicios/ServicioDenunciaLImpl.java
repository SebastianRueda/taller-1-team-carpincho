package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDenunciaL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Denuncia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDenuncia;


@Service("servicioDenunciaL")
@Transactional
public class ServicioDenunciaLImpl implements ServicioDenunciaL {

    private RepositorioDenunciaL repositorioDenunciaL;

    @Autowired
    public ServicioDenunciaLImpl(RepositorioDenunciaL repositorioDenunciaL) {
        this.repositorioDenunciaL=repositorioDenunciaL;
    }

    @Override
    public List<Denuncia> mostrarHistorialDeDenunciasRealizadasPorUnUsuario(Usuario usuario) throws Exception {
        if(usuario.getId()==null){
            throw  new Exception();
        }
        return repositorioDenunciaL.mostrarHistorialDeDenunciasRealizadasPorUnUsuario(usuario);
    }

}