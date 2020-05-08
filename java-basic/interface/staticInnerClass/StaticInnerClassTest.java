package staticInnerClass;

/**
 * Demonstrates the use of static inner classes.
 * @version 1.02
 * */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] d = new double[20];

        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }

        ArrayAlg.Pair p = ArrayAlg.minmax(d);

        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}

class ArrayAlg {
    /**
     * 定义一个静态内部类
     * */
    public static class Pair {
        private double first;
        private double second;

        /**
         * Constructors a pair from two floating-point numbers
         * */
        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        /**
         * Returns the first number of pair
         * */
        public double getFirst() {
            return first;
        }

        /**
         * Returns the second number of pair
         * */
        public double getSecond() {
            return second;
        }
    }

    /**
     * Computers both the minimum and the maximum of an array
     * */
    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        for (double v : values) {
            if (min > v) min  =v;
            if (max < v) max = v;
        }

        return new Pair(min, max);
    }
}