package ar.edu.unlam.tallerweb1.modelo;

public enum PrestacionEstado {
    ACTIVO("activo", 1),
    FINALIZADO("finalizado", 2),
    CANCELADA("cancelado", 3);

    private String estado;
    private Integer prioridad;

    PrestacionEstado(String estado, Integer prioridad) {
        this.estado = estado;
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public static Integer getPrioridadPorEstado(String estado) {
        if (estado.equals(ACTIVO.estado)) {
            return ACTIVO.prioridad;
        } else if (estado.equals(FINALIZADO.estado)) {
            return FINALIZADO.prioridad;
        } else if (estado.equals(CANCELADA.estado)) {
            return CANCELADA.prioridad;
        } else {
            return -1;
        }
    }
}
