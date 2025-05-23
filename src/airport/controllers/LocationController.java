/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers;

import airport.controllers.utils.LocationParser;
import airport.controllers.utils.LocationValidator;
import airport.controllers.utils.Response;
import airport.controllers.utils.Status;
import airport.models.Location;
import airport.models.storage.LocationStorage;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author vangu
 */
public class LocationController {
    private final LocationStorage storage = LocationStorage.getInstance();

    // 🛬 Crear localización desde strings (vista)
    public Response<Location> createLocation(
            String id, String name, String city, String country,
            String latStr, String lonStr
    ) {
        Response<Location> parsed = LocationParser.parse(id, name, city, country, latStr, lonStr);
        if (parsed.getStatus() != Status.OK) {
            return parsed;
        }

        Location location = parsed.getData();
        Response<Location> validation = LocationValidator.validate(location, storage, false);
        if (validation != null) return validation;

        storage.addItem(location);
        return new Response<>(Status.CREATED, "Aeropuerto creado con éxito", location.clone());
    }

    // 🧾 Obtener todas las localizaciones ordenadas por ID
    public Response<ArrayList<Location>> getAllLocations() {
        ArrayList<Location> sorted = new ArrayList<>(storage.getLocations());
        sorted.sort(Comparator.comparing(Location::getAirportId));
        ArrayList<Location> clones = new ArrayList<>();
        for (Location l : sorted) {
            clones.add(l.clone());
        }
        return new Response<>(Status.OK, "Localizaciones cargadas correctamente", clones);
    }
}
