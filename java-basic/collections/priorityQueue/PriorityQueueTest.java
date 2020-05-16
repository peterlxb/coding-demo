package priorityQueue;

import java.util.*;
import java.time.*;

/**
 * Priority Queue.
 * 优先级队列中的元素可以按照任意的顺序插入, 但总是按照排序的顺序进行检索.
 * */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1906, 12, 9)); //
        pq.add(LocalDate.of(1815, 12, 10));
        pq.add(LocalDate.of(1903, 12, 3));//
        pq.add(LocalDate.of(1910, 6, 22));//

        System.out.println("Iterating over elements...");

        for (LocalDate date: pq)
            System.out.println(date);
        System.out.println("Removing elements...");

        while (!pq.isEmpty())
            System.out.println(pq.remove());
    }
}