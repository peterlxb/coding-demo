package linkedList;

import java.util.*;

/**
 * This program demonstrates operation on linked list.
 * @version 1.11
 * */
public class LinkedListTest {

    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        // LinkedList.add 方法将对象添加到链表的尾部
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Glorial");

        /**
         * merge the words from b into a
         *
         * ListIterator<E> listIterator 返回一个列表迭代器
         * */
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        bIter = b.iterator();
        while(bIter.hasNext()) {
            bIter.next(); // skip one element

            if (bIter.hasNext()) {
                bIter.next(); // skip next element
                bIter.remove(); // remove the element
            }
        }

        System.out.println(b);

        // remove all words in b from a
        a.removeAll(b);
        System.out.println(a);
    }
}