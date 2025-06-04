package mainreservas;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaValida {
    private LocalDate fechaReserva;
    private LocalTime horaInicio;
    private LocalTime horaFin;


    public ReservaValida(LocalDate fechaReserva, LocalTime horaInicio, LocalTime horaFin) {
        this.fechaReserva = fechaReserva;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }
}

