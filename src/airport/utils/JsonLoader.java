/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.utils;

import airport.controllers.PassengerController;
import airport.controllers.PlaneController;
import airport.controllers.utils.PassengerValidator;
import airport.controllers.utils.Response;
import airport.controllers.utils.Status;
import airport.models.Passenger;
import airport.models.Plane;
import airport.models.storage.PassengerStorage;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
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
                    System.err.println("❌ Error pasajero ID " + p.getId() + ": " + validation.getMessage());
                    continue;
                }

                storage.addItem(p);
                System.out.println("✅ Pasajero registrado: " + p.getFirstname() + " " + p.getLastname());
            }

            System.out.println("\n🎉 Carga de pasajeros finalizada con éxito.");
        } catch (Exception e) {
            System.err.println("❌ Error general al cargar pasajeros: " + e.getMessage());
        }
    }
     
     

}

