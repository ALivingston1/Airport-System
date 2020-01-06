import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aircraft {
    private String[] aircraftInfo = new String[3];
    private Random rand = new Random();

    /*
        Defines aircraft data
         */
    public int flightNumber;
    private FlightInfo flightInfo;

    /*
    Defines passenger data
     */
    private Passenger passengerInfo;
    public int passengerCapacity;
    public int generatedPassengers;
    public int passengerNum = 1;
    public List<Passenger> passengerList = new ArrayList<Passenger>();

    /**
     * Constructor for Aircraft class.
     * Creates an aircraft with flight info
     * and passenger info.
     * @param depAirport Departure airport
     */
    public Aircraft (String depAirport, int flightNumber) {
        setPassengerCapacity();
        generatedPassengers = rand.nextInt(passengerCapacity);
        setFlightInfo(depAirport);

        /*
        Create a random number of aircraft within the capacity of the airport
         */
        setFlightNumber(flightNumber);
        for (int i = 1; i < generatedPassengers; i++) {
            createPassenger();
        }
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
    public Aircraft (int flightNumber, String airline, String depAirport, String arrAirport, int passengerCapacity) {
        setPassengerCapacity(passengerCapacity);
        generatedPassengers = rand.nextInt(passengerCapacity);
        setFlightNumber(flightNumber);
        setFlightInfo(airline, depAirport, arrAirport);

        aircraftInfo[0] = "Flight Information: " + getFlightInfo();

        setPassengerInfo();
        aircraftInfo[1] = "Passenger Info: " + getPassengerInfo();
    }


    /**
     * Getters and setters for passengers
     */
    /**
     Set capacity at airport.
     */
    private void setPassengerCapacity () {
        boolean pos = false;
        while (!pos) {
            int num = rand.nextInt(300);
            if (num != 0) {
                this.passengerCapacity = num;
                break;
            }
        }
    }

    /**
     Allows for custom capacity
     */
    private void setPassengerCapacity (int capacity) {
        this.passengerCapacity = capacity;
    }

    private void setFlightInfo (String depAirport) {
        flightInfo = new FlightInfo(depAirport);
    }

    /*
    Override flight information.
     */
    public void setFlightInfo (String airline, String depAirport, String arrAirport) {
        flightInfo = new FlightInfo(airline, depAirport, arrAirport);
    }

    public String[] getFlightInfo () {
        return flightInfo.getFlightInfo();
    }

    /**
     * Sets flight number for aircraft.
     * @param flightNumber Flight number
     */
    public void setFlightNumber (int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getFlightNumber () {
        return flightNumber;
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
        passengerNum++;
    }

    /**
     * Creates a passenger with custom values in the aircraft.
     */
    public void createPassenger (String name, String seatType, String numOfLuggage) {
        Passenger passenger = new Passenger(name, seatType, numOfLuggage);
        this.passengerList.add(passenger);
        passengerNum++;
    }

    /**
     * Gets list of passengers on the aircraft
     * @return List<Passenger> passengerList
     */
    public List<Passenger> getPassengerList () {
        return passengerList;
    }
}