package _Study.Problems.sort;

import java.util.Arrays;

public class SelectionSort {
    public static int[] arr;
    public static void sort() {
        for (int firstUnsortedIndex = 0; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int minIndex = firstUnsortedIndex;
            for (int j = firstUnsortedIndex + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(firstUnsortedIndex, minIndex);
        }
    }

    private static void swap(int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}

class Test {
    public static void main(String[] args) {
        BubbleSort.arr = new int[]{1,2,3,5,1,2,5,1,43,6,2};
        BubbleSort.sort();
        System.out.println(Arrays.toString(BubbleSort.arr));
    }
}