/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.models.storage;

import airport.models.Flight;
import airport.models.Passenger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author vangu
 */
public class FlightStorage extends Storage {

    private static FlightStorage instance;
    private ArrayList<Flight> flights;

    FlightStorage() {
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
        Flight flight = (Flight) object;
        if (!existsById(flight.getId())) {
            flights.add(flight);
            notifyObservers(); 
        }
    }

    public boolean existsById(String id) {
        for (Flight f : flights) {
            if (f.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Flight findById(String id) {
        for (Flight f : flights) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        return null;
    }

    public boolean delayFlight(String id, int hours, int minutes) {
        Flight f = findById(id);
        if (f == null || (hours == 0 && minutes == 0)) {
            return false;
        }
        f.delay(hours, minutes);
        return true;
    }

    public boolean addPassengerToFlight(String flightId, airport.models.Passenger p) {
        Flight f = findById(flightId);
        if (f == null) {
            return false;
        }
        f.addPassenger(p);
        notifyObservers(); 
        return true;
    }

    public int countFlightsByPlaneId(String planeId) {
        int count = 0;
        for (Flight f : flights) {
            if (f.getPlane() != null && planeId.equals(f.getPlane().getId())) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<Flight> getAllFlightsOrdered() {
        ArrayList<Flight> result = new ArrayList<>(flights); // copia directa, sin clone
        result.sort(Comparator.comparing(Flight::getDepartureDate));
        return result;
    }
    
    public List<Flight> findByPassengerId(long passengerId) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            for (Passenger p : flight.getPassengers()) {
                if (p.getId() == passengerId) {
                    result.add(flight);
                    break;
                }
            }
        }
        return result;
    }


    
    
}
