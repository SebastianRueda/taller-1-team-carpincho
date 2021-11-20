package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Factura;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public Factura buscarFacturaPorId(Long id) {
        return (Factura) sessionFactory.getCurrentSession().createCriteria(Factura.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }
}
