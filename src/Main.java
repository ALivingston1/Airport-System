import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static List<Airport> airportList = new ArrayList<Airport>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        setupAirports();

        Display.printAirports();
        Display.optionMenu(input);
    }

    /**
     * Creates a random amount of airports within bounds of 100
     */
    public static void setupAirports () {
        for (int i = 0; i < 30; i++) {
            createAirport();
        }
    }

    public static void createAirport () {
        Airport airport = new Airport();
        airportList.add(airport);
    }

    public static void createAirport (String name, int capacity) {
        Airport airport = new Airport(name, capacity);
        airportList.add(airport);
    }

    public static List<Airport> getAirportList() {
        return airportList;
    }
}