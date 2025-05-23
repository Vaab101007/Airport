/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers.tables;

import airport.controllers.utils.Response;
import airport.controllers.utils.Status;
import airport.models.Flight;
import airport.models.Passenger;
import airport.models.storage.PassengerStorage;
import airport.models.utils.PassengerCalcs;
import airport.models.utils.PassengerFormatters;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vangu
 */
public class PassengerTableController {
     public static Response updatePassengerTable(DefaultTableModel model) {
        try {
            PassengerStorage storage = PassengerStorage.getInstance();
            ArrayList<Passenger> passengers = storage.getPassengers();

            if (passengers == null || passengers.isEmpty()) {
                model.setRowCount(0); // limpia la tabla
                return new Response(Status.NO_CONTENT, "No hay pasajeros registrados", null);
            }

            passengers.sort(Comparator.comparingLong(Passenger::getId));
            model.setRowCount(0); // limpia la tabla antes de llenarla

            for (Passenger p : passengers) {
                Object[] row = {
                    p.getId(),
                    PassengerFormatters.getFullname(p),
                    p.getBirthDate(),
                    PassengerCalcs.calculateAge(p),
                    PassengerFormatters.generateFullPhone(p),
                    p.getCountry(),
                    PassengerCalcs.getNumFlights(p)
                };
                model.addRow(row);
            }

            return new Response(Status.OK, "Pasajeros cargados correctamente", null);

        } catch (Exception e) {
            return new Response(Status.INTERNAL_SERVER_ERROR, "Error inesperado al cargar pasajeros", null);
        }
    }
     
     
     // 📌 Obtener vuelos de un pasajero (ordenados por fecha de salida)
public Response<ArrayList<Flight>> getFlightsOfPassenger(long passengerId) {
    Passenger p = storage.findById(passengerId);
    if (p == null) {
        return new Response<>(Status.NOT_FOUND, "Pasajero no encontrado", null);
    }

    ArrayList<Flight> allFlights = airport.models.storage.FlightStorage.getInstance().getAllFlightsOrdered();
    ArrayList<Flight> result = new ArrayList<>();

    for (Flight f : allFlights) {
        for (Passenger fp : f.getPassengers()) {
            if (fp.getId() == passengerId) {
                result.add(f.clone());
                break;
            }
        }
    }

    if (result.isEmpty()) {
        return new Response<>(Status.NO_CONTENT, "El pasajero no tiene vuelos asignados", null);
    }

    return new Response<>(Status.OK, "Vuelos del pasajero obtenidos correctamente", result);
}

}
