import java.util.*;

public class ConstructorTest {
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();

        // print out information about all Employee objects
        for (Employee e: staff)
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());
    }
}

class Employee {
    /**
     *  这个静态域 nextId 属于类，不属于任何独立的对象
     */
    private static int nextId = 1;

    private String name = ""; // instance field initialization
    private double salary;
    private int id;

    // static initialization block
    static {
        Random generator = new Random();
        // set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(10000);
    }

    /**
     * id 域在对象初始化块中被初始化. 首先运行初始化块, 然后才运行构造器的主体部分.
     * 这种机制不常见,也不是必需的.通常直接将初始化块代码放在构造器中.
     * */
    // object initialization block
    {
        id = nextId;
        nextId++;
    }

    /**
     * 类有多个构造器, 称为重载.
     * 多个方法有相同的名字、不同的参数, 便产生重载
     *
     * 比如 StringBuilder messages = new StringBuilder();
     *     StringBuilder todoList = new StringBuilder("To do: \n");
     *
     *  Java 允许重载任何方法, 而不只是构造器方法.
     *  要完整地描述一个方法, 需要指出方法名以及参数类型.这叫做方法的签名(signature).
     *
     *  如 String 类有4个称为 indexOf 的共有方法, 签名分别是
     *
     *  indexOf(int)
     *  indexOf(int, int)
     *  indexOf(String)
     *  indexOf(String, int)
     *
     * */

    // three overloaded constructors  - 重载
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    /***
     * 调用另一个构造器.关键字 this 引用方法的隐式参数.
     * 如果构造器的第一个语句形如 this(...), 这个构造器将调用同一个类的另一个构造器.
     */
    public Employee(double s) {
        // calls the Employee(String, double) constructor
        this("Employee #" + nextId,s);
    }

    /**
     * 默认构造器,会被自动赋为默认值: 数值为0, 布尔值为false, 对象引用为null.
     * 这种方式会影响代码的可读性.
     */
    public Employee() {
        // name initialized to ""
        // salary not explicitly set -- initialization to 0
        // id initialized in initialization block
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

}