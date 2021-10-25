package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPrestacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioPrestacion")
@Transactional
public class ServicioPrestacionImpl implements ServicioPrestacion {

    private RepositorioPrestacion prestacionDao;
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioPrestacionImpl(RepositorioPrestacion prestacionDao, RepositorioUsuario repositorioUsuario) {
        this.prestacionDao = prestacionDao;
        this.repositorioUsuario = repositorioUsuario;
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
      return prestacionDao.prestacionFindById(id);
    }

    @Override
    public List<Prestacion> prestacionFindByEspecialidad(Especialidad especialidad) {
        return prestacionDao.prestacionFindByEspecialidad(especialidad);
    }

    @Override
    public void finalizarPrestacion(Prestacion prestacion) throws Exception {

        if(prestacion.getEstado()=="finalizado") {
             throw  new Exception();
        }
            prestacion.setEstado("finalizado");
            prestacionDao.update(prestacion);

    }

    @Override
    public Prestacion buscarPrestacionPorId(Long id) {
        return prestacionDao.buscarPrestacionPorId(id);
    }

    @Override
    public List<Prestacion> listarPrestacionesContratadasPorCliente(Long id) {
        return prestacionDao.listarPrestacionesContratadasPorCliente(id);
    }

    @Override
    public void ClienteCalificaPrestacion(Long idPrestacion, Integer calificacion) throws Exception {
        if (idPrestacion ==null || calificacion <1 || calificacion >5) {
            throw  new Exception();
        }

             Prestacion prestacion =   prestacionDao.buscarPrestacionFinalizadaSinCalificar(idPrestacion);
             prestacion.setCalificacionDadaPorElCliente(calificacion);
                prestacionDao.update(prestacion);


        }


}
