package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Suscripcion suscripcion;
    @OneToOne
    private Usuario usuarioQuePaga;
    @OneToOne
    private EstadoFactura estadoFactura;
    private Date fecha;
    private Date fechaVencimiento;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

    public Usuario getUsuarioQuePaga() {
        return usuarioQuePaga;
    }

    public void setUsuarioQuePaga(Usuario usuarioQuePaga) {
        this.usuarioQuePaga = usuarioQuePaga;
    }

    public EstadoFactura getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(EstadoFactura estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
