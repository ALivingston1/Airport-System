import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Display {
    public static String[] options = {"BACK", "ADD", "DELETE", "VIEW", "EXIT"};
    public static String[] objectType = {"AIRPORT", "AIRCRAFT", "PASSENGER"};
    private static String displayBox;

    private Random rand = new Random();

    /**
     * Prints the list of airports
     */
    public static void printAirports () {
        System.out.print("Active Airports: ");

        for (int i = 0; i < Airport.airportList.length; i++) {
            System.out.print(Airport.airportList[i]);
            if (i < Airport.airportList.length-1) {
                System.out.print(", ");
            }
        }
        System.out.print("\n");
        System.out.print("Total: " + " " + Main.airportList.size() + "\n\n");
    }

    /**
     * Prints to information box to console
     */
    public static void printInfoBox () {
        System.out.println(displayBox);
    }

    /**
     * Prints Array
     */
    public static void printArray (String[] Array) {
        for (int i = 0; i < Array.length; i++) {
            System.out.print(Array[i]);
            if (i < Array.length-1) {
                System.out.print(", ");
            }
        }
        System.out.print("\n");
    }

    /**
     * Clears the console
     */
    public static void clearPage(){
        System.out.println("\n".repeat(100));
    }

    /**
     * This will display any array you put into it.
     * @param information Array being displayed
     * @param title Title of display
     * @return String displayBox
     */
    public static void setDisplayBox (String title, String[] information) {
        int maxLen = getLen(information);

        /*
        Header section of displayBox
         */
        displayBox = ("-".repeat(maxLen+4) + "\n")
                + ("|" + " ".repeat(((maxLen + 3) - title.length()) / 2) + title + " ".repeat(((maxLen + 2) - title.length()) / 2) + "|\n")
                + ("-".repeat(maxLen + 4) + "\n");

        /*
        Body
         */
        for (int i = 0; i < information.length; i++) { //For every row in the box
            displayBox = displayBox + (("|" + " ".repeat(((maxLen + 3) - information[i].length()) / 2))
                    + (information[i])
                    + (" ".repeat(((maxLen + 2) - information[i].length()) / 2) + "|") + "\n");
        }
        displayBox = displayBox + ("-".repeat(maxLen + 4) + "\n");
    }

    /**
     * Gets displaybox
     * @return String displaybox
     */
    public String getDisplayBox () {
        return this.displayBox;
    }

    /**
     * Gets the length of the longest line in the String[]
     * @param information Array trying to get the longest
     * length from.
     * @return int maximum length
     */
    public static int getLen (String[] information) {
        int len = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (len < information[j].length()) {
                    len = information[j].length();
                }
            }
        }
        return len;
    }

    /**
     * OPTION MENU
     */
    public static void optionMenu (Scanner input) {
        boolean running = true;

        while (running) {
            Display.printArray(options);

            String option = input.next();

//            options = {"BACK", "ADD", "DELETE", "EXIT"};

            if (option.equalsIgnoreCase(Display.options[0])) {  //Back
//                clearPage();

            } else if (option.equalsIgnoreCase(Display.options[1])) {    //Add
//                clearPage();
                addObject(input);

            } else if (option.equalsIgnoreCase(Display.options[2])) {    //Delete
//                clearPage();

            } else if (option.equalsIgnoreCase(Display.options[3])) {   //VIEW
//                clearPage();
            } else if (option.equalsIgnoreCase(Display.options[4])) {   //EXIT
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Error: Not a valid response. Try again.");
                continue;
            }
        }
    }

    /**
     * Adds an Aiport, Aircraft, or Passenger Object
     * @param input Scanner
     */
    public static void addObject (Scanner input) {
        System.out.flush();
        boolean adding = true;

        while (adding) {
            System.out.println("Add what?\n");
            Display.printArray(objectType);
            String add = input.next();

            if (add.equalsIgnoreCase(objectType[0])) {  //Airport
                addAirport(input);
                adding = false;
            } else if (add.equalsIgnoreCase(objectType[1])) {   //Aircraft
                addAircraft(input);
                adding = false;
            } else if (add.equalsIgnoreCase(objectType[2])) {   //Passenger
                addPassenger(input);
                adding = false;
            } else {
                System.out.println("Error: Not a valid response. Try again.");
                continue;
            }
        }
    }

    /**
     * Asks user to add an airport
     * @param input Scanner
     */
    public static void addAirport (Scanner input) {
        System.out.println("\nEnter Information: AIRPORT NAME, AIRPORT CAPACITY");
        String x = input.next();
        Integer y = input.nextInt();
        boolean creating = true;

        while (creating) {
            if (x instanceof String) {  //If airport name is string
                if (y instanceof Integer) {    //If capacity is an integer (string)
                    Main.createAirport(x, y);
                    creating = false;
                } else {
                    System.out.println("Error: Not a valid response. Try again.");
                    continue;
                }
            } else {
                System.out.println("Error: Not a valid response. Try again.");
                continue;
            }
        }

        System.out.println("Created Airport.\n");
    }

    /**
     * Asks user to add an aircraft
     * @param input Scanner
     */
    public static void addAircraft (Scanner input) {
         /*
                Select airport to put aircraft on
                 */
        String airport;

        boolean selecting = true;
        while (selecting) {
            System.out.println("\nSelect the airport to add the aircraft");

            for (int i = 0; i < (Main.getAirportList().toArray().length); i++) {
                System.out.print(Main.airportList.get(i).getAirportName());
                if (i < Main.airportList.size() - 1) {
                    System.out.print(", ");
                }
            }

            System.out.print("\n");
            airport = input.next();

            for (int i = 0; i < Main.getAirportList().toArray().length; i++) {
                if (airport.equalsIgnoreCase(Main.airportList.get(i).getAirportName())) {
                /*
                Create Aircraft
                 */
                    System.out.println("Enter Information: AIRLINE, ARRIVAL AIRPORT");
                    String x = input.next();
                    String y = input.next();
                    boolean creating = true;

                    while (creating) {
                        if (x instanceof String) {  //If airport name is string
                            if (y instanceof String) {    //If capacity is an integer (string)
                                Main.airportList.get(i).createAircraft(x, Main.airportList.get(i).getAirportName(), y);
                                i = Main.getAirportList().toArray().length;
                                creating = false;
                            } else {
                                System.out.println("Error: Not a valid response. Try again.");
                            }
                        } else {
                            System.out.println("Error: Not a valid response. Try again.");
                        }
                    }
                    selecting = false;
                }
            }
        }
        System.out.println("Aircraft Created.");
    }

    /**
     * Asks user to add a passenger
     * @param input
     */
    public static void addPassenger (Scanner input) {
        /*
        Select aircraft to put passenger on
         */
        String airport;
        String aircraft;

        boolean selecting = true;
        while (selecting) {
            System.out.println("Select the airport to add the passenger (Use index of airport)");
            Display.printArray(Airport.airportList);
            airport = input.next();

            for (int i = 0; i < Main.airportList.size(); i++) {
                if (airport.equalsIgnoreCase(Main.airportList.get(i).getAirportName())) {
                    System.out.println("Select the aircraft to add the passenger (Use the index of the aircraft)");
                    System.out.println(Arrays.toString(Aircraft.getPassengerList().toArray()));
                    aircraft = input.next();

                /*
                Create Passenger
                 */
                    System.out.println("Enter Information: NAME, SEAT TYPE, AMOUNT OF LUGGAGE");
                    String x = input.next();
                    String y = input.next();
                    String z = input.next();
                    boolean creating = true;

                    while (creating) {
                        if (x instanceof String) {  //If airport name is string
                            if (y instanceof String) {    //If capacity is an integer (string)
                                if (z instanceof String) {

                                    i = Main.airportList.size();

                                    creating = false;
                                } else {
                                    System.out.println("Error Not a valid response. Try again.");
                                    continue;
                                }
                            } else {
                                System.out.println("Error: Not a valid response. Try again.");
                                continue;
                            }
                        } else {
                            System.out.println("Error: Not a valid response. Try again.");
                            continue;
                        }
                    }
                    selecting = false;
                } else {
                    System.out.println("Error: Not a valid response. Try again.");
                    continue;
                }
            }
        }
        System.out.println("Created Passenger.");
    }
}
