/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers.tables;

import airport.controllers.utils.Response;
import airport.controllers.utils.Status;
import airport.models.Plane;
import airport.models.storage.PlaneStorage;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isisp
 */
public class PlaneTableController {

    public static Response updatePlaneTable(DefaultTableModel model) {
        try {
            PlaneStorage storage = PlaneStorage.getInstance();
            ArrayList<Plane> planes = storage.getPlanes();

            if (planes == null || planes.isEmpty()) {
                model.setRowCount(0); // limpia la tabla
                return new Response(Status.NO_CONTENT, "No hay aviones registrados", null);
            }

            planes.sort(Comparator.comparing(Plane::getId));
            model.setRowCount(0); // limpia la tabla antes de llenarla

            for (Plane plane : planes) {
                Object[] row = {
                    plane.getId(),
                    plane.getBrand(),
                    plane.getModel(),
                    plane.getAirline(),
                    plane.getMaxCapacity()
                };
                model.addRow(row);
            }

            return new Response(Status.OK, "Aviones cargados correctamente", null);

        } catch (Exception e) {
            return new Response(Status.INTERNAL_SERVER_ERROR, "Error inesperado al cargar aviones", null);
        }
    }
    
    //FALTA AÑADIR NUM DE VUELOS POR AVION 
}


