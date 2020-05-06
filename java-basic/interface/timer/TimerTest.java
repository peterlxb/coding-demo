package timer;

/**
 * @version 1.01
 * */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
// to resolve conflict with java.util.Timer

public class TimerTest {
    public static void main(String[] args) {
        /**
         * 构造类的对象, 并将它传递给 Timer 构造器.
         * */
        ActionListener listener = new TimePrinter();

        // constructor a timer that calls the listener
        // once every 10 seconds
        Timer t = new Timer(10000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }
}

/**
 * 构造定时器时, 需要设置时间间隔, 并告知定时器, 当到达时间间隔需要做哪些操作.
 *
 * 在 Java 标准类库中的类采用面向对象的方法, 它将某个类的对象传递给定时器,然后定时器
 * 调用这个对象的方法.
 *
 * 定时器需要知道调用哪一个方法, 并要求传递的对象所属的类实现了 java.awt.event 包的
 * ActionListener 接口, 下面是这个接口
 *
 * public interface ActionListener {
 *     void actionPerformed(ActionEvent event);
 * }
 *
 * 如果要实现每隔十秒打印一条信息,然后响一声,就应该定义一个实现 ActionListener 接口的类.
 *
 * */
class TimePrinter implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
