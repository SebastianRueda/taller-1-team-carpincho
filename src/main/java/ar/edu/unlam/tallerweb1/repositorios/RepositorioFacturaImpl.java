package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.EstadoFactura;
import ar.edu.unlam.tallerweb1.modelo.Factura;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioFactura")
public class RepositorioFacturaImpl implements RepositorioFactura{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioFacturaImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void generarFactura(Factura factura) {
        sessionFactory.getCurrentSession().save(factura);

    }

    @Override
    public EstadoFactura buscarEstadoFacturaPorId(Long idEstadoFactura) {
        return (EstadoFactura) sessionFactory.getCurrentSession().createCriteria(EstadoFactura.class)
                .add(Restrictions.eq("id", idEstadoFactura)).uniqueResult();
    }

    @Override
    public List<Factura> buscarUltimaFacturaPorUsuario(Usuario usuario) {

       return  (List<Factura>) sessionFactory.getCurrentSession().createCriteria(Factura.class)
                .add(Restrictions.eq("usuarioQuePaga.id", usuario.getId()))
                .addOrder(Order.desc("fecha")).list();



    }


    @Override
    public Factura buscarFacturaPorId(Long id) {
        return (Factura) sessionFactory.getCurrentSession().createCriteria(Factura.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }
}
