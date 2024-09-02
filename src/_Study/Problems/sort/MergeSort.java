package _Study.Problems.sort;


import java.util.Arrays;

/**
 * Merge sort
 *
 * // TODO - In place
 */
public class MergeSort {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        int midPoint = left + (right - left) / 2;
        sort(arr, left, midPoint);
        sort(arr, midPoint + 1, right);

        mergeTwoSortedLists(arr, left, midPoint, midPoint + 1, right);
    }


    public void mergeTwoSortedLists(int[] arr, int leftOne, int rightOne, int leftTwo, int rightTwo) {
        int startingPoint = leftOne;
        int realIndex = 0;
        int[] tempArr = new int[rightTwo - leftOne + 1];

        while (leftOne <= rightOne || leftTwo <= rightTwo) {
            int listOneVal = leftOne <= rightOne ? arr[leftOne] : Integer.MAX_VALUE;
            int listTwoVal = leftTwo <= rightTwo ? arr[leftTwo] : Integer.MAX_VALUE;

            if (listOneVal < listTwoVal) {
                tempArr[realIndex] = listOneVal;
                leftOne++;
            } else {
                tempArr[realIndex] = listTwoVal;
                leftTwo++;
            }
            realIndex++;
        }

        for (int i =0; i < tempArr.length; i++) {
            arr[i + startingPoint] = tempArr[i];
        }
    }
}

class Te {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.sortArray(
                new int[]{1,2,9,8,7,3,4,6,5}
        )));
    }
}
