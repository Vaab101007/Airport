/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.models;

import java.util.ArrayList;

/**
 *
 * @author edangulo
 */
public class Plane implements Prototype<Plane> {

    private final String id;
    private String brand;
    private String model;
    private int maxCapacity;
    private String airline;
    private final ArrayList<Flight> flights;

    public Plane(String id, String brand, String model, int maxCapacity, String airline) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.maxCapacity = maxCapacity;
        this.airline = airline;
        this.flights = new ArrayList<>();
    }

    public String getId() { 
        return id; 
    }
    
    public String getBrand() { 
        return brand; 
    }
    
    public String getModel() { 
        return model; 
    }
    
    public int getMaxCapacity() { 
        return maxCapacity; 
    }
    
    public String getAirline() {
        return airline; 
    }
    
    public ArrayList<Flight> getFlights() { 
        return flights; 
    }
    
    public void addFlight(Flight flight) {
    this.flights.add(flight);
}

    public void setBrand(String brand) { 
        this.brand = brand;
    }
    public void setModel(String model) { 
        this.model = model; 
    }
    public void setAirline(String airline) { 
        this.airline = airline; 
    }
    
    

    // clone (Prototype)
    @Override
    public Plane clone() {
        Plane copy = new Plane(id, brand, model, maxCapacity, airline);
        copy.getFlights().addAll(flights); // copia superficial
        return copy;
    }

}
