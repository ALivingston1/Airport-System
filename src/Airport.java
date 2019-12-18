public class Airport {
    String portName;
    int capacity;
    int numOPlanes;
    private String[] airportList = {"ATL", "LAX", "ORD", "DFW", "DEN", "JFK", "SFO", "SEA", "LAS", "MCO", "EWR", "CLT", "PHX", "IAH", "MIA", "BOS", "MSP", "FLL", "DTW", "PHL", "LGA", "BWI", "SLC", "SAN", "IAD", "DCA", "MDW", "TPA", "PDX", "HNL"};






    public Airport(int airportName, int capacity, int numOPlanes){
        setAirportName(airportName);
        setCapacity(capacity);
        setNumOPlanes(numOPlanes);
        if(numOPlanes == capacity ){
            System.out.println("You have reached maximum capacity, you can have no more planes at this airport");
        }
        if(numOPlanes > capacity){
            System.out.println("You have to many planes");
        }
    }

    private void setAirportName(int airportName){
        portName = airportList[airportName];
    }

    private void setCapacity(int capacity){
        this.capacity=capacity;
    }

    private void setNumOPlanes(int numOPlanes){
        this.numOPlanes=numOPlanes;
    }

    public String getPortName(){
        return portName;
    }
    public int getCapacity(){
        return capacity;
    }
    public int getNumOPlanes(){
        return numOPlanes;
    }




}
