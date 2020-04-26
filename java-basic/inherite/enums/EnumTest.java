package enums;

import java.util.*;

/**
 * demonstrates enumerated types
 * */
public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");

        String input = in.next().toUpperCase();
        /**
         * Enum 类的 toString 的逆方法是 valueOf().
         * Size s = Enum.valueOf(Size.class, "SMALL"); 将 s 设置成 Size.SMALL.
         * */
        Size size = Enum.valueOf(Size.class, input);

        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());

        if(size == Size.EXTRA_LARGE)
            System.out.println("Good job--you paid attention to the _.");
    }
}

/**
 * 定义一个枚举类, 刚好有四个实例, 所以尽量不要构造新对象.
 *
 * 所有的枚举类型都是 Enum 类的子类, 继承的最有用的方法是 toString.
 * 这个方法能够返回枚举常量名. Size.SMALL.toString 返回 SMALL.
 * */
enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    /**
     * 构造器只是在构造枚举常量的时候被调用.
     * */
    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    private String abbreviation;
}