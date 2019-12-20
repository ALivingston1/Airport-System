import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Airport extends Display {
    public static String[] airportList = {"ATL", "LAX", "ORD", "DFW", "DEN", "JFK", "SFO", "SEA", "LAS", "MCO", "EWR", "CLT", "PHX", "IAH", "MIA", "BOS", "MSP", "FLL", "DTW", "PHL", "LGA", "BWI", "SLC", "SAN", "IAD", "DCA", "MDW", "TPA", "PDX", "HNL"};
    private List<Aircraft> aircraftList = new ArrayList<Aircraft>();
    private String[] airportInfo = new String[4];
    private int capacity;

    /*
    Define data regarding airport name
     */
    private String name;
    private Random rand = new Random();
    private int len;

    /**
     * Constructors for Airport class.
     * Creates a new airport with 0 aircraft.
     */
    public Airport () {
        setAirportName();
        setCapacity();

        /*
        Create a random number of aircraft within the capacity of the airport
         */
        for (int i = 0; i < rand.nextInt(capacity); i++) {
            createAircraft();
        }

        /*
        Sets up the flight info
         */
        airportInfo[0] = "Airport Identifier: " + name;
        airportInfo[1] = "Aircraft Capacity: " + capacity;
        airportInfo[2] = "Departures: " + getNumAircraft();
        airportInfo[3] = "Arrivals: " + "WIP";
    }

    /**
    Custom constructor for custom airport
     */
    public Airport (String name, int capacity) {
        setAirportName(name);
        setCapacity(capacity);

        /*
        Sets up the flight info
         */
        airportInfo[0] = "Airport Identifier: " + name;
        airportInfo[1] = "Aircraft Capacity: " + capacity;
        airportInfo[2] = "Departures: " + getNumAircraft();
        airportInfo[3] = "Arrivals: " + "WIP";
    }


    /**
     * Setters and getters for airport name
     */

    /**
    Sets the airport name randomly
     */
    private void setAirportName(){
        this.len = airportList.length;
        this.name = airportList[rand.nextInt(len)];
    }

    /**
    Sets custom airport name
     */
    private void setAirportName(String airportName){
        this.name = airportName;
    }

    /**
     * Gets the airport name
     * @return String Airport's name
     */
    public String getAirportName() {
        return name;
    }


    /**
     * Setters and getters for airport capacity.
     */

    /**
    Set capacity at airport.
     */
    private void setCapacity () {
        this.capacity = rand.nextInt(2500);
    }

    /**
    Allows for custom capacity
     */
    private void setCapacity (int capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets capacity at airport
     * @return int capacity
     */
    public int getCapacity () {
        return capacity;
    }

    /**
     * Gets the number of aircraft at the airport
     * @return int Aircraft at current airport
     */
    public int getNumAircraft () {
        return aircraftList.size();
    }

    /**
     * Gets the airport info array
     * @return String[] Airport information
     */
    public String[] getAirportInfo () {
        return this.airportInfo;
    }

    /**
     * Creates an aircraft with departure airport set to the airport's name.
     */
    public void createAircraft () {
        Aircraft aircraft = new Aircraft(name);
        this.aircraftList.add(aircraft);
    }

    /**
     * Creates a custom aircraft.
     */
    public void createAircraft (String airline, String depAirport, String arrAirport) {
        Aircraft aircraft = new Aircraft(airline, depAirport, arrAirport);
        this.aircraftList.add(aircraft);
    }

    /**
     * Gets list of aircraft in airport
     * @return List<Aircraft> aircraftList
     */
    public List<Aircraft> getAircraftList () {
        return this.aircraftList;
    }
}
