/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.utils;


import core.controllers.utils.parser.FlightParser;
import core.controllers.utils.validator.LocationValidator;
import core.controllers.utils.validator.PassengerValidator;
import core.controllers.utils.validator.PlaneValidator;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Location;
import core.models.Passenger;
import core.models.Plane;
import core.models.storage.FlightStorage;
import core.models.storage.LocationStorage;
import core.models.storage.PassengerStorage;
import core.models.storage.PlaneStorage;
import java.io.FileReader;
import java.time.LocalDate;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author isisp
 */
public class JsonLoader {
 public void loadPassengers() {
        try {
            FileReader reader = new FileReader("json/passengers.json");
            JSONArray array = new JSONArray(new JSONTokener(reader));
            PassengerStorage storage = PassengerStorage.getInstance();

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);

                Passenger p = new Passenger(
                    obj.getLong("id"),
                    obj.getString("firstname"),
                    obj.getString("lastname"),
                    LocalDate.parse(obj.getString("birthDate")),
                    obj.getInt("countryPhoneCode"),
                    obj.getLong("phone"),
                    obj.getString("country")
                );

                Response<Passenger> validation = PassengerValidator.validate(p, false, storage);
                if (validation != null && validation.getStatus() != Status.OK) {
                    continue;
                }
                
                storage.addItem(p);
            }

       
        } catch (Exception e) {
            System.err.println(e.getMessage());
            

        }
    }
 
    public void loadPlanes() {
    try {
        FileReader reader = new FileReader("json/planes.json");
        JSONArray array = new JSONArray(new JSONTokener(reader));
        PlaneStorage storage = PlaneStorage.getInstance();

        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);

            Plane plane = new Plane(
                obj.getString("id"),
                obj.getString("brand"),
                obj.getString("model"),
                obj.getInt("maxCapacity"),
                obj.getString("airline")
            );

            PlaneValidator validator = new PlaneValidator();
            Response<Plane> validation = validator.validate(plane);
            if (validation != null && validation.getStatus() != Status.OK) {
                continue;
            }
            storage.addItem(plane);
        }
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }
}
    public void loadLocations() {
    try {
        FileReader reader = new FileReader("json/locations.json");
        JSONArray array = new JSONArray(new JSONTokener(reader));
        LocationStorage storage = LocationStorage.getInstance();

        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);

            Location loc = new Location(
                obj.getString("airportId"),
                obj.getString("airportName"),
                obj.getString("airportCity"),
                obj.getString("airportCountry"),
                obj.getDouble("airportLatitude"),
                obj.getDouble("airportLongitude")
            );

            Response<Location> validation = LocationValidator.validate(loc, storage, false);
            if (validation != null && validation.getStatus() != Status.OK) {
                continue;
            }
            storage.addItem(loc);
        }
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }
}
    private void loadFlights() {
    try (FileReader reader = new FileReader("json/flights.json")) {
        JSONArray array = new JSONArray(new JSONTokener(reader));

        for (int i = 0; i < array.length(); i++) {
            JSONObject f = array.getJSONObject(i);

            Plane plane = PlaneStorage.getInstance().findById(f.getString("plane"));
            Location dep = LocationStorage.getInstance().findById(f.getString("departureLocation"));
            Location arr = LocationStorage.getInstance().findById(f.getString("arrivalLocation"));
            Location scale = f.isNull("scaleLocation") ? null : LocationStorage.getInstance().findById(f.getString("scaleLocation"));

            Response<Flight> parsed = FlightParser.parse(
                f.getString("id"), plane, dep, scale, arr,
                f.getString("departureDate"),
                String.valueOf(f.getInt("hoursDurationArrival")),
                String.valueOf(f.getInt("minutesDurationArrival")),
                String.valueOf(f.getInt("hoursDurationScale")),
                String.valueOf(f.getInt("minutesDurationScale"))
            );

            if (parsed.getStatus() == Status.OK) {
                Flight flight = parsed.getData();

                // Vincular vuelo al avión
                plane.addFlight(flight); 

                FlightStorage.getInstance().addItem(flight);
            } 
        }

    } catch (Exception e) {
        System.err.println(e.getMessage());
    }
}
        public void loadAllData()  {
        loadLocations();
        loadPlanes();
        loadPassengers();
        loadFlights();
    }
     

}

