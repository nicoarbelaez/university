package algorithms;

public class MergeSort implements SortingAlgorithm {

    @Override
    public void sort(int[] arr) {
        mergesort(arr, 0, arr.length - 1);
    }

    private void mergesort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergesort(arr, start, middle);
        mergesort(arr, middle + 1, end);
        merge(arr, start, middle, end);
    }

    private void merge(int[] arr, int start, int middle, int end) {
        int[] leftArray = new int[middle - start + 1];
        int[] rightArray = new int[end - middle];

        System.arraycopy(arr, start, leftArray, 0, leftArray.length);
        System.arraycopy(arr, middle + 1, rightArray, 0, rightArray.length);

        int leftSubArrCounter = 0;
        int rightSubArrCounter = 0;
        int arrCounter = start;
        while (leftSubArrCounter < leftArray.length && rightSubArrCounter < rightArray.length) {
            if (leftArray[leftSubArrCounter] < rightArray[rightSubArrCounter]) {
                arr[arrCounter++] = leftArray[leftSubArrCounter++];
            } else {
                arr[arrCounter++] = rightArray[rightSubArrCounter++];
            }
        }

        while (leftSubArrCounter < leftArray.length) {
            arr[arrCounter++] = leftArray[leftSubArrCounter++];
        }

        while (rightSubArrCounter < rightArray.length) {
            arr[arrCounter++] = rightArray[rightSubArrCounter++];
        }
    }
}
