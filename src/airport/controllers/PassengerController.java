/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers;

import airport.controllers.utils.Response;
import airport.models.Passenger;
import java.time.LocalDate;
import java.util.ArrayList;
import airport.models.storage.PassengerStorage;
import airport.controllers.utils.Status;

/**
 *
 * @author vangu
 */
public class PassengerController {

    private final PassengerStorage storage = PassengerStorage.getInstance();


    public Response<Passenger> registerPassenger(Passenger p) {
        // Validaciones

        if (p.getId() < 0 || String.valueOf(p.getId()).length() > 15) {
            return new Response<>(Status.BAD_REQUEST, "ID inválido (debe ser ≥ 0 y máx. 15 dígitos)", null);
        }

        if (p.getFirstname().isBlank() || p.getLastname().isBlank() || p.getCountry().isBlank()) {
            return new Response<>(Status.BAD_REQUEST, "Nombre, apellido y país no deben estar vacíos", null);
        }

        if (p.getCountryPhoneCode() < 0 || String.valueOf(p.getCountryPhoneCode()).length() > 3) {
            return new Response<>(Status.BAD_REQUEST, "Código de país inválido (máx. 3 dígitos)", null);
        }

        if (p.getPhone() < 0 || String.valueOf(p.getPhone()).length() > 11) {
            return new Response<>(Status.BAD_REQUEST, "Teléfono inválido (máx. 11 dígitos)", null);
        }

        if (p.getBirthDate() == null || p.getBirthDate().isAfter(LocalDate.now())) {
            return new Response<>(Status.BAD_REQUEST, "Fecha de nacimiento inválida", null);
        }

        // Evitar duplicados
        if (storage.existsById(p.getId())) {
            return new Response<>(Status.BAD_REQUEST, "Ya existe un pasajero con ese ID", null);
        }

        // Registro
        storage.addItem(p);
        return new Response<>(Status.OK, "Pasajero registrado con éxito", p.clone());
    }

    public ArrayList<Passenger> getPassengers() {
        return storage.getPassengers();
    }
}
