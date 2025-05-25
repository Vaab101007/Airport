/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.utils.calcPassengers;

import core.models.Passenger;
import java.time.LocalDate;
import java.time.Period;
/**
 *
 * @author vangu
 */
public class PassengerCalcs {
     public static int calculateAge(Passenger p) {
        if (p.getBirthDate() == null) return 0;
        return Period.between(p.getBirthDate(), LocalDate.now()).getYears();
    }

    public static int getNumFlights(Passenger p) {
        return p.getFlights().size();
    }
}
