import java.io.*;
import java.util.Arrays;

public class QuickSort {
    public static void main(String args[]) {
        int[] arr = {5, 12, 4, 3, 9, 84, 33, 21, 5, 9, 0};
        quickSort(arr, 0, 10);
        System.out.println(Arrays.toString(arr));

    }

    public static int partition(int[] arr, int low, int high) {
        int i = low - 1;
        int pivot = arr[high];
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap values of positions i and j
                // so if i is 3 and j is 1
                // i is 1 and j is 3
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // when we reach our boundary, pivot goes just after last 
        // index that was less or equal to it
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        // return new position of pivot (this index will not be partitioned)
        // from here quickSort will sort the two arrays above and below this
        // position
        return i + 1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // get the partitioning index
            int pi = partition(arr, low, high);

            // recursively sort the arrays above and below
            // the partitioning index
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
}