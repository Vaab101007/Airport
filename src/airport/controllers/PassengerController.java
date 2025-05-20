/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers;

import airport.controllers.utils.Response;
import airport.models.persons.PassengerModel;
import java.time.LocalDate;
import java.util.ArrayList;
import airport.models.storage.PassengerStorage;
import airport.controllers.utils.Status;
import java.util.Comparator;

/**
 *
    * @author isisp
 */
public class PassengerController {

    public static Response createPassenger(String id2, String firstname, String lastname, String year2, String month2, String date2, String countryPhoneCode, String phone2, String country2){
        
        long id = Long.parseLong(id2);
        int year = Integer.parseInt(year2);
        int month = Integer.parseInt(month2);
        int date = Integer.parseInt(date2);
        LocalDate birthDate = LocalDate.of(year,month,date);
        int phoneCode = Integer.parseInt(countryPhoneCode);
        long phone = Long.parseLong(phone2);
        
        PassengerModel p = new PassengerModel(id,firstname,lastname,birthDate,phoneCode,phone,country2);
 
        Response<PassengerModel> validation = validatePassenger(p, false);

        if (validation != null) return validation;
            storage.addItem(p);
        return new Response<>(Status.CREATED, "Pasajero registrado con éxito", p.clone());
    }
    private final PassengerStorage storage = PassengerStorage.getInstance();
 
    //REGISTRAR PASSENGER
    public Response<PassengerModel> registerPassenger(PassengerModel p) { 
        Response<PassengerModel> validation = validatePassenger(p, false);
        if (validation != null) return validation;
        storage.addItem(p);
        return new Response<>(Status.CREATED, "Pasajero registrado con éxito", p.clone()); // patrón Prototype
    }
    
    
    // ACTUALIZAR PASSENGER EXISTENTE 
    public Response<PassengerModel> updatePassenger(PassengerModel p) {
        //Valida que los nuevos datos cumplan con los requisitos anteriores 
        Response<PassengerModel> validation = validatePassenger(p, true);
        if (validation != null) {
            return validation;
        }

        PassengerModel original = storage.findById(p.getId());
        if (original == null) {
            return new Response<>(Status.NOT_FOUND, "Pasajero no encontrado", null); 
        }
        original.setFirstname(p.getFirstname());
        original.setLastname(p.getLastname());
        original.setBirthDate(p.getBirthDate());
        original.setCountry(p.getCountry());
        original.setCountryPhoneCode(p.getCountryPhoneCode());
        original.setPhone(p.getPhone());
        
        return new Response<>(Status.OK, "Pasajero actualizado con éxito", original.clone()); // patrón Prototype
    }
    
    //GET PASSENGERS POR ORDEN DE ID 
    public Response<ArrayList<PassengerModel>> getAllPassengers() {
        ArrayList<PassengerModel> sorted = new ArrayList<>(storage.getPassengers());
        sorted.sort(Comparator.comparingLong(PassengerModel::getId));
        ArrayList<PassengerModel> clones = new ArrayList<>();
        for (PassengerModel p : sorted) {
            clones.add(p.clone()); // patrón Prototype
        }
        return new Response<>(Status.OK, "Pasajeros obtenidos exitosamente.", clones);
    }
    
        //Validaciones   
    private Response<PassengerModel> validatePassenger(PassengerModel p, boolean isUpdate) {
            
        //Id de los pasajeros deben ser mayores o iguales que 0 y tener a lo más 15 dígitos.    
        if (p.getId() < 0 || String.valueOf(p.getId()).length() > 15) {
            return new Response<>(Status.BAD_REQUEST, "ID inválido (debe ser ≥ 0 y máx. 15 dígitos)", null);
        }
         //Id de los pasajeros deben ser únicos, 
        if (!isUpdate && storage.existsById(p.getId())) {
            return new Response<>(Status.BAD_REQUEST, "Ya existe un pasajero con ese ID", null);
        }
        //Los códigos telefónicos de los pasajeros deben ser mayores o iguales que 0 y tener a lo más 3 dígitos.
        if (p.getCountryPhoneCode() < 0 || String.valueOf(p.getCountryPhoneCode()).length() > 3) {
            return new Response<>(Status.BAD_REQUEST, "Código de país inválido (máx. 3 dígitos)", null);
        }
        //Los teléfonos de los pasajeros deben ser mayores o iguales que 0 y tener a lo más 11 dígitos
        if (p.getPhone() < 0 || String.valueOf(p.getPhone()).length() > 11) {
            return new Response<>(Status.BAD_REQUEST, "Teléfono inválido (máx. 11 dígitos)", null);
        }
         //fecha de nacimiento de los pasajeros debe ser válida.
        if (p.getBirthDate() == null || p.getBirthDate().isAfter(LocalDate.now())) {
            return new Response<>(Status.BAD_REQUEST, "Fecha de nacimiento inválida", null);
        }
        //El resto de los campos de los pasajeros no deben ser vacíos
        if (p.getFirstname().isBlank() || p.getLastname().isBlank() || p.getCountry().isBlank()) {
            return new Response<>(Status.BAD_REQUEST, "Nombre, apellido y país no deben estar vacíos", null);
        }
        
        return null;
    }
}

