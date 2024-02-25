package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort implements SortingAlgorithm {

    @Override
    public void sort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        // Determina el rango de valores en la lista de entrada
        int range = max - min;

        // Configura un arreglo de cubos inicialmente vacíos
        final int numberOfBuckets = (int) Math.sqrt(arr.length) * 2;
        List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Determina el tamaño de cada cubo
        int bucketSize = (int) Math.ceil((double) range / numberOfBuckets);

        // Distribuye cada elemento en su cubo correspondiente
        for (int num : arr) {
            int index = hash(num, min, bucketSize, numberOfBuckets);
            buckets.get(index).add(num);
        }

        // Ordena cada cubo utilizando un comparador y concatena los cubos ordenados
        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }

    private int hash(int num, int min, int bucketSize, int numberOfBuckets) {
        int adjustedNum = num - min;
        return Math.min(adjustedNum / bucketSize, numberOfBuckets - 1);
    }
}