import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Aircraft one = new Aircraft();

        for (int i = 0; i < one.flightInfo.length; i++) {
            System.out.printf(one.flightInfo[i] + " ");
        }
    }
}
