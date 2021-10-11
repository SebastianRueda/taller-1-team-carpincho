package ar.edu.unlam.tallerweb1.utils;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

/**
 * clase creada con el proposito de guardar los datos del usuario de manera local
 * TODO: después del próximo spring evaluar buscar una solución mejor - 10/10
 */
public class UsuarioCache {
    private static Usuario usuario = null;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        UsuarioCache.usuario = usuario;
    }
}
