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
     public static Response<Void> updateLocationTable(DefaultTableModel model) {
        try {
            model.setRowCount(0); // limpiar

            ArrayList<Location> locations = new ArrayList<>(LocationStorage.getInstance().getLocations());
            if (locations.isEmpty()) {
                return new Response<>(Status.NO_CONTENT, "No hay localizaciones registradas", null);
            }

            locations.sort(Comparator.comparing(Location::getAirportId));
            for (Location loc : locations) {
                model.addRow(new Object[]{
                    loc.getAirportId(),
                    loc.getAirportName(),
                    loc.getAirportCity(),
                    loc.getAirportCountry()
                });
            }

            return new Response<>(Status.OK, "Tabla actualizada con éxito", null);
        } catch (Exception e) {
            return new Response<>(Status.INTERNAL_SERVER_ERROR, "Error inesperado", null);
        }
    }
}
