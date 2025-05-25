/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storage;


import core.models.Plane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author vangu
 */
public class PlaneStorage extends Storage{
    private static PlaneStorage instance;
    private ArrayList<Plane> planes;

    PlaneStorage() {
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
            notifyObservers(); 
        }
    }

    public ArrayList<Plane> getPlanes() {
        return planes;
    }

    public boolean existsById(String id) {
        return planes.stream().anyMatch(p -> p.getId().equalsIgnoreCase(id));
    }
    
    
    public Plane findById(String id) {
    for (Plane p : planes) {
        if (p.getId().equalsIgnoreCase(id)) {
            return p;
        }
    }
    return null;
    }
 
    public List<Plane> getAllPlanes() {
        List<Plane> sortedList = new ArrayList<>();

        for (Plane p : planes) {
            sortedList.add(p.clone());
        }

        Collections.sort(sortedList, new Comparator<Plane>() {
            @Override
            public int compare(Plane p1, Plane p2) {
                return p1.getId().compareTo(p2.getId());
            }
        });

        return sortedList;
    }

}






