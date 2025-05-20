/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers;

import airport.controllers.utils.Response;
import airport.controllers.utils.Status;
import airport.models.PlaneModel;
import airport.models.storage.PlaneStorage;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author isisp
 */
public class PlaneController {

    private final PlaneStorage storage = PlaneStorage.getInstance();

    //  REGISTRAR PLANE 
    public Response<PlaneModel> addPlane(PlaneModel plane) {
        Response<PlaneModel> validation = validatePlane(plane);
        if (validation != null) return validation;

        storage.addItem(plane);
        return new Response<>(Status.CREATED, "Avión registrado exitosamente.", plane.clone()); //patrón Prototype
    }

    // GET ALL PLANES EN ORDEN
    public Response<ArrayList<PlaneModel>> getAllPlanesOrdered() {
        ArrayList<PlaneModel> sorted = new ArrayList<>(storage.getPlanes());
        sorted.sort(Comparator.comparing(PlaneModel::getId));

        ArrayList<PlaneModel> clones = new ArrayList<>();
        for (PlaneModel p : sorted) {
            clones.add(p.clone());//patrón Prototype
        }

        return new Response<>(Status.OK, "Aviones obtenidos exitosamente.", clones);
    }

    // VALIDACIÓN
    private Response<PlaneModel> validatePlane(PlaneModel p) {
        // ID debe seguir el formato XXYYYYY
        if (p.getId() == null || !p.getId().matches("^[A-Z]{2}\\d{5}$")) {
            return new Response<>(Status.BAD_REQUEST, "ID inválido (formato XXYYYYY)", null);
        }

        // ID debe ser únicO 
        if (storage.existsById(p.getId())) {
            return new Response<>(Status.BAD_REQUEST, "Ya existe un avión con ese ID", null);
        }

        // Campos no deben estar vacíos
        if (isBlank(p.getBrand()) || isBlank(p.getModel()) || isBlank(p.getAirline())) {
            return new Response<>(Status.BAD_REQUEST, "Marca, modelo y aerolínea no deben estar vacíos", null);
        }
        
        // Capacidad debe ser mayor que 0
        if (p.getMaxCapacity() <= 0) {
            return new Response<>(Status.BAD_REQUEST, "Capacidad debe ser mayor que 0", null);
        }

        return null; 
    }

    // PARA VALIDAR CADENAS (AUX) 
    private boolean isBlank(String s) {
        return s == null || s.isBlank();
    }
}
