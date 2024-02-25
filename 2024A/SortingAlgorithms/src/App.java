import algorithms.BubbleSort;
import algorithms.BucketSort;
import algorithms.CountingSort;
import algorithms.InsertionSort;
import algorithms.MergeSort;
import algorithms.QuickSort;
import algorithms.RadixSort;
import algorithms.SelectionSort;
import algorithms.ShellSort;
import algorithms.SortingAlgorithm;

public class App {
    public static void main(String[] args) {
        SortingAlgorithm[] sortingAlgorithms = {
            new BubbleSort(),
            new BucketSort(),
            new CountingSort(),
            new InsertionSort(),
            new MergeSort(),
            new QuickSort(),
            new RadixSort(),
            new SelectionSort(),
            new ShellSort(),
        };
        
        for (SortingAlgorithm algorithm : sortingAlgorithms) {
            try {
                System.out.println(algorithm.getClass().getName().split("\\.")[1]);
                algorithm.test();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
