/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.utils;

import airport.models.Flight;
import airport.models.Location;
import airport.models.Passenger;
import airport.models.Plane;
import airport.models.storage.AirportStorage;
import airport.models.storage.FlightStorage;
import airport.models.storage.PassengerStorage;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author isisp
 */
public class ComboDataFiller {
    public static void LoadPassenger(JComboBox<String> combo) {        
        for (Passenger p : AirportStorage.getInstance().getPassengerStorage().getAllPassengers()) {
            combo.addItem(String.valueOf(p.getId()));
        }
    }
    
    public static void LoadPlanes(JComboBox<String> combo) {
    for (Plane p : AirportStorage.getInstance().getPlaneStorage().getAllPlanes()) {
        combo.addItem(p.getId());
    }
}
    public static void LoadLocations(JComboBox<String> combo) {
        for (Location l : AirportStorage.getInstance().getLocationStorage().getAllLocations()) {
            combo.addItem(l.getAirportId());
        }
    }
    
    public static void loadFlights(JComboBox<String> combo) {
    combo.removeAllItems();
    for (Flight f : FlightStorage.getInstance().getAllFlightsOrdered()) {
        combo.addItem(f.getId());
    }
}

}
