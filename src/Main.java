import java.util.*;

public class Main {

    public static List<Airport> airportList = new ArrayList<Airport>();

    /**
     * Creates an Airport object
     */
    public static void createAirport () {
        Airport airport = new Airport();
        airportList.add(airport);
    }

    /**
     * Creates an Airport object with certain parameters
     * @param name Airport Name
     * @param capacity Aircraft capacity of airport.
     */
    public static void createAirport (String name, int capacity) {
        Airport airport = new Airport(name, capacity);
        airportList.add(airport);
    }

    /**
     * Creates 30 Airports
     */
    public static void setupAirports () {
        for (int i = 0; i < 30; i++) {
            createAirport();
        }
    }

    /**
     * Prints the name of each airport in the list
     */
    public static void printAirportList () {
        for (int i = 0; i < airportList.size(); i++) {
            System.out.print(airportList.get(i).getAirportName());
            if (i < airportList.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        setupAirports();
        Display.optionMenu(input);
    }
}