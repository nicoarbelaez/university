package algorithms;

import java.util.Arrays;

public interface SortingAlgorithm {

    void sort(int[] arr);

    default void test() {
        // int[] arr = { 5, 3, 5, 2, 1, 0, -5, -6, -8, -7, -8 };
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        
        measureSortingTime(arr);
    }

    default long measureSortingTime(int[] arr) {
        System.out.println("----------");
        System.out.println("[-] Before sorting: " + Arrays.toString(arr));

        long startTime = System.nanoTime();
        sort(arr);
        long endTime = System.nanoTime();

        System.out.println("[-] After sorting: " + Arrays.toString(arr));
        long elapsedTimeMs = (endTime - startTime);
        System.out.println("[-] Sorting time: " + elapsedTimeMs + " ns");
        System.out.println("====================");
        return elapsedTimeMs;
    }
}
