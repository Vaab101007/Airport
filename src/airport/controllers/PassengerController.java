/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers;

import airport.controllers.utils.PassengerParser;
import airport.controllers.utils.PassengerValidator;
import airport.controllers.utils.Response;
import airport.models.Passenger;
import java.time.LocalDate;
import java.util.ArrayList;
import airport.models.storage.PassengerStorage;
import airport.controllers.utils.Status;
import java.time.format.DateTimeParseException;
import java.util.Comparator;

/**
 *
 * @author isisp
 */
public class PassengerController {

    private final PassengerStorage storage = PassengerStorage.getInstance();
    
 //     Vista llama este método con datos en formato String
    public Response<Passenger> createPassenger(
            String idStr, String firstname, String lastname,
            String yearStr, String monthStr, String dayStr,
            String phoneCodeStr, String phoneStr, String country
    ) {
        Response<Passenger> parsed = PassengerParser.parse(
                idStr, firstname, lastname,
                yearStr, monthStr, dayStr,
                phoneCodeStr, phoneStr, country
        );

        if (parsed.getStatus() != Status.OK) {
            return parsed;
        }

         Passenger p = parsed.getData();

        Response<Passenger> validation = PassengerValidator.validate(p, false, storage);
        if (validation != null) {
            return validation;
        }
          storage.addItem(p);
        return new Response<>(Status.CREATED, "Pasajero registrado con éxito", p.clone());
    }


// 📌 Para registrar un pasajero directamente
    public Response<Passenger> registerPassenger(Passenger p) {
        Response<Passenger> validation = PassengerValidator.validate(p, false, storage);
        if (validation != null) {
            return validation;
        }
        storage.addItem(p);
        return new Response<>(Status.CREATED, "Pasajero registrado con éxito", p.clone());
    }


    // Para actualizar un pasajero
    public Response<Passenger> updatePassenger(Passenger p) {
        Response<Passenger> validation = PassengerValidator.validate(p, true, storage);
        if (validation != null) {
            return validation;
        }
        Passenger original = storage.findById(p.getId());
        if (original == null) {
            return new Response<>(Status.NOT_FOUND, "Pasajero no encontrado", null);
        }
        // Actualizar los campos
        original.setFirstname(p.getFirstname());
        original.setLastname(p.getLastname());
        original.setBirthDate(p.getBirthDate());
        original.setCountry(p.getCountry());
        original.setCountryPhoneCode(p.getCountryPhoneCode());
        original.setPhone(p.getPhone());

        return new Response<>(Status.OK, "Pasajero actualizado con éxito", original.clone());
    }
    
        // 📌 Devolver todos los pasajeros ordenados por ID
    public Response<ArrayList<Passenger>> getAllPassengers() {
        ArrayList<Passenger> sorted = new ArrayList<>(storage.getPassengers());
        sorted.sort(Comparator.comparingLong(Passenger::getId));

        ArrayList<Passenger> clones = new ArrayList<>();
        for (Passenger p : sorted) {
            clones.add(p.clone());
        }

        return new Response<>(Status.OK, "Pasajeros obtenidos exitosamente.", clones);
    }

    // (opcional) Buscar por ID
    public Response<Passenger> getPassengerById(long id) {
        Passenger p = storage.findById(id);
        if (p == null) {
            return new Response<>(Status.NOT_FOUND, "Pasajero no encontrado", null);
        }
        return new Response<>(Status.OK, "Pasajero encontrado", p.clone());
    }
    
    }

