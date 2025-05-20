/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers;

import airport.controllers.utils.Response;
import airport.models.persons.Passenger;
import java.time.LocalDate;
import java.util.ArrayList;
import airport.models.storage.PassengerStorage;
import airport.controllers.utils.Status;
import airport.models.utils.PassengerFormatters;

/**
 *
    * @author isisp
 */
public class PassengerController {

 private final PassengerStorage storage = PassengerStorage.getInstance();

    public Response<Passenger> registerPassenger(Passenger p) {
        // Validaciones
        //Id de los pasajeros deben ser mayores o iguales que 0 y tener a lo más 15 dígitos.
        if (p.getId() < 0 || String.valueOf(p.getId()).length() > 15) {
            return new Response<>(Status.BAD_REQUEST, "ID inválido (debe ser ≥ 0 y máx. 15 dígitos)", null);
        }
        
        //Id de los pasajeros deben ser únicos, 
        if (storage.existsById(p.getId())) {
            return new Response<>(Status.BAD_REQUEST, "Ya existe un pasajero con ese ID", null);
        }
        
        //fecha de nacimiento de los pasajeros debe ser válida.
        if (p.getBirthDate() == null || p.getBirthDate().isAfter(LocalDate.now())) {
            return new Response<>(Status.BAD_REQUEST, "Fecha de nacimiento inválida", null);
        }
        
         //Los códigos telefónicos de los pasajeros deben ser mayores o iguales que 0 y tener a lo más 3 dígitos.
        if (p.getCountryPhoneCode() < 0 || String.valueOf(p.getCountryPhoneCode()).length() > 3) {
            return new Response<>(Status.BAD_REQUEST, "Código de país inválido (máx. 3 dígitos)", null);
        }
        
         //Los teléfonos de los pasajeros deben ser mayores o iguales que 0 y tener a lo más 11 dígitos
        if (p.getPhone() < 0 || String.valueOf(p.getPhone()).length() > 11) {
            return new Response<>(Status.BAD_REQUEST, "Teléfono inválido (máx. 11 dígitos)", null);
        }
        
        //El resto de los campos de los pasajeros no deben ser vacíos
        if (p.getFirstname().isBlank() || p.getLastname().isBlank() || p.getCountry().isBlank()) {
            return new Response<>(Status.BAD_REQUEST, "Nombre, apellido y país no deben estar vacíos", null);
        }

        // Registro
        storage.addItem(p);

        // Opcional: mostrar datos de salida usando los formatters
        // String nombreCompleto = PassengerFormatters.getFullname(p);
        // String telefono = PassengerFormatters.generateFullPhone(p);
        //System.out.println("Pasajero registrado: " + nombreCompleto + " - Tel: " + telefono);
        
        return new Response<>(Status.CREATED, "Pasajero registrado con éxito", p.clone()); // patrón Prototype
    }

    public ArrayList<Passenger> getAllPassengers() { //REVISAR!!! 
        ArrayList<Passenger> result = new ArrayList<>();
        for (Passenger p : storage.getPassengers()) {
            result.add(p.clone()); 
        }
        return result;
    }
}
