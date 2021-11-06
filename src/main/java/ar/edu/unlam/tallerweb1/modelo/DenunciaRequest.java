package ar.edu.unlam.tallerweb1.modelo;

public class DenunciaRequest {
    Long clienteId;
    Long asistenteId;
    String comentario;
    Long motivoId;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getAsistenteId() {
        return asistenteId;
    }

    public void setAsistenteId(Long asistenteId) {
        this.asistenteId = asistenteId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getMotivoId() {
        return motivoId;
    }

    public void setMotivoId(Long motivoId) {
        this.motivoId = motivoId;
    }
}
