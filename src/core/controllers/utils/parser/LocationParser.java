/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils.parser;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Location;

/**
 *
 * @author vangu
 */
public class LocationParser {
    
    public static Response<Location> parse(
            String id, String name, String city, String country,
            String latStr, String lonStr
    ) {
        if (id.isBlank() || name.isBlank() || city.isBlank() || country.isBlank()) {
            return new Response<>(Status.BAD_REQUEST, "Ningún campo puede estar vacío", null);
        }

        double latitude, longitude;

        try {
            latitude = Double.parseDouble(latStr);
            longitude = Double.parseDouble(lonStr);
        } catch (NumberFormatException e) {
            return new Response<>(Status.BAD_REQUEST, "Latitud y longitud deben ser números válidos", null);
        }

        // Validar número de decimales (hasta 4)
        if (!hasValidDecimals(latStr, 4) || !hasValidDecimals(lonStr, 4)) {
            return new Response<>(Status.BAD_REQUEST, "Latitud y longitud deben tener como máximo 4 cifras decimales", null);
        }

        Location location = new Location(id, name, city, country, latitude, longitude);
        return new Response<>(Status.OK, "Parseo exitoso", location);
    }

    private static boolean hasValidDecimals(String numStr, int maxDecimals) {
        int dotIndex = numStr.indexOf(".");
        if (dotIndex == -1) return true; // No hay decimales
        int decimals = numStr.length() - dotIndex - 1;
        return decimals <= maxDecimals;
    }
}


