package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Usuario cliente;
    @OneToOne
    private Usuario asistente;

    public Favorito() {

    }

    public Favorito(Usuario cliente, Usuario asistente) {
        this.cliente = cliente;
        this.asistente = asistente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Usuario getAsistente() {
        return asistente;
    }

    public void setAsistente(Usuario asistente) {
        this.asistente = asistente;
    }
}
