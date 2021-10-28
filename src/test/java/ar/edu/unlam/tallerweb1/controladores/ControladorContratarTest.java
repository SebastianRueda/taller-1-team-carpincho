package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Prestacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorContratarTest {
    ServicioPrestacion servicioPrestacion = Mockito.mock(ServicioPrestacion.class);
    ServicioUsuario servicioUsuario = Mockito.mock(ServicioUsuario.class);
    ControladorContratar controladorContratar = new ControladorContratar(servicioPrestacion, servicioUsuario);
    private Long idPrestacion=1l;



    @Test
    public void crearPrestacionTest() {
        final var asistente = givenElAsistenteExiste();
        final var mov = whenSeCreaUnaPrestacionCon(asistente);
        thenLaPrestacionSeCreoExitosamanteYMeRedireccionaAlDetalle(mov);
    }

    @Test
    public void noSePudoCrearLaPrestacionPorQueNoSeEncontroElAsistente() {
        final var asistente = givenNoSeEncontroAlAsistente();
        final var mov = whenSeCreaUnaPrestacionCon(asistente);
        thenNoSePudoCrearLaPrestacion(mov);
    }

   /* @Test
    public  void finalizarPrestacion(){
        givenPrestacionActiva(idPrestacion);
        ModelAndView mav =whenFinalizaPrestacion(idPrestacion);
        thenLaPrestacionFinalizoCorrectacmente(mav);
    }*/

   /* @Test
    public void finalizarPrestacionDaError() throws Exception {
        givenPrestacionFinalizada();
       ModelAndView mav = whenFinalizaUnaPrestacionQueYaEstaFinalizada(2l);
        thenPrestacionDaErrorAlFinalizar(mav);
    }*/

    /*private ModelAndView whenFinalizaUnaPrestacionQueYaEstaFinalizada(Long idPRestacion1) {
       return controladorContratar.finalizarPrestacion(idPRestacion1);
    }*/

    private void thenPrestacionDaErrorAlFinalizar(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("perfilUsuario");
        assertThat(mav.getModel().get("msgFinalizacionDeContratacionErronea")).isEqualTo("Error al finalizar la Prestacion ");

    }

    private void givenPrestacionFinalizada() throws Exception {
        Prestacion prestacion = new Prestacion();
        prestacion.setId(2l);
        prestacion.setEstado("finalizado");
       when(servicioPrestacion.prestacionFindById(2l)).thenReturn(prestacion);
        doThrow(Exception.class).when(servicioPrestacion).finalizarPrestacion(prestacion);

    }

    private void thenLaPrestacionFinalizoCorrectacmente(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("detalle-contratacion");
        assertThat(mav.getModel().get("msgFinalizacionDeContratacion")).isEqualTo("Prestacion finalizada correctamente");
    }

   /* private ModelAndView whenFinalizaPrestacion(Long idPrestacion){
      return   controladorContratar.finalizarPrestacion(idPrestacion);
    }*/
    private void givenPrestacionActiva(Long idPrestacion) {
    }


    private Usuario givenElAsistenteExiste() {
        var asistente = new Usuario();

        Mockito.when(servicioUsuario.usuarioFindById(Matchers.any())).thenReturn(asistente);

        return asistente;
    }

    private ModelAndView whenSeCreaUnaPrestacionCon(Usuario asistente) {
        return controladorContratar.contratarPrestacion(asistente.getId());
    }

    private void thenLaPrestacionSeCreoExitosamanteYMeRedireccionaAlDetalle(ModelAndView detalle) {
        Assert.assertEquals(detalle.getViewName(), "detalle-contratacion");
        Assert.assertNotNull(detalle.getModel().get("prestacion"));
    }

    private Usuario givenNoSeEncontroAlAsistente() {
        final var asistente = new Usuario();

        Mockito.when(servicioUsuario.usuarioFindById(Matchers.any())).thenReturn(null);

        return asistente;
    }

    private void thenNoSePudoCrearLaPrestacion(ModelAndView view) {
        Assert.assertEquals(view.getViewName(), "detalle-contratacion");
        Assert.assertEquals(view.getModel().get("error"), "No se pudo encontrar los datos del asistente para completar la operación");
    }
}