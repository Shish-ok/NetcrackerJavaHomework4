package comm.netcracker.homework4.CollectionTester;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTester {

    public static final int[] stepsEnd = {250000, 500000, 1000000, 2000000, 3000000};
    public static final int[] stepsCenter = {9000, 10000, 11000, 12000, 13000};
    public static final int[] stepsBegin = {15000, 20000, 25000, 30000, 35000};

    public static void main(String[] args) {
        long[] times;

        // Add to end
        times = addEndTester(new ArrayList<>());
        System.out.println("Time of add to end in ArrayList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = addEndTester(new LinkedList<>());
        System.out.println("Time of add to end in LinkedList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        // Add to center
        times = addCenterTester(new ArrayList<>());
        System.out.println("Time of add to center in ArrayList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = addCenterTester(new LinkedList<>());
        System.out.println("Time of add to center in LinkedList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        // Add to begin
        times = addBeginTester(new ArrayList<>());
        System.out.println("Time of add to begin in ArrayList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = addBeginTester(new LinkedList<>());
        System.out.println("Time of add to begin in LinkedList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        // Set to end
        times = setEndTester(new ArrayList<>());
        System.out.println("Time for set to end in ArrayList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = setEndTester(new LinkedList<>());
        System.out.println("Time for set to end in LinkedList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        // Set to center
        times = setCenterTester(new ArrayList<>());
        System.out.println("Time for set to center in ArrayList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = setCenterTester(new LinkedList<>());
        System.out.println("Time for set to center in LinkedList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        // Set to begin
        times = setBeginTester(new ArrayList<>());
        System.out.println("Time for set to begin in ArrayList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = setBeginTester(new LinkedList<>());
        System.out.println("Time for set to begin in LinkedList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        // Get from end
        times = getEndTester(new ArrayList<>());
        System.out.println("Time for get from end in ArrayList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = getEndTester(new LinkedList<>());
        System.out.println("Time for get from end in LinkedList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        // Get from center
        times = getCenterTester(new ArrayList<>());
        System.out.println("Time for get from center in ArrayList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = getCenterTester(new LinkedList<>());
        System.out.println("Time for get from center in LinkedList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        // Get from begin
        times = getBeginTester(new ArrayList<>());
        System.out.println("Time for get from begin in ArrayList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = getBeginTester(new LinkedList<>());
        System.out.println("Time for get from begin in LinkedList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        // Remove from end
        times = removeEndTester(new ArrayList<>());
        System.out.println("Time for remove from end in ArrayList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = removeEndTester(new LinkedList<>());
        System.out.println("Time for remove from end in LinkedList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        // Remove from center
        times = removeCenterTester(new ArrayList<>());
        System.out.println("Time for remove from center in ArrayList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = removeCenterTester(new LinkedList<>());
        System.out.println("Time for remove from center in LinkedList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        // Remove from begin
        times = removeBeginTester(new ArrayList<>());
        System.out.println("Time for remove from begin in ArrayList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();

        times = removeBeginTester(new LinkedList<>());
        System.out.println("Time for remove from begin in LinkedList with increasing number of operations:" );
        for (long time : times) { System.out.print(time + " "); }
        System.out.println();
    }

    public static long[] addEndTester(List<Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int k = 0; k < 100; ++k) {
                Instant start = Instant.now();
                for (int i = 0; i < stepsEnd[j]; ++i) {
                    c.add(0);
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

    public static long[] addCenterTester(List<Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int k = 0; k < 100; ++k) {
                c.add(0);
                c.add(0);
                Instant start = Instant.now();
                for (int i = 0; i < stepsCenter[j]; ++i) {
                    c.add(c.size() / 2, 0);
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

    public static long[] addBeginTester(List<Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int k = 0; k < 100; ++k) {
                c.add(0);
                Instant start = Instant.now();
                for (int i = 0; i < stepsBegin[j]; ++i) {
                    c.add(0, 0);
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

    public static long[] setEndTester(List<Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int i = 0; i < stepsEnd[j]; ++i) { c.add(0); }
            for (int k = 0; k < 100; ++k) {
                Instant start = Instant.now();
                for (int i = 0; i < stepsEnd[j]; ++i) { c.set((int) stepsEnd[j] - 1, 1); }
                Instant finish = Instant.now();
                time[j] += Duration.between(start, finish).toMillis();
            }
            c.clear();
        }
        for (int i = 0; i < 5; ++i) { time[i] = time[i] / 100; }
        return time;
    }

    public static long[] setCenterTester(List<Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int i = 0; i < stepsCenter[j]; ++i) { c.add(0); }
            for (int k = 0; k < 100; ++k) {
                Instant start = Instant.now();
                for (int i = 0; i < stepsCenter[j]; ++i) { c.set(c.size() / 2, 1); }
                Instant finish = Instant.now();
                time[j] += Duration.between(start, finish).toMillis();
            }
            c.clear();
        }
        for (int i = 0; i < 5; ++i) { time[i] = time[i] / 100; }
        return time;
    }

    public static long[] setBeginTester(List<Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int i = 0; i < stepsEnd[j]; ++i) { c.add(0); }
            for (int k = 0; k < 100; ++k) {
                Instant start = Instant.now();
                for (int i = 0; i < stepsEnd[j]; ++i) { c.set(0, 1); }
                Instant finish = Instant.now();
                time[j] += Duration.between(start, finish).toMillis();
            }
            c.clear();
        }
        for (int i = 0; i < 5; ++i) { time[i] = time[i] / 100; }
        return time;
    }

    public static long[] getEndTester(List<Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int i = 0; i < stepsEnd[j]; ++i) { c.add(0); }
            for (int k = 0; k < 100; ++k) {
                Instant start = Instant.now();
                for (int i = 0; i < stepsEnd[j]; ++i) { c.get((int) stepsEnd[j] - 1); }
                Instant finish = Instant.now();
                time[j] += Duration.between(start, finish).toMillis();
            }
            c.clear();
        }
        for (int i = 0; i < 5; ++i) { time[i] = time[i] / 100; }
        return time;
    }

    public static long[] getCenterTester(List<Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int i = 0; i < stepsCenter[j]; ++i) { c.add(0); }
            for (int k = 0; k < 100; ++k) {
                Instant start = Instant.now();
                for (int i = 0; i < stepsCenter[j]; ++i) { c.get(c.size() / 2); }
                Instant finish = Instant.now();
                time[j] += Duration.between(start, finish).toMillis();
            }
            c.clear();
        }
        for (int i = 0; i < 5; ++i) { time[i] = time[i] / 100; }
        return time;
    }

    public static long[] getBeginTester(List<Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int i = 0; i < stepsBegin[j]; ++i) { c.add(0); }
            for (int k = 0; k < 100; ++k) {
                Instant start = Instant.now();
                for (int i = 0; i < stepsBegin[j]; ++i) { c.get(0); }
                Instant finish = Instant.now();
                time[j] += Duration.between(start, finish).toMillis();
            }
            c.clear();
        }
        for (int i = 0; i < 5; ++i) { time[i] = time[i] / 100; }
        return time;
    }

    public static long[] removeEndTester(List<Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int i = 0; i < stepsCenter[j]; ++i) { c.add(0); }
            for (int k = 0; k < 100; ++k) {
                Instant start = Instant.now();
                for (int i = 0; i < stepsCenter[j]; ++i) { c.remove(stepsCenter[j] - 1); }
                Instant finish = Instant.now();
                time[j] += Duration.between(start, finish).toMillis();
            }
            c.clear();
        }
        for (int i = 0; i < 5; ++i) { time[i] = time[i] / 100; }
        return time;
    }

    public static long[] removeCenterTester(List<Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int k = 0; k < 100; ++k) {
                for (int i = 0; i < stepsCenter[j]; ++i) { c.add(0); }
                Instant start = Instant.now();
                for (int i = 0; i < stepsCenter[j]; ++i) { c.remove(c.size() / 2); }
                Instant finish = Instant.now();
                time[j] += Duration.between(start, finish).toMillis();
            }
        }
        for (int i = 0; i < 5; ++i) { time[i] = time[i] / 100; }
        return time;
    }

    public static long[] removeBeginTester(List<Integer> c) {
        long[] time = {0, 0, 0, 0, 0};

        for (int j = 0; j < 5; ++j) {
            for (int k = 0; k < 100; ++k) {
                for (int i = 0; i < stepsBegin[j]; ++i) { c.add(0); }
                Instant start = Instant.now();
                for (int i = 0; i < stepsBegin[j]; ++i) { c.remove(0); }
                Instant finish = Instant.now();
                time[j] += Duration.between(start, finish).toMillis();
            }
        }
        for (int i = 0; i < 5; ++i) { time[i] = time[i] / 100; }
        return time;
    }
}
