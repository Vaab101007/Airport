/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport.models.flights;

import airport.models.Location;
import airport.models.PlaneModel;
import airport.models.Prototype;
import airport.models.persons.PassengerModel;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author edangulo
 */
public class Flight implements Prototype<Flight> {

    private final String id;
    private ArrayList<PassengerModel> passengers;
    private PlaneModel plane;
    private Location departureLocation;
    private Location scaleLocation;
    private Location arrivalLocation;
    private LocalDateTime departureDate;
    private int hoursDurationArrival;
    private int minutesDurationArrival;
    private int hoursDurationScale;
    private int minutesDurationScale;

    public Flight(String id, PlaneModel plane, Location departureLocation, Location arrivalLocation, LocalDateTime departureDate, int hoursDurationArrival, int minutesDurationArrival) {
        this.id = id;
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.hoursDurationArrival = hoursDurationArrival;
        this.minutesDurationArrival = minutesDurationArrival;

    
    }

    public Flight(String id, PlaneModel plane, Location departureLocation, Location scaleLocation, Location arrivalLocation, LocalDateTime departureDate, int hoursDurationArrival, int minutesDurationArrival, int hoursDurationScale, int minutesDurationScale) {
        this.id = id;
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.departureLocation = departureLocation;
        this.scaleLocation = scaleLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.hoursDurationArrival = hoursDurationArrival;
        this.minutesDurationArrival = minutesDurationArrival;
        this.hoursDurationScale = hoursDurationScale;
        this.minutesDurationScale = minutesDurationScale;

        this.plane.addFlight(this);
    }

    public void addPassenger(PassengerModel passenger) {
        this.passengers.add(passenger);
    }

    public String getId() {
        return id;
    }

    public Location getDepartureLocation() {
        return departureLocation;
    }

    public Location getScaleLocation() {
        return scaleLocation;
    }

    public Location getArrivalLocation() {
        return arrivalLocation;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public int getHoursDurationArrival() {
        return hoursDurationArrival;
    }

    public int getMinutesDurationArrival() {
        return minutesDurationArrival;
    }

    public int getHoursDurationScale() {
        return hoursDurationScale;
    }

    public int getMinutesDurationScale() {
        return minutesDurationScale;
    }

    public PlaneModel getPlane() {
        return plane;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime calculateArrivalDate() {
        return departureDate.plusHours(hoursDurationScale).plusHours(hoursDurationArrival).plusMinutes(minutesDurationScale).plusMinutes(minutesDurationArrival);
    }

    public void delay(int hours, int minutes) {
        this.departureDate = this.departureDate.plusHours(hours).plusMinutes(minutes);
    }

    public int getNumPassengers() {
        return passengers.size();
    }

    @Override
    public Flight clone() {
        Flight copy;

        if (scaleLocation == null) {
            copy = new Flight(id, plane, departureLocation, arrivalLocation, departureDate, hoursDurationArrival, minutesDurationArrival);
        } else {
            copy = new Flight(id, plane, departureLocation, scaleLocation, arrivalLocation, departureDate, hoursDurationArrival, minutesDurationArrival, hoursDurationScale, minutesDurationScale);
        }

        copy.passengers = new ArrayList<>(passengers); // copia superficial
        return copy;
    }

}
