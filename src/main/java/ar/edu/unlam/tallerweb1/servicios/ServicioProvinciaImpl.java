package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Provincia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioProvincias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("servicioProvincia")
public class ServicioProvinciaImpl implements ServicioProvincia {
    private RepositorioProvincias repositorioProvincias;

    @Autowired
    public ServicioProvinciaImpl(RepositorioProvincias repositorioProvincias) {
        this.repositorioProvincias = repositorioProvincias;
    }

    @Override
    public void guardar(Provincia provincia) {
        repositorioProvincias.guardar(provincia);
    }

    @Override
    public void actualizar(Provincia provincia) {
        repositorioProvincias.actualizar(provincia);
    }

    @Override
    public void eliminar(Provincia provincia) {
        repositorioProvincias.eliminar(provincia);
    }

    @Override
    public List<Provincia> traerProvincia() {
        return repositorioProvincias.traerProvincia();
    }

    @Override
    public void save(Provincia provincia) {
        repositorioProvincias.save(provincia);
    }

    @Override
    public void delete(Provincia provinciaExistente) {
        repositorioProvincias.delete(provinciaExistente);
    }

    @Override
    public void update(Provincia provinciaExistente) {
        repositorioProvincias.update(provinciaExistente);
    }

    @Override
    public Provincia buscarProvinciaPorId(Long id) {
        return repositorioProvincias.buscarProvinciaPorId(id);
    }
}
