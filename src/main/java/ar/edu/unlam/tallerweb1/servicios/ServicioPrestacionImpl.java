package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.PrestacionEstado;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
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
        String estado = prestacion.getEstado();
        if(estado=="finalizado") {
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
        var prestaciones = prestacionDao.listarPrestacionesContratadasPorCliente(id);

        prestaciones.sort((p1, p2) -> {
            var estado1 = PrestacionEstado.getPrioridadPorEstado(p1.getEstado());
            var estado2 = PrestacionEstado.getPrioridadPorEstado(p2.getEstado());

            return estado1.compareTo(estado2);
        });

        return prestaciones;
    }

    @Override
    public void ClienteCalificaPrestacion(Long idPrestacion, Integer calificacion) throws Exception {
        if (idPrestacion ==null || calificacion <1 || calificacion >5) {
            throw  new Exception();
        }

        Prestacion prestacion =   prestacionDao.buscarPrestacionFinalizadaSinCalificar(idPrestacion);
        if(prestacion.getEstado()=="activo"){
            throw  new Exception();
        }
            prestacion.setCalificacionDadaPorElCliente(calificacion);
            prestacionDao.update(prestacion);
        }

    @Override
    public Float obtenerPromedioDeCalificicacionDeUnUsuario(Usuario usuario) throws Exception {

        List<Prestacion>listaDePrestaciones;
        listaDePrestaciones = prestacionDao.buscarPrestacionesCalificadasPorUsuario(usuario.getId());
        Float sumatoria=0f;
        Float promedio;

        if (listaDePrestaciones.isEmpty()){
            throw new Exception();
        }

        for (int i = 0; i< listaDePrestaciones.size(); i++){
            Prestacion prestacion = listaDePrestaciones.get(i);
            sumatoria +=prestacion.getCalificacionDadaPorUsuarioAsistente().floatValue();
        }

        promedio = sumatoria/listaDePrestaciones.size();
        return promedio;
    }

    @Override
    public void cancelarPrestacionActiva(Prestacion prestacion) throws Exception {

        if (prestacion.getEstado() == "finalizado" || prestacion.getEstado() == "cancelado" ){
            throw new Exception();
        }
        prestacion.setEstado("cancelado");
        prestacionDao.update(prestacion);
    }


}
