/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers.tables;
import airport.models.Location;
import airport.models.storage.LocationStorage;
import airport.controllers.utils.Response;
import airport.controllers.utils.Status;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author vangu
 */
public class LocationTableController {
     public static Response updateLocationTable(DefaultTableModel model) {
        try {
            LocationStorage storage = LocationStorage.getInstance();
            ArrayList<Location> locations = storage.getLocations();

            if (locations == null || locations.isEmpty()) {
                model.setRowCount(0);
                return new Response(Status.NO_CONTENT, "No hay localizaciones registradas", null);
            }

            locations.sort(Comparator.comparing(Location::getAirportId));
            model.setRowCount(0); // Limpia la tabla

            for (Location l : locations) {
                Object[] row = {
                    l.getAirportId(),
                    l.getAirportName(),
                    l.getAirportCity(),
                    l.getAirportCountry()
                };
                model.addRow(row);
            }

            return new Response(Status.OK, "Localizaciones cargadas correctamente", null);

        } catch (Exception e) {
            return new Response(Status.INTERNAL_SERVER_ERROR, "Error inesperado al cargar localizaciones", null);
        }
    }
}
