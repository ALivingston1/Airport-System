import java.util.Random;

public class Passenger {
  private String name;
  private String seatType;
  private String luggage;
  private int len;
  private Random rand = new Random();
  public String[] passengerInfo = new String[3];


  private String[] names = {"Liam", "Noah", "William", "James", "Oliver", "Benjamin", "Elijah", "Lucas", "Mason", "Logan", "Alexander", "Ethan", "Jacob", "Michael", "Daniel", "Henry", "Jackson", "Sebastian", "Aiden", "Matthew", "Samuel", "David", "Joseph", "Carter", "Owen", "Wyatt", "John", "Jack", "Luke", "Jayden", "Dylan", "Grayson", "Levi", "Isaac", "Gabriel", "Julian", "Mateo", "Anthony", "Jaxon", "Lincoln", "Joshua", "Christopher", "Andrew", "Theodore", "Caleb", "Ryan", "Asher", "Nathan", "Thomas", "Leo", "Isaiah", "Charles", "Josiah", "Hudson", "Christian", "Hunter", "Connor", "Eli", "Ezra", "Aaron", "Landon", "Adrian", "Jonathan", "Nolan", "Jeremiah", "Easton", "Elias", "Colton", "Cameron", "Carson", "Robert", "Angel", "Maverick", "Nicholas", "Dominic", "Jaxson", "Greyson", "Adam", "Ian", "Austin", "Santiago", "Jordan", "Cooper", "Brayden", "Roman", "Evan", "Ezekiel", "Xavier", "Jose", "Jace", "Jameson", "Leonardo", "Bryson", "Axel", "Everett", "Parker", "Kayden", "Miles", "Sawyer", "Jason", "Emma", "Olivia", "Ava", "Isabella", "Sophia", "Charlotte", "Mia", "Amelia", "Harper", "Evelyn", "Abigail", "Emily", "Elizabeth", "Mila", "Ella", "Avery", "Sofia", "Camila", "Aria", "Scarlett", "Victoria", "Madison", "Luna", "Grace", "Chloe", "Penelope", "Layla", "Riley", "Zoey", "Nora", "Lily", "Eleanor", "Hannah", "Lillian", "Addison", "Aubrey", "Ellie", "Stella", "Natalie", "Zoe", "Leah", "Hazel", "Violet", "Aurora", "Savannah", "Audrey", "Brooklyn", "Bella", "Claire", "Skylar", "Lucy", "Paisley", "Everly", "Anna", "Caroline", "Nova", "Genesis", "Emilia", "Kennedy", "Samantha", "Maya", "Willow", "Kinsley", "Naomi", "Aaliyah", "Elena", "Sarah", "Ariana", "Allison", "Gabriella", "Alice", "Madelyn", "Cora", "Ruby", "Eva", "Serenity", "Autumn", "Adeline", "Hailey", "Gianna", "Valentina", "Isla", "Eliana", "Quinn", "Nevaeh", "Ivy", "Sadie", "Piper", "Lydia", "Alexa", "Josephine", "Emery", "Julia", "Delilah", "Arianna", "Vivian", "Kaylee", "Sophie", "Brielle", "Madeline"};
  private String[] seatingType = {"First Class", "Coach", "Economy"};


  public Passenger() {
    setName();
    passengerInfo[0] = "Name: " + getName();

    setSeatType();
    passengerInfo[1] = "Seat Type: " + getSeatType();

    setLuggage();
    passengerInfo[2] = "Amount of Luggage: " + getLuggage();
  }

  public Passenger (String name, String seatType, String numOfLuggage) {
    this.name = name;
    passengerInfo[0] = "Name: " + name;

    this.seatType = seatType;
    passengerInfo[1] = "Seat Type: " + seatType;

    this.luggage = numOfLuggage;
    passengerInfo[2] = "Amount of Luggage: " + luggage;
  }



  public String getName() {
    return name;
  }

  private void setName() {
    this.len = this.names.length;
    this.name = names[rand.nextInt(len)];
  }



  public String getSeatType(){
    return seatType;
  }

  private void setSeatType(){
    len = this.seatingType.length;
    this.seatType = seatingType[rand.nextInt(len)];
  }

  public String getLuggage() {
    return luggage;
  }
  private void setLuggage(){
    this.luggage = Integer.toString(rand.nextInt(3));
  }


}
    
    
   