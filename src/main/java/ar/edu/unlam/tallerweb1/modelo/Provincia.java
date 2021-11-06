package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;

	public Provincia(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Provincia() {

	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Provincia provincia = (Provincia) o;
		return Objects.equals(id, provincia.id) && Objects.equals(nombre, provincia.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}
}
