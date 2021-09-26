package ar.edu.unlam.tallerweb1.modelo;

public enum PrestacionEstado {
    ACTIVO("activo"),
    FINALIZADO("finalizado");

    private String estado;

    PrestacionEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
