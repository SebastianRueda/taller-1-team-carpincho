package ar.edu.unlam.tallerweb1.controladores;

public class DatosCalificacion {
    private Long prestacionId;
    private Integer calificacion;

    public Long getPrestacionId() {
        return prestacionId;
    }

    public void setPrestacionId(Long prestacionId) {
        this.prestacionId = prestacionId;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }
}
