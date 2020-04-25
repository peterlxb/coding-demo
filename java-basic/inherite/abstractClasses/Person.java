package abstractClasses;

/**
 * 定义一个抽象类.
 * 需要注意: 抽象类不能被实例化, 如果将一个类声明为 abstract
 * 就不能创建这个类的对象.
 *
 * 表达式 new Person("Vince Vu"); 是错误的.
 */
public abstract class Person {
    /**
     * 下面定义类一个抽象方法
     * 抽象方法充当着占位符的角色, 它们的具体实现在子类中.
     * */
    public abstract String getDescription();
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}