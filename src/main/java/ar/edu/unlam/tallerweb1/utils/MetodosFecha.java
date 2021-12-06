package ar.edu.unlam.tallerweb1.utils;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MetodosFecha {

    public Date obtenerFechaActual(){

        Calendar fechaActual1 =Calendar.getInstance(TimeZone.getTimeZone("GMT-3:00"));
        Date FechaActual = fechaActual1.getTime();
        return FechaActual;
    }

    public Long obtenerDiasRestantesEntreDosFechas(){
        Date fechaActual = this.obtenerFechaActual();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, 30);  // numero de días a añadir, o restar en caso de días<0

        Date segundaFecha = calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

        long milisec = segundaFecha.getTime() - fechaActual.getTime();
        long days = milisec/1000/60/60/24;

        return days;
    }



}
