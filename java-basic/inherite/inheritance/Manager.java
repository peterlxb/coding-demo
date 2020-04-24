package inheritance;

public class Manager extends Employee {
    private double bonus;

    /**
     * 构造器的参数和父类基本一致, 有一个 普通Employee 对象没有的bonus域.
     * */
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double b) {
        bonus = b;
    }
}