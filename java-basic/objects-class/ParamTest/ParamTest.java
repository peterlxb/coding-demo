/**
 * Demonstrates parameter passing in Java
 * @version 1.00
 * */
public class ParamTest {
    public static void main(String[] args) {
        /**
         * Test1 methods can't modify numeric parameters
         * */
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);

        /**
         * Test2 methods can change the state of object parameters
         * */
        System.out.println("\nTesting tripleSalary");
        Employee harry = new Employee("Harry", 50000);
        System.out.println("Before: salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary=" + harry.getSalary());

        /**
         * Test3 methods can't attach new objects to object parameter
         * */
        System.out.println("\nTesting swap");
        Employee a = new Employee("Alice", 70000);
        Employee b = new Employee("Bob", 60000);

        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());

    }

        /**
         * Java 中总是采用按值调用。方法得到的是所有参数值的一个拷贝.
         * 方法不能修改传递给它的任何参数变量的内容.
         * 所以下面的方法尝试修改变量 x 不会生效.
         * */
        public static void tripleValue(double x) { // doesn't work
            x = 3 * x;
            System.out.println("End of method: x=" + x);
        }

        /**
         * 这里 x 是对象的一个引用.
         * */
        public static void tripleSalary(Employee x) {
            x.raiseSalary(200);
            System.out.println("End of method: salary=" + x.getSalary());
        }

        /**
         * Java 对对象采用的不是引用调用 (对象引用是按值传递的)
         * 小结:
         * 一个方法不能修改一个基本数据类型的参数(数值型或布尔型)
         * 一个方法可以改变一个对象参数的状态
         * 一个方法不能让对象参数引用一个新的参数
         * */
        public static void swap(Employee x, Employee y) {
            Employee temp = x;
            x = y;
            y = temp;
            System.out.println("End of method: x=" + x.getName());
            System.out.println("End of method: y=" + y.getName());
        }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String n, double s) {
        name = n;
        salary = s;
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
}