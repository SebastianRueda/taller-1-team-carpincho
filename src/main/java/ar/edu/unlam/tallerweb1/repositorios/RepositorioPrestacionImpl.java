package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Repository("repositorioPrestacion")
public class RepositorioPrestacionImpl implements RepositorioPrestacion{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPrestacionImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Prestacion nuevaPrestacion) { sessionFactory.getCurrentSession().save(nuevaPrestacion); }

    @Override
    public void delete(Prestacion prestacionExistente) { sessionFactory.getCurrentSession().delete(prestacionExistente);
    }

    @Override
    public void update(Prestacion prestacionExistente) {sessionFactory.getCurrentSession().update(prestacionExistente);
    }

    @Override
    public List<Prestacion> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Prestacion.class).list();
    }

    @Override
    public Prestacion prestacionFindById(Long id) {
        return (Prestacion) sessionFactory.getCurrentSession().createCriteria(Prestacion.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }


    @Override
    public List<Prestacion> prestacionFindByEspecialidad(Especialidad especialidad) {
        return (List<Prestacion>) sessionFactory.getCurrentSession().createCriteria(Prestacion.class)
                .add(Restrictions.eq("prestacion", especialidad))
                .uniqueResult();
    }

    @Override
    public Prestacion buscarPrestacionPorId(Long id) {
        final Session session = sessionFactory.getCurrentSession();

        return (Prestacion) session.createCriteria(Prestacion.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<Prestacion> listarPrestacionesContratadasPorCliente(Long id) {
        final Session session = sessionFactory.getCurrentSession();

        var prestaciones = session.createCriteria(Prestacion.class)
                .add(Restrictions.eq("usuarioSolicitante.id", id))
                .list();

        prestaciones.sort((o1, o2) -> {
            var p1 = (Prestacion) o1;
            var p2 = (Prestacion) o2;
            return  p1.getEstado().compareTo(p2.getEstado());
        });

        return prestaciones;
    }

    @Override
    public Prestacion buscarPrestacionFinalizadaSinCalificar(Long idPrestacion) {

     return (Prestacion) sessionFactory.getCurrentSession().createCriteria(Prestacion.class)
             .add(Restrictions.eq("id",idPrestacion))
             .add(Restrictions.like("estado", "finalizado"))
             .add(Restrictions.isNull("calificacionDadaPorElCliente"))
             .uniqueResult();
    }

    @Override
    public List<Prestacion> buscarPrestacionesCalificadasPorUsuario(Long idUsuario) {
        return  (List<Prestacion>) sessionFactory.getCurrentSession().createCriteria(Prestacion.class)
                .add(Restrictions.eq("usuarioSolicitante.id",idUsuario))
                .list();
    }

}
