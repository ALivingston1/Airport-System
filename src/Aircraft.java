import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Aircraft {
    public String[] aircraftInfo = new String[3];
    private FlightInfo flightInfo;
    private Passenger passengerInfo;

    public Aircraft () {
        setFlightInfo();
        setPassengerInfo();
    }


    /**
     * Getters and setters for flight info
     */

    private void setFlightInfo () {
        this.flightInfo = new FlightInfo();
    }

    /*
    Override flight information.
     */
    private void setFlightInfo (String airline, String depAirport, String arrAirport) {
        this.flightInfo = new FlightInfo(airline, depAirport, arrAirport);
    }

    public String[] getFlightInfo () {
        return flightInfo.getFlightInfo();
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
    private void setPassengerInfo (String name, String seatType, String numOfLuggage) {
        this.passengerInfo = new Passenger(name, seatType, numOfLuggage);
    }

    public String[] getPassengerInfo () {
        return this.passengerInfo.passengerInfo;
    }
}