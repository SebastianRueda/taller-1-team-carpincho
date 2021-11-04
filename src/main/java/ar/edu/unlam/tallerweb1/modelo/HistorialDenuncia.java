package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class HistorialDenuncia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String comentario;
	@OneToOne
	private Usuario usuarioSolicitante;
	
	
	public Usuario getUsuarioSolicitante() {
		return usuarioSolicitante;
	}
	public void setUsuarioSolicitante(Usuario usuarioSolicitante) {
		this.usuarioSolicitante = usuarioSolicitante;
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
	public void setComentario(String descripcion) {
		this.comentario = descripcion;
	}

	
}
