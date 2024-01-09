package _Study.Problems.SortTODO;

import java.util.Arrays;

/**
 *
 *
 * Split an array into two groups:
 * 1. LEFT = Already sorted
 * 2. RIGHT = Unsorted
 *
 * One-by-one, take a new number from the right and "Insert" it into the sorted order of the left.
 */
public class InsertionSort {
    public static int[] arr;
    public static void sort() {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(j, j - 1);
                }
            }
        }
    }

    private static void swap(int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}

class Tes {
    public static void main(String[] args) {
        BubbleSort.arr = new int[]{1,2,3,5,1,2,5,1,43,6,2};
        BubbleSort.sort();
        System.out.println(Arrays.toString(BubbleSort.arr));
    }
}
