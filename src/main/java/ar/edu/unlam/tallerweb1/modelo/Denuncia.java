package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;
    @OneToOne
    private Prestacion prestacion;
    @OneToOne
    private Usuario usuarioDenunciante;
    @OneToOne
    private Usuario usuarioDenunciado;
    @OneToOne
    private MotivoDenuncia motivoDenuncia;

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

    public MotivoDenuncia getMotivoDenuncia() {
        return motivoDenuncia;
    }

    public void setMotivoDenuncia(MotivoDenuncia motivoDenuncia) {
        this.motivoDenuncia = motivoDenuncia;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
