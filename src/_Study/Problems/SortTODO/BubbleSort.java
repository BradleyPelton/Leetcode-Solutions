package _Study.Problems.SortTODO;

import java.util.Arrays;

/**
 * Bubble Sort:
 * 1. Compare two numbers
 * 2. If the one on the left is bigger, swap them.
 * 3. Move one position to the right
 *
 * NOTES: The biggest item is always the last index after the first element.
 * Named "bubblesort" because the largest bubbles up to the top(right)
 */
public class BubbleSort {
    public static int[] arr;
    public static void sort() {
        for (int right = arr.length - 1; right > 1; right--) { // everything after "right" is sorted already
            for (int left = 0; left < right; left++) {
                if (arr[left] > arr[left + 1]) {
                    swap(left, left + 1);
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

class Tests{
    public static void main(String[] args) {
        BubbleSort.arr = new int[]{1,2,3,5,1,2,5,1,43,6,2};
        BubbleSort.sort();
        System.out.println(Arrays.toString(BubbleSort.arr));
    }
}
