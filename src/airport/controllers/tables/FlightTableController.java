/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers.tables;

import airport.controllers.utils.Response;
import airport.controllers.utils.Status;
import airport.models.Flight;
import airport.models.storage.FlightStorage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isisp
 */
public class FlightTableController {
   
    private final FlightStorage flightStorage = FlightStorage.getInstance();

    public List<String[]> getAllFlightsForTable() {
        List<String[]> tableData = new ArrayList<>();

        for (Flight flight : flightStorage.getAllFlightsOrdered()) {
            // Ya que Location contiene directamente los datos del aeropuerto:
            String departureId = flight.getDepartureLocation().getAirportId();
            String arrivalId = flight.getArrivalLocation().getAirportId();
            String scaleId = (flight.getScaleLocation() != null)
                ? flight.getScaleLocation().getAirportId()
                : "N/A";

            String planeId = flight.getPlane().getId();
            int passengerCount = flight.getNumPassengers();

            String[] row = new String[] {
                flight.getId(),
                departureId,
                arrivalId,
                scaleId,
                flight.getDepartureDate().toString(),
                flight.calculateArrivalDate().toString(),
                planeId,
                String.valueOf(passengerCount)
            };

            tableData.add(row);
        }

        return tableData;
    }

    public Response<List<String[]>> refreshTableData() {
        try {
            List<String[]> flights = getAllFlightsForTable();
            return new Response<>(Status.OK, "Datos de vuelo cargados correctamente", flights);
        } catch (Exception e) {
            return new Response<>(Status.INTERNAL_SERVER_ERROR , "Error al cargar los datos de vuelo", null);
        }
    }


}
