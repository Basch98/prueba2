
package mainreservas;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private int id;
    private Finca finca;
    private Cliente cliete;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Reserva(int id, Finca finca, Cliente cliete,LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.finca = finca;
        this.cliete = cliete;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    public double calcularTotal(){
        long horas = Duration.between(horaInicio, horaFin).toHours();
        return finca.calcularPrecio((int) horas);
    }
    
    public boolean esValido(){
        return finca.esDisponible(fecha, horaInicio, horaFin);
    }
    
    public Finca getFinca(){
        return finca;
    }
    
    public LocalDate getFecha(){
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }
    
    
}
