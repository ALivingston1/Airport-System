public class Aircraft {
    private String[] aircraftInfo = new String[3];
    private FlightInfo flightInfo;

    public Aircraft () {
        setFlightInfo();
    }

    private void setFlightInfo () {
        this.flightInfo = new FlightInfo();

        aircraftInfo[0] = flightInfo.getAirline();
        aircraftInfo[1] = flightInfo.getArrAirport();
        aircraftInfo[2] =  flightInfo.getDepAirport();
    }

    public String[] getFlightInfo () {
        return aircraftInfo;
    }
}