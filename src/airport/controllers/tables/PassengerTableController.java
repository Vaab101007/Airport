/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers.tables;

import airport.controllers.PassengerController;
import airport.controllers.utils.Response;
import airport.controllers.utils.Status;
import airport.models.Flight;
import airport.models.Passenger;
import airport.models.storage.PassengerStorage;
import airport.models.storage.FlightStorage;
import airport.models.storage.Storage;
import airport.models.utils.PassengerCalcs;
import airport.models.utils.PassengerFormatters;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
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
     
     
    public void viewUserFlight(JTable table, JComboBox<String> comboBox) {
   String selectedItem = (String) comboBox.getSelectedItem();
    if (selectedItem == null || selectedItem.isEmpty()) return;

    String selectedPassengerId = selectedItem.split(" ")[0]; // o solo selectedItem si es solo el ID

    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);  // limpiar filas existentes

    List<Flight> flights = FlightStorage.getInstance().findByPassengerId(Long.parseLong(selectedPassengerId));

    for (Flight f : flights) {
        model.addRow(new Object[]{
            f.getId(),
            f.getDepartureDate(),
            f.calculateArrivalDate()
        });
    }
    }
}
