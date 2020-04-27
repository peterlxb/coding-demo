package reflection;

import java.util.*;
import java.lang.reflect.*;

/**
 * Use reflection to print all features of a class
 *
 * reflect 包中的三个类 Field、Method、Constructor 分别用于描述类的域、方法和构造器.
 *
 * 都有 getName() 方法, 用来返回项目的名称.
 * 都有 getModifiers() 方法, 返回一个整型数值, 描述 public 和 private 这样的修饰符使用的情况.
 * */
public class ReflectionTest {
    public static void main(String[] args) {
        // read class name from command
        String name;
        if (args.length > 0) name = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g java.util.Date): ");
            name = in.next();
        }

        try {
            // print class name
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();

            String modifiers = Modifier.toString(cl.getModifiers());

            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }

            System.out.print("class " + name);

            if (supercl != null && supercl != Object.class) {
                System.out.print(" extends " + supercl.getName());
            }

            System.out.print("\n{\n");

            printConstructors(cl);
            System.out.println();

            printConstructors(cl);
            System.out.println();

            printFields(cl);
            System.out.println("}");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * Prints all constructor of a class
     * @param cl a class
     * */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("  ");

            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");

            System.out.print(name + "(");

            // print parameter types
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }

            System.out.println(");");
        }
    }

    /**
     * Prints all methods of a class
     * @param cl a class
     * */
    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();

        for (Method m:methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("  ");
            // print
            String mofifiers = Modifier.toString(m.getModifiers());

            if (mofifiers.length() > 0) System.out.print(mofifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");

            // print
            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Prints all fields of a class
     * @param cl a class
     * */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();

        for (Field f: fields) {
            Class type = f.getType();
            String name = f.getName();

            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());

            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }

            System.out.println(type.getName() + "" + name + ";");
        }
    }
}