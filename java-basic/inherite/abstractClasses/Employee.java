package abstractClasses;

import java.time.*;

public class Employee extends Person {

    private double salary;
    private LocalDate hireDay;

    // 构造方法
    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        hireDay = LocalDate.of(year,month,day);
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

    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", salary);
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
}