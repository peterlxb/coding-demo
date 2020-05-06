package interfaces;

/**
 * 任何实现 Comparable 接口的类都必须包含 compareTo 方法.
 * 接口中的方法自动属于public.
 * 接口中绝对不能含有实例域.
 * */
public class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * Compares employees by salary
     * @param other another Employee object
     * @retrun a negative value if this employee has a lower salary than
     * otherObject,
     * */
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
    }
}