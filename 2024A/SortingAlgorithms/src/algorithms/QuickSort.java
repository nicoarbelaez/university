package algorithms;

public class QuickSort implements SortingAlgorithm {

    @Override
    public void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private void quicksort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(arr, start, end);
        quicksort(arr, start, pivot - 1);
        quicksort(arr, pivot + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivotIndex = (start + end) / 2;
        swap(arr, pivotIndex, end);
        int pivotIndexCounter = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                swap(arr, pivotIndexCounter++, i);
            }
        }
        swap(arr, pivotIndexCounter, end);
        return pivotIndexCounter;
    }

    private void swap(int[] arr, int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex) {
            int temp = arr[firstIndex];
            arr[firstIndex] = arr[secondIndex];
            arr[secondIndex] = temp;
        }
    }
}
