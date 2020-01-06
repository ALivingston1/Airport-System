import java.util.*;

public class Display {
    public static String[] options = {"ADD", "DELETE", "VIEW", "EXIT"};
    public static String[] objectType = {"AIRPORT", "AIRCRAFT", "PASSENGER"};
    protected static String displayBox;

    private Random rand = new Random();

    static Airport foundAirport;
    static Aircraft foundFlight;


    //Print methods
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
     * Displays the option menu and asks what
     * the user would like to do.
     */
    public static void optionMenu (Scanner input) {
        printAirports();
        boolean running = true;

        while (running) {
            Display.printArray(options);

            String option = input.next();

//            options = {"BACK", "ADD", "DELETE", "EXIT"};

            if (option.equalsIgnoreCase(Display.options[0])) {    //Add
//                clearPage();
                addObject(input);

            } else if (option.equalsIgnoreCase(Display.options[1])) {    //Delete
//                clearPage();

            } else if (option.equalsIgnoreCase(Display.options[2])) {   //VIEW
//                clearPage();
                viewObject(input);
            } else if (option.equalsIgnoreCase(Display.options[3])) {   //EXIT
                System.out.println("Exiting...");
                running = false;
            } else {
                System.out.println("Error: Not a valid response. Try again.");
                continue;
            }
        }
    }


    //Add an Object
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

            for (int i = 0; i < (Main.airportList.toArray().length); i++) {
                System.out.print(Main.airportList.get(i).getAirportName());
                if (i < Main.airportList.size() - 1) {
                    System.out.print(", ");
                }
            }

            System.out.print("\n");
            airport = input.next();

            for (int i = 0; i < Main.airportList.toArray().length; i++) {
                if (airport.equalsIgnoreCase(Main.airportList.get(i).getAirportName())) {
                /*
                Create Aircraft
                 */
                    System.out.println("Enter Information: AIRLINE, ARRIVAL AIRPORT, and CAPACITY");
                    String x = input.next();
                    String y = input.next();
                    int z = input.nextInt();
                    boolean creating = true;

                    while (creating) {
                        if (x instanceof String) {  //If airport name is string
                            if (y instanceof String) {    //If capacity is an integer (string)
                                Main.airportList.get(i).createAircraft(x, Main.airportList.get(i).getAirportName(), y, z);
                                i = Main.airportList.toArray().length;
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
        System.out.println("\nAircraft Created.");
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
                    foundAirport.printAircraftList();
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

    /**
     * Adds an Aiport, Aircraft, or Passenger Object
     * @param input Scanner
     */
    public static void addObject (Scanner input) {
        boolean adding = true;

        while (adding) {
            System.out.println("Add what?\n");
            Display.printArray(objectType);
            System.out.println();
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


    //View an object
    /**
     * Displays airport information from airport
     * @param input
     */
    public static void viewAirport (Scanner input) {
        System.out.println("\nWhich airport?:");
        Main.printAirportList();
        String x = input.next();
        System.out.println();
        boolean found = false;

        for (int i = 0; i < Main.airportList.size(); i++) {
            if (x.equalsIgnoreCase(Main.airportList.get(i).getAirportName())) {  //If user input is equal to the name of an existing airport
                setDisplayBox("Airport: " + Main.airportList.get(i).getAirportName(), Main.airportList.get(i).getAirportInfo());
                printDisplayBox();
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("Airport not found.");
        }
    }

    /**
     * Displays flight information from aircraft
     * @param input Scanner
     */
    public static void viewAircraft (Scanner input) {
        boolean airportFound = false;
        boolean flightFound = false;

        while (airportFound == false) {
            int i = 0;
            System.out.println("\nAircraft at which airport?:");
            Main.printAirportList();
            String x = input.next();
            System.out.println();
            if (x.equalsIgnoreCase(Main.airportList.get(i).getAirportName())) {  //If user input is equal to the name of an existing airport
                foundAirport = Main.airportList.get(i);
                i++;
                airportFound = true;
            }
        }

        if (airportFound == true) {
            while (flightFound == false) {
                System.out.println("Which flight?: ");
                foundAirport.printAircraftList();
                int y = input.nextInt();
                System.out.println();
                if (y == (foundAirport.aircraftList.get(y-1).getFlightNumber())) {
                    foundFlight = foundAirport.aircraftList.get(y-1);
                    flightFound = true;
                    continue;
                }
            }
        }
        if (airportFound == true && flightFound == true) {
            setDisplayBox("Flight Number " + (foundFlight.flightNumber), foundFlight.getFlightInfo());
            printDisplayBox();
        }
    }

    /**
     * Displays passenger information
     * @param input Scanner
     */
    public static void viewPassengers (Scanner input) {
        boolean airportFound = false;
        boolean flightFound = false;

        while (airportFound == false) {
            int i = 0;
            System.out.println("\nAircraft at which airport?:");
            Main.printAirportList();
            String x = input.next();
            System.out.println();
            if (x.equalsIgnoreCase(Main.airportList.get(i).getAirportName())) {  //If user input is equal to the name of an existing airport
                foundAirport = Main.airportList.get(i);
                i++;
                airportFound = true;
            }
        }

        if (airportFound == true) {
            while (flightFound == false) {
                System.out.println("Which flight?: ");
                foundAirport.printAircraftList();
                int y = input.nextInt();
                System.out.println();
                if (y == (foundAirport.aircraftList.get(y-1).getFlightNumber())) {
                    foundFlight = foundAirport.aircraftList.get(y-1);
                    flightFound = true;
                    continue;
                }
            }
        }
        if (airportFound == true && flightFound == true) {
            for (int i = 0; i < foundFlight.generatedPassengers-1; i++) {
                setDisplayBox("Passenger " + (i+1), foundFlight.passengerList.get(i).passengerInfo);
                printDisplayBox();
            }
        }
    }

    /**
     * View an Airport, Aircraft, or Passenger's info
     * @param input Scanner
     */
    public static void viewObject (Scanner input) {
        boolean viewing = true;

        while (viewing) {
            System.out.println("\nView what?");
            Display.printArray(objectType);
            String add = input.next();

            if (add.equalsIgnoreCase(objectType[0])) {  //Airport
                viewAirport(input);
                viewing = false;
            } else if (add.equalsIgnoreCase(objectType[1])) {   //Aircraft
                viewAircraft(input);
                viewing = false;
            } else if (add.equalsIgnoreCase(objectType[2])) {   //Passenger
                viewPassengers(input);
                viewing = false;
            } else {
                System.out.println("Error: Not a valid response. Try again.");
                continue;
            }
        }
    }


    //Display Box
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
     * Prints to information box to console
     */
    public static void printDisplayBox () {
        System.out.print(displayBox);
    }
}