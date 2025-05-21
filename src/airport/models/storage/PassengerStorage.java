/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.models.storage;

import airport.models.PassengerModel;
import java.util.ArrayList;
/**
 *
 * @author vangu
 */
public class PassengerStorage extends Storage {
    private static PassengerStorage instance;
    private ArrayList<PassengerModel> passengers;

    private PassengerStorage() {
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
        PassengerModel p = (PassengerModel) object;
        if (!passengers.contains(p)) {
            passengers.add(p);
        }
    }

    public ArrayList<PassengerModel> getPassengers() {
        return passengers;
    }

    public boolean existsById(long id) {
        return passengers.stream().anyMatch(p -> p.getId() == id);
    }
    
    public PassengerModel findById(long id) {
    for (PassengerModel p : passengers) {
        if (p.getId() == id) {
            return p;
        }
   }
    return null;
    }
    
}

