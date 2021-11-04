package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.HistorialDenuncia;
import ar.edu.unlam.tallerweb1.modelo.MotivoDenuncia;
import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDenuncia;


@Service("servicioDenuncia")
@Transactional
public class ServicioDenunciaImp implements ServicioDenuncia {
	
	private RepositorioDenuncia denunciaDao;
	
	@Autowired
	public ServicioDenunciaImp(RepositorioDenuncia denunciaDao) {
		this.denunciaDao=denunciaDao;
	}

	
	@Override
	public List<MotivoDenuncia> traerDenuncia() {
		List <MotivoDenuncia> denunciasDescripcion= denunciaDao.traerDenuncia();
		return denunciasDescripcion ;
	}
	
	@Override
    public List<MotivoDenuncia> listarDenunciasPorCliente(Long id) {
        return denunciaDao.listarDenunciasPorCliente(id);
    }
}
