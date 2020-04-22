/**
 * Demonstrates static methods
 * @version 1.01
 * */
public class StaticTest {
    public static void main(String[] args) {
        // fill the staff array with Employee object
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Dick", 60000);
        staff[2] = new Employee("Tony", 65000);

        // print out information about all Employee objects
        for (Employee e: staff) {
            e.setId();
            System.out.println("name=" + e.getName() + ",id" + e.getId() + ",salary=" + e.getSalary());
        }

        // 一般使用类名来调用静态方法
        int n = Employee.getNextId(); // call static method
        System.out.println("next available id=" + n);
    }
}

class Employee {
    /**
     *  这个静态域 nextId 属于类，不属于任何独立的对象
     */
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;

    public Employee(String n, double s) {
        name = n;
        salary = s;
        id = 0;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id = nextId;
        nextId++;
    }

    /**
     * 静态方法是一种不能向对象实施操作的方法.
     * Math 类的 pow 方法就是一个静态方法, 表达式 Math.pow(x, a).在运算时, 不使用任何 Math 对象.
     * */
    public static int getNextId() {
        /**
         * 这个静态方法不能访问 Id 实例域, 因为它不能操作对象.
         * 但是静态方法可以访问自身类的静态域.
         * */
        return nextId; // return static field
    }

    /**
     * 不需要使用对象调用静态方法.main方法也是一个静态方法
     * */
    public static void main(String[] args) { //unit test
        Employee e = new Employee("Harry", 50000);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}