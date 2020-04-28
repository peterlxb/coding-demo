package methods;

import java.lang.reflect.*;

/**
 * Shows how to invoke methods through reflection.
 * @version 1.2
 * */
public class MethodTableTest {

    public static void main(String[] args) throws Exception {
        // get method pointers to the square
        Method sqaure = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        // print tables of x- and y-values

        printTable(1,10, 10, sqaure);
        printTable(1,10,10,sqrt);
    }

    /**
     * */
    public static double square(double x) {
        return x * x;
    }

    /**
     * Prints a table with x- and y-values for a method
     * */
    public static void printTable(double from, double to, int n, Method f) {
        // print out the mwthod as table header
        System.out.println(f);
        double dx = (to - from) / (n - 1);

        for (double x = from; x <= to; x+=dx) {
            try {
                double y = (Double) f.invoke(null, y);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
