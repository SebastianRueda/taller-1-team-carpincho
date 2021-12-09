package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Provincia;

import java.util.List;

public interface ServicioProvincia {
    void guardar(Provincia provincia);
    void actualizar(Provincia provincia);
    void eliminar(Provincia provincia);
    List<Provincia> traerProvincia();
    void save(Provincia provincia);
    void delete(Provincia provinciaExistente);
    void update(Provincia provinciaExistente);

    Provincia buscarProvinciaPorId(Long id);
}
