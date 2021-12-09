package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Especialidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	@OneToOne
	private Suscripcion suscripcion;
	
	
	public Especialidad() {
		super();
	}
	public Especialidad(long id, String descripcion) {
		this.id=id;
		this.descripcion=descripcion;
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

	public void setSuscripcion(Suscripcion suscripcion) {
		this.suscripcion = suscripcion;
	}

	public Suscripcion getSuscripcion() {
		return suscripcion;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Especialidad that = (Especialidad) o;
		return Objects.equals(id, that.id) && Objects.equals(descripcion, that.descripcion) && Objects.equals(suscripcion, that.suscripcion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, descripcion, suscripcion);
	}
}
