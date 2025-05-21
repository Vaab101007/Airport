/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers;

import airport.controllers.utils.PlaneParser;
import airport.controllers.utils.PlaneValidator;
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
    private final PlaneValidator validator = new PlaneValidator();

    public static Response<PlaneModel> createPlane(
        String id, String brand, String model, String airline, String maxCapacityStr
    ) {
        Response<PlaneModel> parsed = PlaneParser.parse(id, brand, model, airline, maxCapacityStr);
        if (parsed.getStatus() != Status.OK) {
            return parsed;
        }

        PlaneModel plane = parsed.getData();
        PlaneValidator validator = new PlaneValidator();
        Response<PlaneModel> validation = validator.validate(plane);
        if (validation != null) {
            return validation;
        }

        PlaneStorage.getInstance().addItem(plane);
        return new Response<>(Status.CREATED, "Avión registrado con éxito", plane.clone());
    }

    public Response<PlaneModel> registerPlane(PlaneModel plane) {
        Response<PlaneModel> validation = validator.validate(plane);
        if (validation != null) {
            return validation;
        }

        storage.addItem(plane);
        return new Response<>(Status.CREATED, "Avión registrado con éxito", plane.clone());
    }
}


