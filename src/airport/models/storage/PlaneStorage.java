/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.models.storage;


import airport.models.Plane;
import java.util.ArrayList;

/**
 *
 * @author vangu
 */
public class PlaneStorage extends Storage{
    private static PlaneStorage instance;
    private ArrayList<Plane> planes;

    private PlaneStorage() {
        this.planes = new ArrayList<>();
    }

    public static PlaneStorage getInstance() {
        if (instance == null) {
            instance = new PlaneStorage();
        }
        return instance;
    }

    @Override
    public void addItem(Object object) {
        Plane p = (Plane) object;
        if (!planes.contains(p)) {
            planes.add(p);
        }
    }

    public ArrayList<Plane> getPlanes() {
        return planes;
    }

    public boolean existsById(String id) {
        return planes.stream().anyMatch(p -> p.getId().equalsIgnoreCase(id));
    }
    




}
