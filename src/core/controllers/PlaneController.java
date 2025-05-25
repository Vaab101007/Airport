/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.parser.PlaneParser;
import core.controllers.utils.validator.PlaneValidator;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Plane;
import core.models.storage.PlaneStorage;

/**
 *
 * @author isisp
 */

// Controlador de lógica para el manejo de aviones. 
public class PlaneController {


    private final PlaneStorage storage = PlaneStorage.getInstance();
    private final PlaneValidator validator = new PlaneValidator();

    public static Response<Plane> createPlane(
        String id, String brand, String model, String airline, String maxCapacityStr
    ) {
        Response<Plane> parsed = PlaneParser.parse(id, brand, model, airline, maxCapacityStr);
        if (parsed.getStatus() != Status.OK) {
            return parsed;
        }

        Plane plane = parsed.getData();
        PlaneValidator validator = new PlaneValidator();
        Response<Plane> validation = validator.validate(plane);
        if (validation != null) {
            return validation;
        }

        PlaneStorage.getInstance().addItem(plane);
        return new Response<>(Status.CREATED, "Avión registrado con éxito", plane.clone());
    }

    public Response<Plane> registerPlane(Plane plane) {
        Response<Plane> validation = validator.validate(plane);
        if (validation != null) {
            return validation;
        }

        storage.addItem(plane);
        return new Response<>(Status.CREATED, "Avión registrado con éxito", plane.clone());
    }
}


