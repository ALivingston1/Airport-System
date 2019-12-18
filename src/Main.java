import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    }

    /**
     * This will display any array you put into it.
     */
    public static void displayInfo(String[] information, String title) {
        int maxLen = information[1].length();

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
}