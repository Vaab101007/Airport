/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.tables;


import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Passenger;
import core.models.storage.PassengerStorage;
import core.models.storage.FlightStorage;
import core.models.utils.calcPassengers.PassengerCalcs;
import core.models.utils.calcPassengers.PassengerFormatters;
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
                model.setRowCount(0);
                return new Response(Status.NO_CONTENT, "No hay pasajeros registrados", null);
            }

            passengers.sort(Comparator.comparingLong(Passenger::getId));
            model.setRowCount(0); 

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

        if (selectedItem == null || selectedItem.isBlank() || selectedItem.equals("Select")) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            return;
        }

        String selectedPassengerId = selectedItem.split(" ")[0];

        if (!selectedPassengerId.matches("\\d+")) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            return;
        }

        long passengerId = Long.parseLong(selectedPassengerId);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); 

        List<Flight> flights = FlightStorage.getInstance().findByPassengerId(passengerId);

        for (Flight f : flights) {
            model.addRow(new Object[]{
                f.getId(),
                f.getDepartureDate(),
                f.calculateArrivalDate()
            });
        }
    }
    
    
}
