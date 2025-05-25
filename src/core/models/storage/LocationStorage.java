/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storage;

import core.models.Location;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author vangu
 */
public class LocationStorage extends Storage {
        private static LocationStorage instance;
    private ArrayList<Location> locations;

    LocationStorage() {
        this.locations = new ArrayList<>();
    }

    public static LocationStorage getInstance() {
        if (instance == null) {
            instance = new LocationStorage();
        }
        return instance;
    }

    @Override
    public void addItem(Object object) {
        Location l = (Location) object;
        if (!locations.contains(l)) {
            locations.add(l);
             notifyObservers(); 
        }
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public boolean existsById(String id) {
        return locations.stream().anyMatch(l -> l.getAirportId().equalsIgnoreCase(id));
    }
    
  public Location findById(String id) {
    for (Location l : locations) {
        if (l.getAirportId().equals(id)) {
            return l;
        }
    }
    return null;
}

    
    public ArrayList<Location> getAllLocations() {
    ArrayList<Location> sortedList = new ArrayList<>();

    for (Location l : locations) {
        sortedList.add(l.clone());
    }

    Collections.sort(sortedList, new Comparator<Location>() {
        @Override
        public int compare(Location l1, Location l2) {
            return l1.getAirportId().compareTo(l2.getAirportId());
        }
    });

    return sortedList;
}
    

    
    
}
