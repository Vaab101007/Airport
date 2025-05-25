/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.utils;


import core.models.Flight;
import java.util.ArrayList;
/**
 *
 * @author vangu
 */
public interface HasFlights {
      void addFlight(Flight flight);
    ArrayList<Flight> getFlights();
}
