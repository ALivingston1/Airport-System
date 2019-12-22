import java.util.Random;

/**
 * This class will randomize a flight's information.
 * It will set Airline, dep/arr airports, tail number,
 * flight number, and dep/arr times.
 */
public class FlightInfo extends Display {

    /*
    Sets up all of the arrays needed for the
    airline name, airport name.
     */
    private String[] airlineList = {"Spirit", "American", "United", "SouthWest"};
    private String[] airportList = Airport.airportList;

    /*
    Variables to store the aircraft's airline and
    departure/arrival airport.
     */
    private static String airline;
    private static String depAirport;
    private static String arrAirport;

    public String[] flightInfo = new String[3];

    /*
    Define length and random.
     */
    private int len;
    private Random rand = new Random();

    /**
     * Constructors for FlightInfo class.
     * Sets up the flight info.
     * Sets airline, dep/arr airports.
     */
    public FlightInfo(String depAirport) {
        setAirline();
        flightInfo[0] = "Airline: " + getAirline();

        setDepAirport(depAirport);
        flightInfo[1] = "Departure Airport: " + getDepAirport();

        setArrAirport();
        flightInfo[2] = "Arrival Airport: " + getArrAirport();
    }

    /**
     * Overrides the randomized flight info and
     * allows for custom input.
     *
     * @param airline    Takes custom String for airline.
     * @param depAirport Takes custom String for departure airport.
     * @param arrAirport Takes custom String for arrival airport.
     */
    public FlightInfo(String airline, String depAirport, String arrAirport) {
        this.airline = airline;
        flightInfo[0] = "Airline: " + getAirline();

        this.depAirport = depAirport;
        flightInfo[1] = "Departure Airport: " + getDepAirport();


        this.arrAirport = arrAirport;
        flightInfo[2] = "Arrival Airport: " + getArrAirport();
    }


    /**
     * Getters and setters for the FlightInfo object.
     */

    /*
    Gets all flight info for the flight.
     */
    public String[] getFlightInfo() {
        return flightInfo;
    }

    /**
     * Getters and setters for airline name
     */
    private void setAirline() {
        this.len = this.airlineList.length;
        this.airline = airlineList[rand.nextInt(len)];
    }

    /*
    Overrides the default setAirline() method.
     */
    private void setAirline(String airline) {
        this.airline = airline;
    }

    /*
    Gets the airline name.
     */
    public String getAirline() {
        return airline;
    }


    /**
     * Getters and setters for departure airport
     */

    private void setDepAirport() {
        this.len = this.airportList.length;
        this.depAirport = airportList[rand.nextInt(len)];
    }

    /*
    Overrides the default setDepAirport() method.
     */
    private void setDepAirport(String depAirport) {
        this.depAirport = depAirport;
    }

    public String getDepAirport() {
        return depAirport;
    }


    /**
     * Getters and setters for arrival airport
     */

    private void setArrAirport() {
        this.len = this.airlineList.length;
        this.arrAirport = airportList[rand.nextInt(len)];

        /*
        Checks if the randomized arrival airport is set to the same as the departure airport.
        If they are the same, randomize it again until it's not the same.
         */
        while (this.arrAirport == getDepAirport()) {
            this.arrAirport = airportList[rand.nextInt(len)];
        }
    }

    /*
    Overrides the default setArrAirport() method.
     */
    private void setArrAirport(String arrAirport) {
        this.arrAirport = arrAirport;
    }

    public String getArrAirport() {
        return arrAirport;
    }
}