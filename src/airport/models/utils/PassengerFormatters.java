/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.models.utils;

import airport.models.PassengerModel;

/**
 *
 * @author vangu
 */
public class PassengerFormatters {
        public static String getFullname(PassengerModel p) {
        return p.getFirstname() + " " + p.getLastname();
    }

    public static String generateFullPhone(PassengerModel p) {
        return "+" + p.getCountryPhoneCode() + " " + p.getPhone();
    }
}
