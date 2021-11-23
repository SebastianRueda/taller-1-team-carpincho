package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Prestacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	@ManyToOne
	private Especialidad especialidad;
	@OneToOne
	private Usuario usuarioAsistente;
	@OneToOne
	private Usuario usuarioSolicitante;
	private String estado;

	private String numerofactura;
	private Integer calificacionDadaPorElCliente= null;
	private Integer calificacionDadaPorUsuarioAsistente= null;

	public Integer getCalificacionDadaPorUsuarioAsistente() {
		return calificacionDadaPorUsuarioAsistente;
	}

	public void setCalificacionDadaPorUsuarioAsistente(Integer calificacionDadaPorUsuarioAsistente) {
		this.calificacionDadaPorUsuarioAsistente = calificacionDadaPorUsuarioAsistente;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	public Usuario getUsuarioAsistente() {
		return usuarioAsistente;
	}
	public void setUsuarioAsistente(Usuario usuarioAsistente) {
		this.usuarioAsistente = usuarioAsistente;
	}
	public Usuario getUsuarioSolicitante() {
		return usuarioSolicitante;
	}
	public void setUsuarioSolicitante(Usuario usuarioSolicitante) {
		this.usuarioSolicitante = usuarioSolicitante;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public String getNumerofactura() {
		return numerofactura;
	}

	public void setNumerofactura(String numerofactura) {
		this.numerofactura = numerofactura;
	}

	public Integer getCalificacionDadaPorElCliente() {
		return calificacionDadaPorElCliente;
	}

	public void setCalificacionDadaPorElCliente(Integer calificacionDadaPorElCliente) {
		this.calificacionDadaPorElCliente = calificacionDadaPorElCliente;
	}
}
