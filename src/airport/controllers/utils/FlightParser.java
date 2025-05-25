/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers.utils;

import airport.models.Flight;
import airport.models.Location;
import airport.models.Plane;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/**
 *
 * @author isisp
 */
public class FlightParser {
    public static Response<Flight> parse(String id, Plane plane, Location dep, Location scale, Location arr, String departureDateStr, String hArrStr, String mArrStr, String hScaleStr, String mScaleStr) {
        try {
            LocalDateTime departureDate = LocalDateTime.parse(departureDateStr);
            int hArr = Integer.parseInt(hArrStr);
            int mArr = Integer.parseInt(mArrStr);
            int hScale = scale == null ? 0 : Integer.parseInt(hScaleStr);
            int mScale = scale == null ? 0 : Integer.parseInt(mScaleStr);

            Flight flight;
            
            if (scale == null) {
                flight = new Flight(id, plane, dep, arr, departureDate, hArr, mArr);
            } else {
                flight = new Flight(id, plane, dep, scale, arr, departureDate, hArr, mArr, hScale, mScale);
            }

            return new Response<>(Status.OK, "Parseo exitoso", flight);

        } catch (NumberFormatException | DateTimeParseException e) {
            return new Response<>(Status.BAD_REQUEST, "Error en el formato de datos: " + e.getMessage(), null);
        }
    } 
}
