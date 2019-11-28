public class Aircraft {
    public String[] flightInfo = new String[3];

    public Aircraft () {
        setFlightInfo();
    }

    public void setFlightInfo () {
        FlightInfo flightInfo = new FlightInfo();

        this.flightInfo[0] = flightInfo.getAirline();
        this.flightInfo[1] = flightInfo.getDepAirport();
        this.flightInfo[2] = flightInfo.getArrAirport();
    }

    public String[] getFlightInfo () {
        return flightInfo;
    }
}
