/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils.validator;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.storage.FlightStorage;

/**
 *
 * @author isisp
 */
public class FlightValidator {

     public Response<Flight> validate(Flight f) {
        if (FlightStorage.getInstance().existsById(f.getId())) {
            return new Response<>(Status.BAD_REQUEST, "Ya existe un vuelo con ese ID", null);
        }

        if (!f.getId().matches("[A-Z]{3}\\d{3}")) {
            return new Response<>(Status.BAD_REQUEST, "ID inválido. Debe tener formato XXX999", null);
        }

        if (f.getDepartureDate() == null) {
            return new Response<>(Status.BAD_REQUEST, "La fecha de salida no puede ser nula", null);
        }

        if (f.getPlane() == null || f.getDepartureLocation() == null || f.getArrivalLocation() == null) {
            return new Response<>(Status.BAD_REQUEST, "Debe seleccionar avión, localización de salida y llegada", null);
        }

        if (f.getHoursDurationArrival() == 0 && f.getMinutesDurationArrival() == 0) {
            return new Response<>(Status.BAD_REQUEST, "La duración del vuelo debe ser mayor a 00:00", null);
        }

        // Si no hay escala, su duración debe ser 0
        if (f.getScaleLocation() == null) {
            if (f.getHoursDurationScale() != 0 || f.getMinutesDurationScale() != 0) {
                return new Response<>(Status.BAD_REQUEST, "Si no hay escala, el tiempo de escala debe ser 0", null);
            }
        } else {
            // Si hay escala, su duración debe ser mayor a 00:00
            if (f.getHoursDurationScale() == 0 && f.getMinutesDurationScale() == 0) {
                return new Response<>(Status.BAD_REQUEST, "Si hay escala, el tiempo de escala debe ser mayor a 00:00", null);
            }
        }

        return null; // No hay errores
    }
}
