import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Aircraft {
    public String[] aircraftInfo = new String[3];
    public FlightInfo flightInfo;

    public Aircraft () {
        setFlightInfo();
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
        this.flightInfo.setFlightInfo(airline, depAirport, arrAirport);
    }

    public String[] getFlightInfo () {
        return flightInfo.getFlightInfo();
    }

    private void setPassengerInfo () {
//        Passenger passenger = new Passenger();
    }
}