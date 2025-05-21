/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers.utils;

import airport.models.PassengerModel;
import java.time.LocalDate;

/**
 *
 * @author vangu
 */
public class PassengerParser {
     public static Response<PassengerModel> parse(
        String idStr, String firstname, String lastname,
        String yearStr, String monthStr, String dayStr,
        String phoneCodeStr, String phoneStr, String country
    ) {
        try {
            long id = Long.parseLong(idStr);
            int year = Integer.parseInt(yearStr);
            int month = Integer.parseInt(monthStr);
            int day = Integer.parseInt(dayStr);
            int phoneCode = Integer.parseInt(phoneCodeStr);
            long phone = Long.parseLong(phoneStr);
            LocalDate birthDate = LocalDate.of(year, month, day);

            PassengerModel p = new PassengerModel(id, firstname, lastname, birthDate, phoneCode, phone, country);
            return new Response<>(Status.OK, "Parseo exitoso", p);

        } catch (NumberFormatException e) {
            return new Response<>(Status.BAD_REQUEST, "Error de formato: ingresá solo números válidos", null);
        } catch (RuntimeException e) {
            return new Response<>(Status.BAD_REQUEST, "Fecha inválida", null);
        }
    }
}
