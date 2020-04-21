
/**
 * This is the first sample program
 * @version 1.01
 * @author peter Liu
 */
public class FirstSample {
//    final double CM_PER_INCH = 2.54;

    public static void main(String[] args) {
        // 在 Java 中定义一个常量
        final double CM_PER_INCH = 2.54;
        double paperWidth = 8.5;
        double paperHeight = 11;

        String greeting = "Hello";

        System.out.println("we will not use 'Hello, World!'");
        System.out.println("Paper size in centimeters: "
            + paperWidth * CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);

        // Java String
        // Test equals
        System.out.println("Hello".equals(greeting)); // True
    }
}