/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.parser.FlightParser;
import core.controllers.utils.validator.FlightValidator;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Location;
import core.models.Passenger;
import core.models.Plane;
import core.models.storage.FlightStorage;
import core.models.storage.PassengerStorage;
import core.models.storage.PlaneStorage;

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

        PlaneStorage planeStorage = PlaneStorage.getInstance();
        Plane storedPlane = planeStorage.findById(plane.getId());

        storage.addItem(flight);
        return new Response<>(Status.CREATED, "Vuelo registrado correctamente", flight.clone());
    }

    public Response<Flight> registerFlight(Flight flight) {
        Response<Flight> validation = validator.validate(flight);
        if (validation != null) {
            return validation;
        }

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
        passenger.addFlight(flight); 
        PassengerStorage.getInstance().notifyObservers(); 
        
        return new Response<>(Status.OK, "Pasajero añadido exitosamente", flight.clone());
    }

    // Retardar vuelo por horas y minutos
    public Response<Flight> delayFlight(String idStr, String hoursStr, String minutesStr) {
    int hours, minutes;
    try {
        hours = Integer.parseInt(hoursStr);
        minutes = Integer.parseInt(minutesStr);
    } catch (NumberFormatException e) {
        return new Response<>(Status.BAD_REQUEST, "Horas o minutos inválidos", null);
    }

    if (hours == 0 && minutes == 0) {
        return new Response<>(Status.BAD_REQUEST, "El retraso debe ser mayor a 00:00", null);
    }

    Flight flight = storage.findById(idStr);
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

    public boolean linkPassengerToFlight(String flightId, long passengerId) {
        Flight f = storage.findById(flightId);
        Passenger p = PassengerStorage.getInstance().findById(passengerId);
        if (f == null || p == null) {
            return false;
        }

        f.addPassenger(p);
        p.addFlight(f);
        PassengerStorage.getInstance().notifyObservers();
        return true;
    }

}
