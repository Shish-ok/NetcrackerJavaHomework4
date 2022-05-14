package comm.netcracker.homework4.CollectionTester;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTester {

    public static final int[] steps = {250000, 500000, 1000000, 2000000, 3000000};

    public static void main(String[] args) {
        long[] times;

        // Add
        times = addTester(new HashSet<>());
        System.out.println("Time of add in HashSet with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = addTester(new LinkedHashSet<>());
        System.out.println("Time of add in LinkedHashSet with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = addTester(new TreeSet<>());
        System.out.println("Time of add in TreeSet with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        // Remove
        times = removeTester(new HashSet<>());
        System.out.println("Time of remove in HashSet with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = removeTester(new LinkedHashSet<>());
        System.out.println("Time of remove in LinkedHashSet with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = removeTester(new TreeSet<>());
        System.out.println("Time of remove in TreeSet with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();
    }

    public static long[] addTester(Set<Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int k = 0; k < 100; ++k) {
                Instant start = Instant.now();
                for (int i = 0; i < steps[j]; ++i) {
                    c.add(i);
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

    public static long[] removeTester(Set<Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int k = 0; k < 100; ++k) {
                for (int i = 0; i < steps[j]; ++i) {
                    c.add(i);
                }
                Instant start = Instant.now();
                for (int i = steps[j] - 1; i >= 0; --i) {
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
