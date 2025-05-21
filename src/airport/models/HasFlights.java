/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package airport.models;

import airport.models.Flight;
import java.util.ArrayList;
/**
 *
 * @author vangu
 */
public interface HasFlights {
      void addFlight(Flight flight);
    ArrayList<Flight> getFlights();
}
