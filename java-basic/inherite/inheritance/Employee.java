package inheritance;

import java.time.*;

public class Employee {

    private String name;
    private double salary;
    private LocalDate hireDay;

    // 构造方法
    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year,month,day);
    }

    /**
     * getName(), getSalary(), getHireDay() 都是典型的访问器方法
     * 由于只返回实例域值, 因此又称为域访问器
     * */
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    /**
     * 注意不要编写返回引用可变对象的访问器方法.
     * getHireDay() 违反了这个设计原则.返回了一个 Date 类对象.
     * Date 对象是可变的, 这一点破坏了封装性.
     * */
    public LocalDate getHireDay() {
        return hireDay;
    }

    /**
     * 如果需要返回一个可变对象的引用，应该首先对它进行克隆
     *
     *  public Date getHireDay() {
     *         return (Date) hireDay.clone();
     *     }
     * */

    /**
     * raiseSalary 方法有两个参数, 第一个参数为隐式参数, 表示Empployee类对象
     * 同等于 double raise = this.salary * byPercent / 100
     * this.salary += raise
     */
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}