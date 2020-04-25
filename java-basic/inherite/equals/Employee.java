package equals;

import java.time.*;
import java.util.Objects;

public class Employee {

    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
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
     * raiseSalary 方法有两个参数, 第一个参数为隐式参数, 表示Empployee类对象
     * 同等于 double raise = this.salary * byPercent / 100
     * this.salary += raise
     */
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * Object 类中的 equals 方法用于检测一个对象是否等于另外一个对象.
     * 在 Object 类中, 这个方法将判断两个对象是否具有相同的引用.
     * */
    public boolean equals(Object otherObject) {

        // 快速判断两个对象是否相等
        if (this == otherObject) return true;

        // 如果参数是null 直接返回false
        if (this == null) return false;

        /**
         * getClass() 方法返回一个对象所属的类.
         * 在检测中，只有两个对象属于同一个类时，才有可能相等.
         * */
        if (getClass() != otherObject.getClass()) return false;

        // 到这里说明 otherObject 是一个 non-null Employee 对象
        Employee other = (Employee) otherObject;

        // 判断对象的各个域是不是相等
        return Objects.equals(name, other.name) && salary == other.salary
                && Objects.equals(hireDay, other.hireDay);
    }

    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireday=" + hireDay
                + "]";
    }
}