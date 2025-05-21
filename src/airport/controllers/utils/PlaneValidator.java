/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers.utils;

/**
 *
 * @author isisp
 */
import airport.models.PlaneModel;
import airport.models.storage.PlaneStorage;
import java.util.regex.Pattern;

public class PlaneValidator {

    private final PlaneStorage storage = PlaneStorage.getInstance();

    public Response<PlaneModel> validate(PlaneModel plane) {
        if (!Pattern.matches("^[A-Z]{2}\\d{5}$", plane.getId())) {
            return new Response<>(Status.BAD_REQUEST, "ID inválido: debe tener formato XXYYYYY (dos letras y cinco números)", null);
        }

        if (storage.existsById(plane.getId())) {
            return new Response<>(Status.BAD_REQUEST, "Ya existe un avión con ese ID", null);
        }

        if (isBlank(plane.getBrand()) || isBlank(plane.getModel()) || isBlank(plane.getAirline())) {
            return new Response<>(Status.BAD_REQUEST, "Marca, modelo y aerolínea no deben estar vacíos", null);
        }

        if (plane.getMaxCapacity() <= 0) {
            return new Response<>(Status.BAD_REQUEST, "La capacidad máxima debe ser mayor a 0", null);
        }

        return null;
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}

