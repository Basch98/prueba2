
package mainreservas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Finca {
    private int id;
    private String nombre;
    private String ubicacion;
    private double tarifaHora;
    private List<Horario> horariosDisponibles; 
   
    public Finca(int id, String nombre, String ubicacion, double tarifaHora){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tarifaHora = tarifaHora;
        this.horariosDisponibles = new ArrayList<>();
                
    }
    public void agregarHorarios(Horario horario){
        horariosDisponibles.add(horario);
    }
    
    public List<Horario> gethorariosDisponibles(){
        return horariosDisponibles;
    }
    
    public boolean esDisponible(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin){
        String dia = fecha.getDayOfWeek().toString();
        for (Horario h : horariosDisponibles){
            if (h.getDiaSemana().equalsIgnoreCase(dia) && h.cubre(horaInicio, horaFin)){
                return true;
            }
            
        }
        return false;
    }
    
    public double calcularPrecio(int horas){
        return getTarifaHora() * horas;
    }
    
    public double getTarifaHora(){
        return tarifaHora;
    }
    
    public String getNombre(){
        return nombre;
    } 


}
