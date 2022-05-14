package comm.netcracker.homework4.MyCollection;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        Instant start, finish;
        long timeTest;
        LinkedList<Integer> test1 = new LinkedList<>();
        MyLinkedList<Integer> test2 = new MyLinkedList<>();

        // Tests of LinkedList
        start = Instant.now();
        for (int i = 0; i < 2000000; ++i) { test1.add(i); }
        finish = Instant.now();
        System.out.println("Time of add(E element) for LinkedList = " + (Duration.between(start, finish).toMillis()));

        start = Instant.now();
        for (int i = 0; i < 300; ++i) { test1.add(1000000, 77); }
        finish = Instant.now();
        System.out.println("Time of add(int index, E element) for LinkedList = " + Duration.between(start, finish).toMillis());

        start = Instant.now();
        test1.clear();
        finish = Instant.now();
        System.out.println("Time of clear() for LinkedList = " + Duration.between(start, finish).toMillis());

        start = Instant.now();
        test1.get(1000000);
        finish = Instant.now();
        System.out.println("Time of get() for LinkedList = " + Duration.between(start, finish).toMillis());

        start = Instant.now();
        test1.indexOf(1000000);
        finish = Instant.now();
        System.out.println("Time of indexOf() for LinkedList = " + Duration.between(start, finish).toMillis());

        start = Instant.now();
        test1.remove(1000000);
        finish = Instant.now();
        System.out.println("Time of remove(int index) for LinkedList = " + Duration.between(start, finish).toMillis());

        start = Instant.now();
        test1.set(1000000, 77);
        finish = Instant.now();
        System.out.println("Time of set(int index, E element) for LinkedList = " + Duration.between(start, finish).toMillis());

        // Tests of MyLinkedList
        start = Instant.now();
        for (int i = 0; i < 2000000; ++i) { test2.add(i); }
        finish = Instant.now();
        System.out.println("Time of add(E element) for MyLinkedList = " + Duration.between(start, finish).toMillis());

        start = Instant.now();
        for (int i = 0; i < 300; ++i) { test2.add(1000000, 77); }
        finish = Instant.now();
        System.out.println("Time of add(int index, E element) for MyLinkedList = " + Duration.between(start, finish).toMillis());

        start = Instant.now();
        test2.clear();
        finish = Instant.now();
        System.out.println("Time of clear() for MyLinkedList = " + Duration.between(start, finish).toMillis());

        start = Instant.now();
        test2.get(1000000);
        finish = Instant.now();
        System.out.println("Time of get() for MyLinkedList = " + Duration.between(start, finish).toMillis());

        start = Instant.now();
        test2.indexOf(1000000);
        finish = Instant.now();
        System.out.println("Time of indexOf() for MyLinkedList = " + Duration.between(start, finish).toMillis());

        start = Instant.now();
        test2.remove(1000000);
        finish = Instant.now();
        System.out.println("Time of remove(int index) for MyLinkedList = " + Duration.between(start, finish).toMillis());

        start = Instant.now();
        test2.set(1000000, 77);
        finish = Instant.now();
        System.out.println("Time of set(int index, E element) for MyLinkedList = " + Duration.between(start, finish).toMillis());
    }
}
