/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.models.storage;

import airport.models.Flight;
import java.util.ArrayList;

/**
 *
 * @author vangu
 */
public class FlightStorage extends Storage{
    private static FlightStorage instance;
    private ArrayList<Flight> flights;

    private FlightStorage() {
        this.flights = new ArrayList<>();
    }

    public static FlightStorage getInstance() {
        if (instance == null) {
            instance = new FlightStorage();
        }
        return instance;
    }

    @Override
    public void addItem(Object object) {
        Flight f = (Flight) object;
        if (!flights.contains(f)) {
            flights.add(f);
        }
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public boolean existsById(String id) {
        return flights.stream().anyMatch(f -> f.getId().equalsIgnoreCase(id));
    }
    
}
