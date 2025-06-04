
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
        if (reserva.esValido() && !verificarConflicto(reserva.getFinca(), reserva.getFechaValida(), reserva.getHoraInicioValido(), reserva.getHoraFinValido())){
            reservas.add(reserva);
            System.out.println("Reserva registrada exitosamente a nombre de: "+ reserva.getFinca());
            System.out.println("Total a pagar: $" + reserva.calcularTotal());
            return true;
            
        }else {
            System.out.println("No se pudo registrar la reserva (horario no disponible o conflicto).");
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
            if (r.getFinca().equals(finca) && r.getFechaValida().equals(fecha)) {
                boolean solapa = !(horaFin.isBefore(r.getHoraInicioValido()) || horaInicio.isAfter(r.getHoraFinValido()));
                if (solapa) {
                    return true;
                }
            }
        }
        return false;
    }
}

