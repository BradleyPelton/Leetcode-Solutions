package _Study.Problems.sort;

import java.util.Arrays;

/**
 *
 *
 * Split an array into two groups:
 * 1. LEFT = Already sorted
 * 2. RIGHT = Unsorted
 *
 * One-by-one, take a new number from the right and "Insert" it into the sorted order of the left.
 *
 */
public class InsertionSort {
    /**
     * Sort the int array arr IN PLACE using Insertion sort
     * This is the optimized version of insertion sort (sometimes called binary insertion sort)
     */
    public static int[] sort(int[] arr) {
        int lastSortedElementIndex = 0; // first element is since a singleton set is trivially sorted
        while (lastSortedElementIndex < arr.length - 1) {
            int nextValToInsert = arr[lastSortedElementIndex + 1];
            // insert nextValToInsert into the sorted left subarray arr[0..lastSortedElementIndex]
            binaryInsert(arr, nextValToInsert, lastSortedElementIndex);
            lastSortedElementIndex++;
        }

        return arr;
    }

    /**
     * Insert val into the subarray arr[0..right] in its appropriate sorted place
     */
    private static void binaryInsert(int[] arr, int valueToBeInserted, int lastSortedIndex) {

        int insertionPosition = Arrays.binarySearch(
                arr,
                0,          // left  == 0
                lastSortedIndex + 1, // right == the last sorted element index + 1 since [inclusive, exclusive)
                valueToBeInserted
        );
        if (insertionPosition < 0) { // if the element is not a duplicate, binary search will return -pos - 1
            insertionPosition = -insertionPosition - 1;
        }

        // insert the value at arr[insertionPosition] and shift right all elements to the right
        int nextValue = valueToBeInserted;
        for (int i = insertionPosition; i <= lastSortedIndex + 1; i++) {
            int originalValue = arr[i];
            arr[i] = nextValue;
            nextValue = originalValue;
        }
    }
}

class Tes {
    public static void main(String[] args) {
        BubbleSort.arr = new int[]{1,2,3,5,1,2,5,1,43,6,2};
        BubbleSort.sort();
        System.out.println(Arrays.toString(BubbleSort.arr));
    }
}
