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
    private String[] airlineList = {"Spirit", "American"};
    private String[] airportList = {"ATL", "LAX", "ORD", "DFW", "DEN", "JFK", "SFO", "SEA", "LAS", "MCO", "EWR", "CLT", "PHX", "IAH", "MIA", "BOS", "MSP", "FLL", "DTW", "PHL", "LGA", "BWI", "SLC", "SAN", "IAD", "DCA", "MDW", "TPA", "PDX", "HNL"};

    /*
    Variables to store the aircraft's airline and
    departure/arrival airport.
     */
    private String airline;
    private String depAirport;
    private String arrAirport;
    private String tailNum;
    private String flightNum;
    private String depTime;
    private String arrTime;

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
        setDepAirport();
        setArrAirport();
    }

    /**
     * Overrides the randomized flight info and
     * allows for custom input.
     * @param airline Takes custom String for airline.
     * @param depAirport Takes custom String for departure airport.
     * @param arrAirport Takes custom String for arrival airport.
     */
    public FlightInfo(String airline, String depAirport, String arrAirport) {
        this.airline = airline;
        this.arrAirport = arrAirport;
        this.depAirport = depAirport;
    }

    /**
     * Getters and setters for the FlightInfo object.
     */

    /*
    Gets the airline name of the flight
     */
    public String getAirline() {
        return airline;
    }

    /*
    Sets the airline name of the flight
     */
    private void setAirline() {
        len = this.airlineList.length;
        this.airline = airlineList[rand.nextInt(len)];
    }

    private void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDepAirport() {
        return depAirport;
    }

    private void setDepAirport() {
        len = this.airportList.length;
        this.depAirport = airportList[rand.nextInt(len)];
    }

    private void setDepAirport(String depAirport) {
        this.depAirport = depAirport;
    }

    public String getArrAirport() {
        return arrAirport;
    }

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

    private void setArrAirport(String arrAirport) {
        this.arrAirport = arrAirport;
    }
}