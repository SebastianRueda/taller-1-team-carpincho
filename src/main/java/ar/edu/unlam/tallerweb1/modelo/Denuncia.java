package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    @OneToOne
    private Prestacion prestacion;
    @OneToOne
    private Usuario usuarioDenunciante;
    @OneToOne
    private Usuario usuarioDenunciado;
    private String motivo;

    public Prestacion getPrestacion() {
        return prestacion;
    }

    public void setPrestacion(Prestacion prestacion) {
        this.prestacion = prestacion;
    }

    public Usuario getUsuarioDenunciante() {
        return usuarioDenunciante;
    }

    public void setUsuarioDenunciante(Usuario usuarioDenunciante) {
        this.usuarioDenunciante = usuarioDenunciante;
    }

    public Usuario getUsuarioDenunciado() {
        return usuarioDenunciado;
    }

    public void setUsuarioDenunciado(Usuario usuarioDenunciado) {
        this.usuarioDenunciado = usuarioDenunciado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
