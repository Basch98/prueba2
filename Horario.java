
package mainreservas;

import java.time.LocalTime;


public class Horario {
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    
    public Horario(String diaSemana, LocalTime horaInicio, LocalTime horaFin){
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
  
    }


    public boolean cubre(LocalTime inicio, LocalTime fin){
        return (inicio.equals(horaInicio) || inicio.isAfter(horaInicio)) && 
                (fin.equals(horaFin) || fin.isBefore(horaFin));
        
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }
    
    
    
}
