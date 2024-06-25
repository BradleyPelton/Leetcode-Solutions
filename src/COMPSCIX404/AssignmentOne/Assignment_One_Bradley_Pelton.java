package COMPSCIX404.AssignmentOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


/**
 * Title: Assignment 01 - COMPSCIX404.1-019
 * Student: Bradley Pelton
 * Date: 2024-06-16
 *
 */

public class Assignment_One_Bradley_Pelton {
    // The questions are broken up into the 4 classes below. This class does not execute anything.
    QuestionOne   q1 = new QuestionOne();
    QuestionTwo   q2 = new QuestionTwo();
    QuestionThree q3 = new QuestionThree();
    QuestionFour  q4 = new QuestionFour();
}

class QuestionOne {
    // Write an example for each of the following: O(1), O(log n), O(n), O(n log n), O(n**2)
    /**
     * O(1) - constant time
     * Return the size of a dynamic array (in Java, this is kept up-to-date with a field).
     */
    private int getArrayListSize(ArrayList<Integer> arrList) {
        return arrList.size();
    }

    /**
     * O(log n) - logarithmic time
     * Count the number of digits in a decimal value equal to n
     */
    private int getNumberOfDigits(int decimalValue) {
        int numberOfDigits = 0;
        while (decimalValue > 0) { // At most log_10(n) iterations
            decimalValue /= 10;
            numberOfDigits++;
        }
        return numberOfDigits;
    }

    /**
     * O(n) - linear time
     * Count the number of even numbers in an array
     */
    private int getNumberOfEvenValues(int[] arr) {
        int numberOfEvenValues = 0;
        for (int val : arr) {
            if (val % 2 == 0) {
                numberOfEvenValues++;
            }
        }
        return numberOfEvenValues;
    }

    /**
     * O(n log n) - linearithmic time
     * Given a sorted array of size n, perform binary search n number of times
     */
    private void searchMultipleTimes(int[] sortedArr) {
        int n = sortedArr.length;
        for (int i = 0; i < n; i++) {
            Arrays.binarySearch(sortedArr, i); // search for an arbitrary value. Using `i` for simplicity.
        }
    }

    /**
     * O(n**2) - Polynomial/Quadratic time
     * Given an array of size n, count the number of pair-indices (i,j) such that array[i]*array[j] == targetVal
     * and 0 < i < j < n
     */
    private int getPairMultiplicationCount(int[] arr, int targetVal) {
        int n = arr.length;
        int pairMultiplicationCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] * arr[j] == targetVal) {
                    pairMultiplicationCount++;
                }
            }
        }
        return pairMultiplicationCount;
    }
}

class QuestionTwo {
    private final Random random = new Random(); // reusing the same Random object for efficiency

    /**
     * Create an array with the values [0..n-1], then shuffle that array and return it.
     */
    private int[] populateAndShuffle(int n) {
        int[] intArr = new int[n]; // O(1) Allocate memory for the array
        for (int i = 0; i < n; i++) { // O(n)
            intArr[i] = i;
        }

        for (int i = 0; i < n; i++) {  // O(n)
            int randomIndex = generateRandomIndex(n); // O(1)
            swapValuesAtTwoIndices(intArr, i, randomIndex); // O(1)
        }

        return intArr;
    }

    private void describeTimeComplexity() {
        /*
         * Time Complexity
         * Average: O(n)
         * Worst  : O(n)
         *
         * Summary: The time complexity for this algorithm is O(n). It is the same for Worst, Average, and Best case.
         *
         * Why: The time complexity of this algorithm does not vary because the number of steps is exactly the same
         *      for the worst, average, and best case. The dominant factor in the time complexity is always O(n).
         *
         * total time complexity = time complexity of initialization
         *      + time complexity of populating the array
         *      + (time complexity of the for loop * (time complexity of generating random index + time complexity of swap)
         * --------------------------------------------------
         *                       = O(1) + O(n) + (O(n * 1 * 1)) = O(n)
         *
         * time complexity of initialization = O(1) (trivial memory allocation)
         * time complexity of populating the array = O(n) (n iterations of a for loop, constant number of steps inside loop
         * time complexity of generating random index = O(1) (per the documentation of Random::nextInt
         * time complexity of swap = O(1),
         */
    }

    /**
     * Return a random index from [0, maxIndex) (inclusive to exclusive).
     */
    private int generateRandomIndex(int maxIndex) {
        return random.nextInt(maxIndex); // Time Complexity of Random::nextInt() is O(1) according to the documentation
    }

    /**
     * Swap the value of arr[indexOne] and arr[indexTwo].
     */
    private void swapValuesAtTwoIndices(int[] arr, int indexOne, int indexTwo) {
        if (indexOne < 0 || indexTwo < 0 || indexOne >= arr.length || indexTwo >= arr.length) {
            throw new IllegalArgumentException("Bad index passed to swapValues method!");
        }
        int originalIndexOneValue = arr[indexOne];
        int originalIndexTwoValue = arr[indexTwo];

        arr[indexOne] = originalIndexTwoValue;
        arr[indexTwo] = originalIndexOneValue;
        // No return needed, arr is being modified in place
    }
}

class QuestionThree {
    /**
     * Return the number of times targetVal appears in the sorted array arrOfSorted
     */
    private int countNumberOfOccurrences(int[] arrOfSorted, int targetVal) {
        int firstOccurrence = binarySearchForFirstOccurrence(arrOfSorted, targetVal); // O(log n)
        int lastOccurrence = binarySearchForLastOccurrence(arrOfSorted, targetVal); // O(log n)

        if (firstOccurrence == -1) { // NOTE: firstOccurrence == -1 iff lastOccurrence == -1
            return 0; // The value never appears
        } else if (firstOccurrence == lastOccurrence) {
            return 1; // if first==last, the value only appears once
        } else {
            int numberOfOccurrences = (lastOccurrence - firstOccurrence) + 1; // +1 for inclusive first and last index
            return numberOfOccurrences;
        }

        // Time Complexity:  O(log n) (since O(2 * log(n) + 1) = O(log n))
    }

    /**
     * Return the index of the FIRST element whose value is equal to targetVal.
     * If no element is equal to targetVal, return -1.
     */
    private int binarySearchForFirstOccurrence(int[] arrOfSorted, int targetVal) {
        int left = 0;
        int right = arrOfSorted.length - 1;

        while (left < right) {
            if (right == left + 1) { // infinite loop protection. I'm sure there's a clever solution, but this is safer.
                left = arrOfSorted[left] == targetVal ? left : right;
                break;
            }

            int midPoint = left + (right - left)/2;  // arguably the better way of finding midpoint (avoids overflow)
            if (arrOfSorted[midPoint] >= targetVal) {
                right = midPoint;
            } else {
                left = midPoint + 1;
            }
        }

        if (arrOfSorted[left] != targetVal) {
            return -1; // value not in the arr
        } else {
            return left;
        }
    }

    /**
     * Return the index of the LAST element whose value is equal to targetVal.
     * If no element is equal to targetVal, return -1.
     */
    private int binarySearchForLastOccurrence(int[] arrOfSorted, int targetVal) {
        int left = 0;
        int right = arrOfSorted.length - 1;

        while (left < right) {
            if (right == left + 1) { // infinite loop protection. I'm sure there's a clever solution, but this is safer.
                left = arrOfSorted[right] == targetVal ? right : left;
                break;
            }

            int midPoint = left + (right - left)/2;  // arguably the better way of finding midpoint (avoids overflow)
            if (arrOfSorted[midPoint] <= targetVal) {
                left = midPoint;
            } else {
                right = midPoint - 1;
            }
        }

        if (arrOfSorted[left] != targetVal) {
            return -1; // value not in the arr
        } else {
            return left;
        }
    }
}

class QuestionFour {
    private int getLargestValue(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // OBJECTIVE: Keep the "pivot" element within [left, right]
        // Let the "pivot" be the index where the array flips from (LARGEST) -> (SMALLEST) element

        while (left < right) {
            if (right == left + 1) { // infinite loop protection. I'm sure there's a clever solution, but this is safer.
                left = arr[left] >= arr[right] ? left : right;
                break;
            }

            int midPoint = left + (right - left)/2;  // arguably the better way of finding midpoint (avoids overflow)
            if (arr[left] <= arr[midPoint] && arr[midPoint] <= arr[right]) {
                left = right;  // Cool Conclusion: `left` must be the pivot point.
                break;
            } else if (arr[left] <= arr[midPoint] && arr[midPoint] > arr[right]) {
                left = midPoint; // The pivot must be between midPoint and right
            } else if (arr[left] > arr[midPoint] && arr[midPoint] <= arr[right]) {
                right = midPoint; // The pivot must be between left and midpoint
            } else if (arr[left] > arr[midPoint] && arr[midPoint] > arr[right]) {
                // Impossibility: The "pivot" must be between left and midpoint, and also between midPoint and right.
                // There can only be one pivot point, therefore contradiction.
                throw new IllegalStateException("Impossibility reached! Multiple pivots found");
            } else {
                throw new IllegalStateException("Impossibility reached! Array was rotated incorrectly");
            }
        }
        return left;
    }
}
