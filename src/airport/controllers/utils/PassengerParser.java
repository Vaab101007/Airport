/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.controllers.utils;

import airport.models.Passenger;
import java.time.LocalDate;

/**
 *
 * @author vangu
 */
public class PassengerParser {

    public static Response<Passenger> parse(
            String idStr, String firstname, String lastname,
            String yearStr, String monthStr, String dayStr,
            String phoneCodeStr, String phoneStr, String country
    ) {
        try {
            long id = Long.parseLong(idStr);
            int year = Integer.parseInt(yearStr.trim());
            int month = Integer.parseInt(monthStr.trim());
            int day = Integer.parseInt(dayStr.trim());
            int phoneCode = Integer.parseInt(phoneCodeStr.trim());
            long phone = Long.parseLong(phoneStr.trim());
            LocalDate birthDate = LocalDate.of(year, month, day);

            System.out.println("ID: " + idStr);
            System.out.println("Año: " + yearStr + ", Mes: " + monthStr + ", Día: " + dayStr);
            System.out.println("PhoneCode: " + phoneCodeStr + ", Phone: " + phoneStr);

            Passenger p = new Passenger(id, firstname, lastname, birthDate, phoneCode, phone, country);
            return new Response<>(Status.OK, "Parseo exitoso", p);

        } catch (NumberFormatException e) {
            return new Response<>(Status.BAD_REQUEST, "Error de formato: ingresa solo números válidos", null);
        } catch (RuntimeException e) {
            return new Response<>(Status.BAD_REQUEST, "Fecha inválida", null);
        }
    }
}
