/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers;

import airport.controllers.utils.Response;
import airport.models.PassengerModel;
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
    
    // 💾 REGISTRO DESDE STRINGS (llamado por la vista)
    public static Response<PassengerModel> createPassenger(
            String idStr, String firstname, String lastname,
            String yearStr, String monthStr, String dayStr,
            String phoneCodeStr, String phoneStr, String country
    ) {
        long id;
        int year, month, day, phoneCode;
        long phone;
        LocalDate birthDate;

        try {
            id = Long.parseLong(idStr);
            year = Integer.parseInt(yearStr);
            month = Integer.parseInt(monthStr);
            day = Integer.parseInt(dayStr);
            birthDate = LocalDate.of(year, month, day);
            phoneCode = Integer.parseInt(phoneCodeStr);
            phone = Long.parseLong(phoneStr);
        } catch (NumberFormatException e) {
            return new Response<>(Status.BAD_REQUEST, "Error de formato: ingresá solo números válidos", null);
        } catch (RuntimeException e) {
            return new Response<>(Status.BAD_REQUEST, "Fecha inválida", null);
        }

        PassengerModel p = new PassengerModel(id, firstname, lastname, birthDate, phoneCode, phone, country);

        PassengerController controller = new PassengerController();
        Response<PassengerModel> validation = controller.validatePassenger(p, false);
        if (validation != null) {
            return validation;
        }

        controller.storage.addItem(p);
        return new Response<>(Status.CREATED, "Pasajero registrado con éxito", p.clone());
    }

    // VALIDACIÓN (privada)
    private Response<PassengerModel> validatePassenger(PassengerModel p, boolean isUpdate) {
        if (p.getId() < 0 || String.valueOf(p.getId()).length() > 15) {
            return new Response<>(Status.BAD_REQUEST, "ID inválido (debe ser ≥ 0 y máx. 15 dígitos)", null);
        }

        if (!isUpdate && storage.existsById(p.getId())) {
            return new Response<>(Status.BAD_REQUEST, "Ya existe un pasajero con ese ID", null);
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

        if (p.getFirstname().isBlank() || p.getLastname().isBlank() || p.getCountry().isBlank()) {
            return new Response<>(Status.BAD_REQUEST, "Nombre, apellido y país no deben estar vacíos", null);
        }

        return null;
    }

    //  REGISTRO (con objeto directamente)
    public Response<PassengerModel> registerPassenger(PassengerModel p) {
        Response<PassengerModel> validation = validatePassenger(p, false);
        if (validation != null) {
            return validation;
        }

        storage.addItem(p);
        return new Response<>(Status.CREATED, "Pasajero registrado con éxito", p.clone());
    }

    //  ACTUALIZACIÓN
    public Response<PassengerModel> updatePassenger(PassengerModel p) {
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
        original.setCountryPhoneCode(p.getCountryPhoneCode());
        original.setPhone(p.getPhone());
        original.setCountry(p.getCountry());

        return new Response<>(Status.OK, "Pasajero actualizado con éxito", original.clone());
    }
}
