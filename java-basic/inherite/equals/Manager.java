package equals;

public class Manager extends Employee {
    private double bonus;

    /**
     * 构造器的参数和父类基本一致, 有一个普通Employee 对象没有的bonus域.
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

    /**
     *  在子类中定义equals 方法时, 首先调用超类的equals.
     *  如果检测失败, 对象就不可能相等.如果超类中的域都相等, 就需要比较子类中的实例域.
     * */
    public boolean equals(Object otherObject){
        /**
         * 调用 super.equals() 判断this 和 otherObject 是否来源同一个class.
         * */
        if (!super.equals(otherObject)) return false;
        Manager other = (Manager) otherObject;

        return bonus == other.bonus;
    }

    public int hashCode() {
        return super.hashCode() + 17 * new Double(bonus).hashCode();
    }

    /**
     * 为自定义的每一个类增加 toString()方法是个很有用的技巧.
     * */
    public String toString() {
        return super.toString() + "[bonus=" + bonus + "]";
    }
}