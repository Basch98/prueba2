
package mainreservas;

import java.time.LocalDate;
import java.time.LocalTime;



public class MainReservas {
    public static void main(String[] args) {
        // Crear la finca
        Finca finca = new Finca(1, "Las Dinas", "Tandil", 100.0);
        finca.agregarHorarios(new Horario("SATURDAY", LocalTime.of(8, 0), LocalTime.of(18, 0)));
        finca.agregarHorarios(new Horario("SUNDAY", LocalTime.of(8, 0), LocalTime.of(18, 0)));
        finca.agregarHorarios(new Horario("MONDAY", LocalTime.of(8, 0), LocalTime.of(18, 0)));


        // Crear un cliente
        Cliente cliente1 = new Cliente(101, "Marcos Bayget", "mb@gmail.com");
        Cliente cliente2 = new Cliente(102,"Juan Perez","JP@mail.com" );

        // Crear una reserva válida
        /*
        LocalDate fechaReserva = LocalDate.of(2025, 6, 7); // Sábado
        LocalTime horaInicio = LocalTime.of(8, 0);
        LocalTime horaFin = LocalTime.of(14, 0);*/
        ReservaValida reservaV1 = new ReservaValida(LocalDate.of(2025, 6, 7), LocalTime.of(8, 0), LocalTime.of(14, 0));
        ReservaValida reservaV2 = new ReservaValida(LocalDate.of(2025, 6, 7), LocalTime.of(8, 0), LocalTime.of(18, 0));
        //Reserva reserva = new Reserva(1, finca, cliente1, fechaReserva, horaInicio, horaFin);

        Reserva reserva = new Reserva(1, finca, cliente1, reservaV1);
        Reserva reserva2 = new Reserva(2, finca, cliente2, reservaV2);

        // Crear el sistema de reservas y registrar la reserva
        SistemaReservas sistema = new SistemaReservas();
        sistema.registrarReserva(reserva);
        System.out.println("---------------------");
        sistema.registrarReserva(reserva2);

        // Mostrar resultados
        //if (sistema.registrarReserva(reserva)) {
            //System.out.println("Reserva registrada exitosamente.");
            //System.out.println("Total a pagar: $" + reserva.calcularTotal());
        //} else {
           // System.out.println("No se pudo registrar la reserva (horario no disponible o conflicto).");
        //}
    }
    
}
