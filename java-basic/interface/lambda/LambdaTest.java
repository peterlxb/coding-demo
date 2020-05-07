package lambda;

import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

/**
 * Demonstrates the use of lambda expressions.
 * */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[] {"Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};

        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");

        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");

        // 使用了lambda 表达式
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        /**
         * lambda 表达式可以转换为接口, 具体的语法很简短.
         * 与实现了 ActionListener 接口的类相比,下面的代码可读性要好很多
         *
         * 实际上, 在 Java中对 lambda 表达式所能做的也只是能转换为函数式接口.
         * */
        Timer t = new Timer(1000, event ->
                System.out.println("The time is " + new Date()));
        t.start();

        // Keep program running until user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}