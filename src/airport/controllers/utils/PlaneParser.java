/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers.utils;

import airport.models.PlaneModel;

/**
 *
 * @author isisp
 */
public class PlaneParser {

    public static Response<PlaneModel> parse(
        String id, String brand, String model, String airline, String maxCapacityStr
    ) {
        if (id.isBlank() || brand.isBlank() || model.isBlank() || airline.isBlank() || maxCapacityStr.isBlank()) {
            return new Response<>(Status.BAD_REQUEST, "Todos los campos deben estar completos", null);
        }

        try {
            int maxCapacity = Integer.parseInt(maxCapacityStr);
            if (maxCapacity <= 0) {
                return new Response<>(Status.BAD_REQUEST, "La capacidad máxima debe ser mayor a 0", null);
            }

            PlaneModel plane = new PlaneModel(id, brand, model, maxCapacity, airline);
            return new Response<>(Status.OK, "Parseo exitoso", plane);

        } catch (NumberFormatException e) {
            return new Response<>(Status.BAD_REQUEST, "Capacidad máxima inválida", null);
        }
    }
}
