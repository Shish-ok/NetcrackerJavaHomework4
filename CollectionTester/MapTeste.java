package comm.netcracker.homework4.CollectionTester;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class MapTester {

    public static final int[] steps = {250000, 500000, 1000000, 2000000, 3000000};

    public static void main(String[] args) {
        long[] times;

        // Put
        times = putTester(new HashMap<>());
        System.out.println("Time of put in HashMap with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = putTester(new LinkedHashMap<>());
        System.out.println("Time of put in LinkedHashMap with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = putTester(new TreeMap<>());
        System.out.println("Time of put in LinkedHashMap with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        // Get
        times = getTester(new HashMap<>());
        System.out.println("Time of get in HashMap with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = getTester(new LinkedHashMap<>());
        System.out.println("Time of get in LinkedHashMap with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = getTester(new TreeMap<>());
        System.out.println("Time of get in TreeMap with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        // Remove
        times = removeTester(new HashMap<>());
        System.out.println("Time of remove in HashMap with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = removeTester(new LinkedHashMap<>());
        System.out.println("Time of remove in LinkedHashMap with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = removeTester(new TreeMap<>());
        System.out.println("Time of remove in LinkedHashMap with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();
    }

    public static long[] putTester(Map<Integer, Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int k = 0; k < 100; ++k) {
                Instant start = Instant.now();
                for (int i = 0; i < steps[j]; ++i) {
                    c.put(i, i);
                }
                Instant finish = Instant.now();
                c.clear();
                time[j] += Duration.between(start, finish).toMillis();
            }
        }
        for (int i = 0; i < 5; ++i) {
            time[i] = time[i] / 100;
        }
        return time;
    }

    public static long[] getTester(Map<Integer, Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int i = 0; i < steps[j]; ++i) {
                c.put(i, i);
            }
            for (int k = 0; k < 100; ++k) {
                Instant start = Instant.now();
                for (int i = 0; i < steps[j]; ++i) {
                    c.get(i);
                }
                Instant finish = Instant.now();
                time[j] += Duration.between(start, finish).toMillis();
            }
            c.clear();
        }
        for (int i = 0; i < 5; ++i) {
            time[i] = time[i] / 100;
        }
        return time;
    }

    public static long[] removeTester(Map<Integer, Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int k = 0; k < 100; ++k) {
                for (int i = 0; i < steps[j]; ++i) {
                    c.put(i, i);
                }
                Instant start = Instant.now();
                for (int i = 0; i < steps[j]; ++i) {
                    c.remove(i);
                }
                Instant finish = Instant.now();
                time[j] += Duration.between(start, finish).toMillis();
            }
        }
        for (int i = 0; i < 5; ++i) {
            time[i] = time[i] / 100;
        }
        return time;
    }
}
