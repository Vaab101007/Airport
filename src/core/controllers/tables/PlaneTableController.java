/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.tables;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Plane;
import core.models.storage.PlaneStorage;
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
                model.setRowCount(0); 
                return new Response(Status.NO_CONTENT, "No hay aviones registrados", null);
            }

            planes.sort(Comparator.comparing(Plane::getId));
            model.setRowCount(0);

            for (Plane plane : planes) {
            int numFlights = (plane.getFlights() != null) ? plane.getFlights().size() : 0;

               Object[] row = {
                   plane.getId(),
                   plane.getBrand(),
                   plane.getModel(),
                   plane.getMaxCapacity(),
                   plane.getAirline(),
                   numFlights 
               };
               model.addRow(row);
            }

            return new Response(Status.OK, "Aviones cargados correctamente", null);

        } catch (Exception e) {
            return new Response(Status.INTERNAL_SERVER_ERROR, "Error inesperado al cargar aviones", null);
        }
    }
    

}


