package arrays;

import java.lang.reflect.*;
import java.util.*;

/**
 * Demonstrates the use pf reflection for manipulating arrays.
 * @version 1.2
 * */
public class CopyOfTest {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b,10);
        System.out.println(Arrays.toString(b));

        System.out.println("The following call will generate an exception");
        b = (String[]) badCopyOf(b, 10);
    }

    /**
     * 通过分配一个新数组, 然后将所有元素复制到这个新数组的方式.
     * @param a the array to grow
     * @param newLength 新的长度
     * @return a larger array that contains all elements of a.
     * type Object[], not the same type as a.
     * */
    public static Object[] badCopyOf(Object[] a, int newLength) { // not useful
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }

    /**
     * 通过分配一个相同类型的新数组, 然后将所有元素复制到这个新数组的方式.
     * @param a the array to grow.
     * @return a larger array that contains all elements of a.
     * */
    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if (!cl.isArray()) return null;

        // 获取元素类型
        Class componentType = cl.getComponentType();
        // Array类的的静态方法 getLength 返回任意数组的长度
        int length = Array.getLength(a);
        /**
         * Array类中的静态方法 newInstance 能够构造一个新数组.
         * 调用它时必须提供两个参数, 一个是数组的元素类型, 一个是数组的长度.
         * */
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0 , Math.min(length, newLength));

        return newArray;
    }
}