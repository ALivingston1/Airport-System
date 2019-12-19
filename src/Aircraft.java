import java.util.ArrayList;
import java.util.List;

public class Aircraft {
    private String[] aircraftInfo = new String[3];

    /*
    Defines aircraft data
     */
    private FlightInfo flightInfo;

    /*
    Defines passenger data
     */
    private Passenger passengerInfo;
    private static List<Passenger> passengerList = new ArrayList<Passenger>();

    /**
     * Constructor for Aircraft class.
     * Creates an aircraft with flight info
     * and passenger info.
     * @param depAirport Departure airport
     */
    public Aircraft (String depAirport) {
        setFlightInfo(depAirport);
        aircraftInfo[0] = "Flight Information: " + getFlightInfo();

        setPassengerInfo();
        aircraftInfo[1] = "Passenger Info: " + getPassengerInfo();
    }

    /**
     * Creates custom aircraft to put on airport
     * @param airline Airline
     * @param depAirport Departure Airport
     * @param arrAirport Arrival Airport
     */
    public Aircraft (String airline, String depAirport, String arrAirport) {
        setFlightInfo(airline, depAirport, arrAirport);
        aircraftInfo[0] = "Flight Information: " + getFlightInfo();

        setPassengerInfo();
        aircraftInfo[1] = "Passenger Info: " + getPassengerInfo();
    }


    /**
     * Getters and setters for flight info
     */

    private void setFlightInfo (String depAirport) {
        this.flightInfo = new FlightInfo(depAirport);
    }

    /*
    Override flight information.
     */
    public void setFlightInfo (String airline, String depAirport, String arrAirport) {
        this.flightInfo = new FlightInfo(airline, depAirport, arrAirport);
    }

    public String[] getFlightInfo () {
        return flightInfo.getFlightInfo();
    }

    /**
     * Getters and setters for passenger info.
     */
    private void setPassengerInfo () {
        this.passengerInfo = new Passenger();
    }

    /*
    Override setPassengerInfo.
    */
    public void setPassengerInfo (String name, String seatType, String numOfLuggage) {
        this.passengerInfo = new Passenger(name, seatType, numOfLuggage);
    }

    public String[] getPassengerInfo () {
        return this.passengerInfo.passengerInfo;
    }

    /**
     * Creates a passenger in the aircraft.
     */
    public void createPassenger () {
        Passenger passenger = new Passenger();
        this.passengerList.add(passenger);
    }

    /**
     * Creates a passenger with custom values in the aircraft.
     */
    public void createPassenger (String name, String seatType, String numOfLuggage) {
        Passenger passenger = new Passenger(name, seatType, numOfLuggage);
        this.passengerList.add(passenger);
    }

    /**
     * Gets list of passengers on the aircraft
     * @return List<Passenger> passengerList
     */
    public static List<Passenger> getPassengerList () {
        return passengerList;
    }
}