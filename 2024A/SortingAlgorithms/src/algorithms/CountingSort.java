package algorithms;

public class CountingSort implements SortingAlgorithm {

    @Override
    public void sort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int range = max - min + 1;
        int[] countArray = new int[range];

        for (int value : arr) {
            countArray[value - min]++;
        }

        int arrayIndex = 0;
        for (int i = 0; i < range; i++) {
            while (countArray[i] > 0) {
                arr[arrayIndex++] = i + min;
                countArray[i]--;
            }
        }
    }
}
