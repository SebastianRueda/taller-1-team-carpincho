package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPrestacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServicioPrestacion")
public class ServicioPrestacionImpl implements ServicioPrestacion{

    private RepositorioPrestacion prestacionDao;

    @Autowired
    public ServicioPrestacionImpl(RepositorioPrestacion prestacionDao) {
        this.prestacionDao = prestacionDao;
    }

    @Override
    public void save(Prestacion nuevaPrestacion) {
        prestacionDao.save(nuevaPrestacion);
    }

    @Override
    public void delete(Prestacion prestacionExistente) {
        prestacionDao.delete(prestacionExistente);
    }

    @Override
    public void update(Prestacion prestacionExistente) {
        prestacionDao.update(prestacionExistente);
    }

    @Override
    public List<Prestacion> getAll() {
        List<Prestacion>prestaciones = prestacionDao.getAll();
        return prestaciones;
    }

    @Override
    public Prestacion prestacionFindById(Long id) {
      var prestacion = prestacionDao.prestacionFindById(id);
      return prestacion;
    }

    @Override
    public List<Prestacion> prestacionFindByEspecialidad(String especialidad) {
        var prestacion = prestacionDao.prestacionFindByEspecialidad(especialidad);
        return prestacion;
    }
}
