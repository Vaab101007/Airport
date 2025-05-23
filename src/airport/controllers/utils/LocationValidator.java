/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers.utils;

import airport.models.Location;
import airport.models.storage.LocationStorage;

/**
 *
 * @author vangu
 */
public class LocationValidator {
    public static Response<Location> validate(Location location, LocationStorage storage, boolean isUpdate) {
        // Validar ID (exactamente 3 letras mayúsculas)
        if (location.getAirportId() == null || !location.getAirportId().matches("[A-Z]{3}")) {
            return new Response<>(Status.BAD_REQUEST, "El ID debe tener exactamente 3 letras mayúsculas", null);
        }

        // Verificar unicidad del ID (solo si no es actualización)
        if (!isUpdate && storage.existsById(location.getAirportId())) {
            return new Response<>(Status.BAD_REQUEST, "Ya existe un aeropuerto con este ID", null);
        }

        // Validar latitud [-90, 90] y 4 cifras decimales como máximo
        double lat = location.getAirportLatitude();
        if (lat < -90 || lat > 90 || !hasMaxFourDecimals(lat)) {
            return new Response<>(Status.BAD_REQUEST, "Latitud inválida: debe estar entre -90 y 90 y tener máximo 4 decimales", null);
        }

        // Validar longitud [-180, 180] y 4 cifras decimales como máximo
        double lon = location.getAirportLongitude();
        if (lon < -180 || lon > 180 || !hasMaxFourDecimals(lon)) {
            return new Response<>(Status.BAD_REQUEST, "Longitud inválida: debe estar entre -180 y 180 y tener máximo 4 decimales", null);
        }

        return null; // todo bien
    }

    private static boolean hasMaxFourDecimals(double value) {
        String[] parts = String.valueOf(value).split("\\.");
        return parts.length == 1 || parts[1].length() <= 4;
    }
}
