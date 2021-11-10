package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorito favorito = (Favorito) o;
        return Objects.equals(id, favorito.id) && Objects.equals(cliente, favorito.cliente) && Objects.equals(asistente, favorito.asistente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, asistente);
    }
}
