
package mainreservas;

import java.time.LocalDate;
import java.time.LocalTime;



public class MainReservas {
    public static void main(String[] args) {
        // Crear la finca
        Finca finca = new Finca(1, "Las Dinas", "Tandil", 100.0);
        finca.agregarHorarios(new Horario("SATURDAY", LocalTime.of(8, 0), LocalTime.of(18, 0)));
        finca.agregarHorarios(new Horario("SUNDAY", LocalTime.of(8, 0), LocalTime.of(18, 0)));

        // Crear un cliente
        Cliente cliente = new Cliente(101, "Marcos Bayget", "mb@gmail.com");

        // Crear una reserva válida
        LocalDate fechaReserva = LocalDate.of(2025, 6, 7); // Sábado
        LocalTime horaInicio = LocalTime.of(8, 0);
        LocalTime horaFin = LocalTime.of(14, 0);

        Reserva reserva = new Reserva(1, finca, cliente, fechaReserva, horaInicio, horaFin);

        // Crear el sistema de reservas y registrar la reserva
        SistemaReservas sistema = new SistemaReservas();
        boolean registrada = sistema.registrarReserva(reserva);

        // Mostrar resultados
        if (registrada) {
            System.out.println("Reserva registrada exitosamente.");
            System.out.println("Total a pagar: $" + reserva.calcularTotal());
        } else {
            System.out.println("No se pudo registrar la reserva (horario no disponible o conflicto).");
        }
    }
    
}
