import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Aircraft one = new Aircraft();

        System.out.println("Airline: " + Arrays.toString(one.getFlightInfo()));
    }
}
