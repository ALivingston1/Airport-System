import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Display {
    public static String[] options = {"BACK", "ADD", "DELETE", "VIEW", "EXIT"};
    public static String[] objectType = {"AIRPORT", "AIRCRAFT", "PASSENGER"};
    private static String displayBox;

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
        System.out.print(" ".repeat(10) + "Total: " + " " + Airport.airportList.length + "\n");
    }

    /**
     * Prints to information box to console
     */
    public static void printInfoBox () {
        System.out.println(displayBox);
    }

    /**
     * Prints options bar
     */
    public static void printOptions () {
        System.out.println("What would you like to do?");
        for (int i = 0; i < options.length; i++) {
            System.out.print(options[i]);
            if (i < options.length-1) {
                System.out.print(", ");
            }
        }
        System.out.print("\n");
    }

    /**
     * Prints object type bar
     */
    public static void printObjectType (String option) {
        System.out.println(option + " what?");
        for (int i = 0; i < objectType.length; i++) {
            System.out.print(objectType[i]);
            if (i < objectType.length-1) {
                System.out.print(", ");
            }
        }
        System.out.print("\n");
    }

    /**
     * This will display any array you put into it.
     * @param information Array being displayed
     * @param title Title of display
     * @return String displayBox
     */
    public void setDisplayBox (String title, String[] information) {
        int maxLen = getLen(information);

        /*
        Header section of displayBox
         */
        this.displayBox = ("-".repeat(maxLen+4) + "\n")
                + ("|" + " ".repeat(((maxLen + 3) - title.length()) / 2) + title + " ".repeat(((maxLen + 2) - title.length()) / 2) + "|\n")
                + ("-".repeat(maxLen + 4) + "\n");

        /*
        Body
         */
        for (int i = 0; i < information.length; i++) { //For every row in the box
            this.displayBox = displayBox + (("|" + " ".repeat(((maxLen + 3) - information[i].length()) / 2))
                    + (information[i])
                    + (" ".repeat(((maxLen + 2) - information[i].length()) / 2) + "|") + "\n");
        }
        this.displayBox = displayBox + ("-".repeat(maxLen + 4) + "\n");
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
            Display.printOptions();

            String option = input.next();

//            options = {"BACK", "ADD", "DELETE", "EXIT"};

            if (option.equalsIgnoreCase(Display.options[0])) {  //Back
                System.out.flush();

            } else if (option.equalsIgnoreCase(Display.options[1])) {    //Add
                System.out.flush();
                addObject(input);

            } else if (option.equalsIgnoreCase(Display.options[2])) {    //Delete
                System.out.flush();

            } else if (option.equalsIgnoreCase(Display.options[3])) {   //VIEW
                System.out.flush();
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
            String[] objectType = {"AIRPORT", "AIRCRAFT", "PASSENGER"};
            Display.printObjectType("ADD");
            String add = input.next();

            if (add.equalsIgnoreCase(objectType[0])) {  //Airport
                System.out.println("Type: AIRPORT NAME, AIRPORT CAPACITY");
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

                System.out.println("Created Airport.");
                adding = false;
            } else if (add.equalsIgnoreCase(objectType[1])) {   //Aircraft
                /*
                Select airport to put aircraft on
                 */
                Integer airport;

                boolean selecting = true;
                while (selecting) {
                    System.out.println("Select the airport to add the passenger (Use index of airport)");
                    System.out.println(Arrays.toString(Main.getAirportList().toArray()));
                    airport = input.nextInt();

                    if (airport <= Main.getAirportList().size() & airport >= 0) {
                        /*
                        Create Passenger
                         */
                        System.out.println("Type: NAME, SEAT TYPE, AMOUNT OF LUGGAGE");
                        String x = input.next();
                        String y = input.next();
                        String z = input.next();
                        boolean creating = true;

                        while (creating) {
                            if (x instanceof String) {  //If airport name is string
                                if (y instanceof String) {    //If capacity is an integer (string)
                                    Main.getAirportList().get(airport).createAircraft(x, y, z);
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
                        selecting = false;
                    }
                }
                System.out.println("Aircraft Created.");
                adding = false;
            } else if (add.equalsIgnoreCase(objectType[2])) {   //Passenger
                /*
                Select aircraft to put passenger on
                 */
                Integer airport;
                Integer aircraft;

                boolean selecting = true;
                while (selecting) {
                    System.out.println("Select the airport to add the passenger (Use index of airport)");
                    System.out.println(Arrays.toString(Airport.airportList));
                    airport = input.nextInt();
                    if (airport <= Main.getAirportList().size() & airport >= 0) {
                        System.out.println("Select the aircraft to add the passenger (Use the index of the aircraft)");
                        System.out.println(Arrays.toString(Aircraft.getPassengerList().toArray()));
                        aircraft = input.nextInt();

                        /*
                        Create Passenger
                         */
                        System.out.println("Type: NAME, SEAT TYPE, AMOUNT OF LUGGAGE");
                        String x = input.next();
                        String y = input.next();
                        String z = input.next();
                        boolean creating = true;

                        while (creating) {
                            if (x instanceof String) {  //If airport name is string
                                if (y instanceof String) {    //If capacity is an integer (string)
                                    if (z instanceof String) {
                                        Main.getAirportList().get(airport).getAircraftList().get(aircraft).createPassenger(x, y, z);

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
                System.out.println("Created Passenger.");
                adding = false;
            } else {
                System.out.println("Error: Not a valid response. Try again.");
                continue;
            }
        }
    }
}
