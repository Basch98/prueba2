
package mainreservas;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private int id;
    private Finca finca;
    private Cliente cliente;
    private ReservaValida reserva;
    /*private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

     */


    /*public Reserva(int id, Finca finca, Cliente cliete,LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.finca = finca;
        this.cliete = cliete;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
     */

    public Reserva(int id, Finca finca, Cliente cliente, ReservaValida reserva) {
        this.id = id;
        this.finca = finca;
        this.cliente = cliente;
        this.reserva = reserva;
    }

    public double calcularTotal(){
        long horas = Duration.between(reserva.getHoraInicio(), reserva.getHoraFin()).toHours();
        return finca.calcularPrecio((int) horas);
    }
    /*
    public boolean esValido(){
        return finca.esDisponible(fecha, horaInicio, horaFin);
    }*/

    public boolean esValido(){
        return finca.esDisponible(reserva.getFechaReserva(), reserva.getHoraInicio(),reserva.getHoraFin());
    }

    public Finca getFinca(){
        return finca;
    }

    public LocalDate getFechaValida() {
        return reserva.getFechaReserva();
    }
    public LocalTime getHoraInicioValido() {
        return reserva.getHoraInicio();
    }

    public LocalTime getHoraFinValido() {
        return reserva.getHoraFin();
    }

    public Cliente getCliente() {
        return cliente;
    }

    /*public LocalDate getFecha(){
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }*/
    
    
}
