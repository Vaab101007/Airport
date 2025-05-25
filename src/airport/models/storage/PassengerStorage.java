/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.models.storage;

import airport.models.Passenger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author vangu
 */
public class PassengerStorage extends Storage {
    private static PassengerStorage instance;
    private ArrayList<Passenger> passengers;

    PassengerStorage() {
        this.passengers = new ArrayList<>();
    }

    public static PassengerStorage getInstance() {
        if (instance == null) {
            instance = new PassengerStorage();
        }
        return instance;
    }

    @Override
    public void addItem(Object object) {
        Passenger p = (Passenger) object;
        if (!passengers.contains(p)) {
            passengers.add(p);
            notifyObservers(); 
        }
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public boolean existsById(long id) {
        return passengers.stream().anyMatch(p -> p.getId() == id);
    }
    
    public Passenger findById(long id) {
    for (Passenger p : passengers) {
        if (p.getId() == id) {
            return p;
        }
   }
    return null;
    }
        public List<Passenger> getAllPassengers() {
        List<Passenger> sortedList = new ArrayList<>();

        // Clonar todos los pasajeros
        for (Passenger p : passengers) {
            sortedList.add(p.clone());
        }

        // Ordenar por ID usando Comparator
        Collections.sort(sortedList, new Comparator<Passenger>() {
            @Override
            public int compare(Passenger p1, Passenger p2) {
                return Long.compare(p1.getId(), p2.getId());
            }
        }
        );
        return sortedList;
}

}

