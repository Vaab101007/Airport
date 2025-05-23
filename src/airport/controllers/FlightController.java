/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers;

import airport.controllers.utils.FlightParser;
import airport.controllers.utils.FlightValidator;
import airport.controllers.utils.Response;
import airport.controllers.utils.Status;
import airport.models.Flight;
import airport.models.Location;
import airport.models.Passenger;
import airport.models.Plane;
import airport.models.storage.FlightStorage;


/**
 *
 * @author isisp
 */
public class FlightController {
        private final FlightStorage storage = FlightStorage.getInstance();
    private final FlightValidator validator = new FlightValidator();
    
        public Response<Flight> createFlight(
            String id,
            Plane plane,
            Location departure,
            Location scale,
            Location arrival,
            String departureDateStr,
            String hoursArrStr,
            String minutesArrStr,
            String hoursScaleStr,
            String minutesScaleStr
    ) {
        Response<Flight> parsed = FlightParser.parse(
                id, plane, departure, scale, arrival,
                departureDateStr,
                hoursArrStr, minutesArrStr,
                hoursScaleStr, minutesScaleStr
        );

        if (parsed.getStatus() != Status.OK) {
            return parsed;
        }

        Flight flight = parsed.getData();

        Response<Flight> validation = validator.validate(flight);
        if (validation != null) {
            return validation;
        }

        storage.addItem(flight);
        return new Response<>(Status.CREATED, "Vuelo registrado correctamente", flight.clone());
    }

    // Vista llama este método con un objeto Flight ya parseado
    public Response<Flight> registerFlight(Flight flight) {
        Response<Flight> validation = validator.validate(flight);
        if (validation != null) return validation;

        storage.addItem(flight);
        return new Response<>(Status.CREATED, "Vuelo registrado correctamente", flight.clone());
    }

    // Añadir un pasajero a un vuelo
    public Response<Flight> addPassenger(String flightId, Passenger passenger) {
        Flight flight = storage.findById(flightId);
        if (flight == null) {
            return new Response<>(Status.NOT_FOUND, "Vuelo no encontrado", null);
        }
        flight.addPassenger(passenger);
        return new Response<>(Status.OK, "Pasajero añadido exitosamente", flight.clone());
    }

    // Retardar vuelo por horas y minutos
    public Response<Flight> delayFlight(String id, int hours, int minutes) {
        if (hours == 0 && minutes == 0) {
            return new Response<>(Status.BAD_REQUEST, "El retraso debe ser mayor a 00:00", null);
        }
        Flight flight = storage.findById(id);
        if (flight == null) {
            return new Response<>(Status.NOT_FOUND, "Vuelo no encontrado", null);
        }
        flight.delay(hours, minutes);
        return new Response<>(Status.OK, "Vuelo retrasado exitosamente", flight.clone());
    }

    // Buscar vuelo por ID
    public Response<Flight> getFlightById(String id) {
        Flight flight = storage.findById(id);
        if (flight == null) {
            return new Response<>(Status.NOT_FOUND, "Vuelo no encontrado", null);
        }
        return new Response<>(Status.OK, "Vuelo encontrado", flight.clone());
    }



}
