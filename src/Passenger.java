
public class Passenger {
  String name;
  String  seatType;
  int luggage;

  private String[] seatingType = {"First Class", "Coach", "Economy",};


  public Passenger(String name2, int seatType2, int luggage2) {
    setName(name2);
    setSeatType(seatType2);
    setLuggage(luggage2);
  }



  public String getName() {
    return name;
  }

  private void setName(String name1) {
    this.name= name1;
  }



  public String getSeatType(){
    return seatType;
  }

  int len;


  private void setSeatType(int seatIndex){
    len = this.seatingType.length;
    this.seatType = seatingType[seatIndex];
  }

  public int getLuggage() {
    return luggage;
  }
  private void setLuggage(int numOBags){
    luggage = numOBags;
  }


}
    
    
   