package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;


import ar.edu.unlam.tallerweb1.modelo.Denuncia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.MotivoDenuncia;
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
    public List<Denuncia> listarDenunciasPorCliente(Long id) {
        return denunciaDao.listarDenunciasPorCliente(id);
    }

	@Override
	public MotivoDenuncia buscarMotivoPorId(Long id) {
		return denunciaDao.buscarMotivoPorId(id);
	}

	@Override
	public void guardar(Denuncia historialDenuncia) {
		denunciaDao.guardar(historialDenuncia);
	}

	@Override
	public Denuncia buscarDenunciaPorId(Long id) {
		return denunciaDao.buscarDenunciaPorId(id);
	}
}
