package algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RadixSort implements SortingAlgorithm {

    @Override
    public void sort(int[] arr) {
        Map<Boolean, List<Integer>> splitArray = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i -> i < 0));
        int[] negativeInts = radixSort(splitArray.get(true).stream().mapToInt(Integer::intValue).map(Math::abs).toArray());
        int[] positiveInts = radixSort(splitArray.get(false).stream().mapToInt(Integer::intValue).toArray());
        for (int i = negativeInts.length - 1, j = 0; i >= 0; i--, j++) arr[j] = -negativeInts[i];
        System.arraycopy(positiveInts, 0, arr, negativeInts.length, positiveInts.length);
    }

    public int[] radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(exp, arr);
        }
        return arr;
    }

    private void countSort(int exp, int[] arr) {

        int[] output = new int[arr.length];
        int[] countArray = new int[10];

        // Store count of occurrences in countArray[]
        for (int value : arr) {
            countArray[(value / exp) % 10]++;
        }

        // Change countArray[i] so that countArray[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Build the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            int positionInArray = countArray[(current / exp) % 10] - 1;
            output[positionInArray] = current;
            countArray[(current / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);

    }
}
