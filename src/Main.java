import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Aircraft a = new Aircraft();
//        displayInfo(a.getFlightInfo(), "Flight Info");
//        displayInfo(a.getPassengerInfo(), "Aircraft Info");
    }

    /**
     * This will display any array you put into it.
     */
    public static void displayInfo(String[] information, String title) {
        int maxLen = information[getLen(information)].length();

        /*
        Header
         */
        System.out.println("-".repeat(maxLen+4));
        System.out.println("|" + " ".repeat(((maxLen + 3) - title.length()) / 2)
                + title
                + " ".repeat(((maxLen + 2) - title.length()) / 2) + "|");
        System.out.println("-".repeat(maxLen + 4));

        /*
        Body
         */
        for (int i = 0; i < information.length; i++) {
            System.out.println("|" + " ".repeat(((maxLen + 3) - information[i].length()) / 2)
                    + information[i]
                    + " ".repeat(((maxLen + 2) - information[i].length()) / 2) + "|");
        }
        System.out.print("-".repeat(maxLen + 4) + "\n");
    }

    /**
     * Gets the length of the longest flightInfo line
     */
    public static int getLen(String[] information) {
        int len = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (len < information[j].length()) {
                    len = information[j].length();
                }
            }
        }
        return len;
    }
}