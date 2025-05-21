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
import java.util.regex.Pattern;

/**
 *
 * @author isisp
 */
/**
 * Controlador de lógica para el manejo de aviones.
 * Solo permite registrar nuevos aviones, validando sus datos.
 */
public class PlaneController {

    private final PlaneStorage storage = PlaneStorage.getInstance();

    /**
     * Registra un avión a partir de datos tipo String (desde la vista).
     *
     * @param id El ID del avión (formato XXYYYYY).
     * @param brand Marca del avión.
     * @param model Modelo del avión.
     * @param airline Aerolínea a la que pertenece.
     * @param maxCapacityStr Capacidad máxima (como string).
     * @return Response con estado, mensaje y el avión clonado si fue exitoso.
     */
    public static Response<PlaneModel> createPlane(
        String id, String brand, String model, String airline, String maxCapacityStr
) {
    // Validar que ningún campo esté vacío
    if (id.isBlank() || brand.isBlank() || model.isBlank() || airline.isBlank() || maxCapacityStr.isBlank()) {
        return new Response<>(Status.BAD_REQUEST, "Todos los campos deben estar completos", null);
    }

    int maxCapacity;
    try {
        maxCapacity = Integer.parseInt(maxCapacityStr);
        if (maxCapacity <= 0) {
            return new Response<>(Status.BAD_REQUEST, "La capacidad máxima debe ser mayor a 0", null);
        }
    } catch (NumberFormatException e) {
        return new Response<>(Status.BAD_REQUEST, "Capacidad máxima inválida", null);
    }

    // Crear el avión
    PlaneModel plane = new PlaneModel(id, brand, model, airline, maxCapacity);

    // Validar con reglas internas (ID, existencia, etc.)
    PlaneController controller = new PlaneController();
    Response<PlaneModel> validation = controller.validatePlane(plane);
    if (validation != null) {
        return validation;
    }

    // Registrar y retornar éxito
    controller.storage.addItem(plane);
    return new Response<>(Status.CREATED, "Avión registrado con éxito", plane.clone());
}


    /**
     * Valida los datos del avión antes de almacenarlo.
     * @param plane Avión a validar.
     * @return Response con error o null si todo está correcto.
     */
    private Response<PlaneModel> validatePlane(PlaneModel plane) {
        // Validar ID único con formato XXYYYYY (2 letras mayúsculas + 5 dígitos)
        if (!Pattern.matches("^[A-Z]{2}\\d{5}$", plane.getId())) {
            return new Response<>(Status.BAD_REQUEST, "ID inválido: debe tener formato XXYYYYY (dos letras y cinco números)", null);
        }

        if (storage.existsById(plane.getId())) {
            return new Response<>(Status.BAD_REQUEST, "Ya existe un avión con ese ID", null);
        }

        // Validar que los campos no estén vacíos
        if (plane.getBrand().isBlank() || plane.getModel().isBlank() || plane.getAirline().isBlank()) {
            return new Response<>(Status.BAD_REQUEST, "Marca, modelo y aerolínea no deben estar vacíos", null);
        }

        return null;
    }

    /**
     * Variante que permite registrar directamente con un objeto ya creado.
     * @param plane Objeto del avión.
     * @return Response de éxito o error con clon del avión.
     */
    public Response<PlaneModel> registerPlane(PlaneModel plane) {
        Response<PlaneModel> validation = validatePlane(plane);
        if (validation != null) {
            return validation;
        }

        storage.addItem(plane);
        return new Response<>(Status.CREATED, "Avión registrado con éxito", plane.clone());
    }

    

    // PARA VALIDAR CADENAS (AUX) 
    private boolean isBlank(String s) {
        return s == null || s.isBlank();
    }
}
