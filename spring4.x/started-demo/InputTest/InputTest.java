import java.util.*;

/**
 * Demonstrates console input
 * @version 1.10
 * @author Peter Liu
 */
public class InputTest {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        // Get first input
        System.out.print("What is your name? ");
        String name = in.nextLine();

        // Get Second input
        System.out.print("How old are you? ");
        int age = in.nextInt();

        // Display output on console
        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
    }
}