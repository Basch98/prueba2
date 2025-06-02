
package mainreservas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class SistemaReservas {
    private List<Reserva> reservas;

    public SistemaReservas() {
        this.reservas = new ArrayList<>();
    }
    
    public boolean registrarReserva(Reserva reserva){
        if (reserva.esValido() && !verificarConflicto(reserva.getFinca(), reserva.getFecha(), reserva.getHoraInicio(), reserva.getHoraFin())){
            reservas.add(reserva);
            return true;
            
        }
        return false;
        
    }
    
    public List<Reserva> obtenerReservasPorFinca(Finca finca){
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas){
            if (r.getFinca().equals(finca)){
                resultado.add(r);
            }
        }
        return resultado;
    }
    
    public boolean verificarConflicto(Finca finca, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin){
        for (Reserva r : reservas) {
            if (r.getFinca().equals(finca) && r.getFecha().equals(fecha)) {
                boolean solapa = !(horaFin.isBefore(r.getHoraInicio()) || horaInicio.isAfter(r.getHoraFin()));
                if (solapa) {
                    return true;
                }
            }
        }
        return false;
    }
}

