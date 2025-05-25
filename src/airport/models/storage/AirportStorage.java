/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.models.storage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isisp
 */
public class AirportStorage extends Storage {
    private static AirportStorage instance;
    
    /*Devuelve una única instancia de AirportStorage
    Si no existe la crea ->> es la unica forma de obtner
    una instancia de airport storgae como tipo para acceder 
    a una base de datos
    */
    public static AirportStorage getInstance (){
        if (instance == null){
            instance = new AirportStorage();
        }
        return instance;
    }
    
    private final PassengerStorage passengerSto;
    private final PlaneStorage planeSto;
    private final FlightStorage flightSto;
    private final LocationStorage locationSto;

    public AirportStorage() {
        this.passengerSto = PassengerStorage.getInstance();
        this.planeSto = PlaneStorage.getInstance();         
        this.flightSto = FlightStorage.getInstance();       
        this.locationSto = LocationStorage.getInstance(); 
        
    }
    
    // Métodos de acceso a los repositorios
    public PassengerStorage  getPassengerStorage() {
        return passengerSto;
    }
    
    public PlaneStorage getPlaneStorage() {
        return planeSto;
    }
    public FlightStorage getFlightStorage() {
        return flightSto;
    }
    public LocationStorage getLocationStorage() {
        return locationSto;
    }
    
    private List<Runnable> observers = new ArrayList<>();
    
    public void addObserver(Runnable observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Runnable observer : observers) {
            observer.run();
        }
    }

    @Override
    public void addItem(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
