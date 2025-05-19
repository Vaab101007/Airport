/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.models.storage;

import airport.models.Location;
import java.util.ArrayList;
/**
 *
 * @author vangu
 */
public class LocationStorage extends Storage {
        private static LocationStorage instance;
    private ArrayList<Location> locations;

    private LocationStorage() {
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
        }
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public boolean existsById(String id) {
        return locations.stream().anyMatch(l -> l.getAirportId().equalsIgnoreCase(id));
    }

}
