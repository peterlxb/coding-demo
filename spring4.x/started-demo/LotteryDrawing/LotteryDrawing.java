import java.util.*;
import java.math.*;


/**
 * Demonstrates array manipulation
 * @version 1.20
 * */
public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number? ");
        int n = in.nextInt();

        // fill an array with numbers 1 2 3
        int[] numbers = new int[n];
        for (int i = 0;i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        // draw k numbers and put them into a second array
        int[] result = new int[k];
        for (int i = 0;i<result.length;i++) {
            // make a random index between 0 and n-1
            int r = (int)(Math.random()*n);

            // pick the element at the random location
            result[i] = numbers[r];

            // move the last element into random location
            numbers[r] = numbers[n-1];
            n--;
        }

        // print
        Arrays.sort(result);
        System.out.println("Bet the following comnbination. It'll make rich");
        for (int r: result) {
            System.out.print(r);
        }
    }
}