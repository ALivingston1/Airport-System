import java.util.Random;

/**
 * This class will randomize a flight's information.
 * It will set Airline, dep/arr airports, tail number,
 * flight number, and dep/arr times.
 */
public class FlightInfo {

    /*
    Sets up all of the arrays needed for the
    airline name, airport name.
     */
    private String[] airlineList = {"Spirit", "American", "United", "SouthWest"};
    private String[] airportList = {"ATL", "LAX", "ORD", "DFW", "DEN", "JFK", "SFO", "SEA", "LAS", "MCO", "EWR", "CLT", "PHX", "IAH", "MIA", "BOS", "MSP", "FLL", "DTW", "PHL", "LGA", "BWI", "SLC", "SAN", "IAD", "DCA", "MDW", "TPA", "PDX", "HNL"};
    String[] flightInfo = new String[3];

    /*
    Variables to store the aircraft's airline and
    departure/arrival airport.
     */
    private static String airline;
    private static String depAirport;
    private static String arrAirport;

    /*
    Initializes length and random.
     */
    int len;
    Random rand = new Random();

    /**
     *      Constructor
     * Sets up the flight info.
     * Sets airline, dep/arr airports.
     */
    public FlightInfo() {
        setAirline();
        flightInfo[0] = "Airline: " + getAirline();

        setDepAirport();
        flightInfo[1] = "Departure Airport: " + getDepAirport();

        setArrAirport();
        flightInfo[2] = "Arrival Airport: " + getArrAirport();
    }

    /**
     * Getters and setters for the FlightInfo object.
     */

    /**
     * Overrides the randomized flight info and
     * allows for custom input.
     * @param airline Takes custom String for airline.
     * @param depAirport Takes custom String for departure airport.
     * @param arrAirport Takes custom String for arrival airport.
     */
    public void setFlightInfo(String airline, String depAirport, String arrAirport) {
        this.airline = airline;

        this.depAirport = depAirport;

        this.arrAirport = arrAirport;
    }

    /*
    Gets all flight info for the flight.
     */
    public String[] getFlightInfo () {
        return flightInfo;
    }

    /**
     * Getters and setters for airline name
     */
    private void setAirline() {
        len = this.airlineList.length;
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
        len = this.airportList.length;
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
        len = this.airlineList.length;
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