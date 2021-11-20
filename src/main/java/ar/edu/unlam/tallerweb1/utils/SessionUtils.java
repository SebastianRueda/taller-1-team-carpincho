package ar.edu.unlam.tallerweb1.utils;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
    public static String USER_LOGGED = "usuarioLogueado";

    public static void createSession(HttpServletRequest httpServletRequest, Usuario usuario) {
        var session = httpServletRequest.getSession(true);
        session.setAttribute(USER_LOGGED, usuario);
    }

    public static Usuario getCurrentUserSession(HttpServletRequest httpServletRequest) {
        var session = httpServletRequest.getSession();
        var user = session.getAttribute(USER_LOGGED);

        if (user instanceof Usuario) {
            return (Usuario) user;
        }

        return null;
    }

    public static void closeSession(HttpServletRequest httpServletRequest) {
        var session = httpServletRequest.getSession();
        session.invalidate();
    }
}