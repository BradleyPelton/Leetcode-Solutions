package COMPSCIX404.AssignmentThree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Title: Assignment 03 - COMPSCIX404.1-019
 * Student: Bradley Pelton
 * Date: 2024-06-30
 */


public class Assignment_Three_Bradley_Pelton {
    // The questions are broken up into the 4 classes below. This class does not execute anything.
    QuestionOne q1 = new QuestionOne();
    QuestionTwo q2 = new QuestionTwo();
    QuestionThree q3 = new QuestionThree();
    QuestionFour q4 = new QuestionFour();
}

class QuestionOne {
//    Describe the worst case data and the best case data for each of the following sorting algorithms:
//    Bubble Sort
    /**
     * <p>
     * Worst case data                  = [5,4,3,2,1] (Array is sorted in reverse order)
     * Worst case data time complexity  = O(n**2) - lots of swaps, lots of duplicate reading
     * Worst case data space complexity = O(1) bubble sort can(and should) be done in place
     * </p>
     *
     * <p>
     * Best case data                  = [1,2,3,4,5] - Array is already sorted
     * Best case data time complexity  = O(n) - no swaps are performed
     * Best case data space complexity = O(1) bubble sort can(and should) be done in place
     * </p>
     */

//    Selection Sort
    /**
     * <p>
     * Worst case data                  = [5,4,3,2,1] (Array is sorted in reverse order)
     * Worst case data time complexity  = O(n**2) - Number of swaps/shifts scales quadratically
     * Worst case data space complexity = O(1) selection sort can(and should) be done in place
     * </p>
     *
     * <p>
     * Best case data                  = [1,2,3,4,5] - Array is already sorted
     * Best case data time complexity  = O(n**2) - while no swaps take place, we still search the same elements a lot
     * Best case data space complexity = O(1) selection sort can(and should) be done in place
     * </p>
     */

//    Insertion Sort
    /**
     * <p>
     * Worst case data                  = [5,4,3,2,1] (Array is sorted in reverse order)
     * Worst case data time complexity  = O(n**2) - each insertion causes all elements to in the sorted subarray to shift
     * Worst case data space complexity = O(1) - insertion sort can(and should) be done in place
     * </p>
     *
     * <p>
     * Best case data                  = [1,2,3,4,5] (Array is already sorted)
     * Best case data time complexity  = O(n) - the insertion is trivial and no elements are swapped/shifted
     * Best case data space complexity = O(1) - insertion sort can(and should) be done in place
     * </p>
     *
     */

//    Merge Sort
    /**
     * <p>
     * Worst case data                  = [5,4,3,2,1] (Array is sorted in reverse order) - (same as best case)
     * Worst case data time complexity  = O(n log n)
     * Worst case data space complexity = O(n) - merge sort can be done in place, but the stack consume space for recursion
     * </p>
     *
     * <p>
     * Best case data                  = [1,2,3,4,5] (Array is already sorted)
     * Best case data time complexity  = O(n log n)
     * Best case data space complexity = O(n) - merge sort can be done in place, but the stack consume space for recursion
     * </p>
     */

//    Quicksort
    /**
     * NOTE: Quicksort best/worst cases depend on how the pivot point is chosen.
     *       The answers below assume that the pivot element is chosen as the LAST ELEMENT of the array
     */

    /**
     * <p>
     * Worst case data                  = [1,2,3,4,5] (Array is already sorted) - pivot choice causes max number of swaps
     * Worst case data time complexity  = O(n**2) - suboptimal pivots cause a large number of splits
     * Worst case data space complexity = O(n) - Quicksort can be done in place, but the stack consume space for recursion
     * </p>
     *
     * <p>
     * Best case data                  = [1,2,4,5,3] (UNIQUE!) - pivots are optimally placed to limit number of splits
     * Best case data time complexity  = O(n log n) - number of splits is minimized
     * Best case data space complexity = O(n) - Quicksort can be done in place, but the stack consume space for recursion
     * </p>
     */
}

class QuestionTwo {
    /**
     * Sort the int array arr IN PLACE using Insertion sort
     * This is the optimized version of insertion sort (sometimes called binary insertion sort)
     */
    public int[] insertionSort(int[] arr) {
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
    private void binaryInsert(int[] arr, int valueToBeInserted, int lastSortedIndex) {

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

class QuestionThree {
    /**
     * Return an List<Integer> of the numbers missing in arr
     */
    public List<Integer> getMissingNumbers(int[] arr) {
        int n = arr.length;

        boolean[] seenValues = new boolean[n]; // optimal data structure. boolean[] is better than Set/Map
        for (int val : arr) {
            seenValues[val] = true; // marked the value `val` as seen
        }

        List<Integer> missingNumbers = new ArrayList<>(n); // Setting initial capacity for space-time tradeoff
        for (int i = 0; i < n; i++) {
            if (!seenValues[i]) {
                missingNumbers.add(i);
            }
        }
        return missingNumbers;
    }
}

class QuestionFour {
    /**
     * Return the first non-repeating character in inputString.
     * If no such character exists, return null.
     */
    public Character getFirstNonRepeatingCharacters(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException("Null or empty string passed as a parameter");
        } else if (inputString.length() == 1) {
            return inputString.charAt(0); // trivial case
        }

        Set<Character> repeatingCharacters = new HashSet<>();
        // boolean[] repeatingCharacters = new boolean[CHAR_SET_SIZE]  // would have been faster, but this is a Set/Map week

        char previousChar = inputString.charAt(0);
        for (int i = 1; i < inputString.length(); i++) { // cycle through all characters are mark the repeats
            char currChar = inputString.charAt(i);
            if (previousChar == currChar) {
                repeatingCharacters.add(currChar); // mark currChar as repeating
            } // NOTE:: We can't return the currChar here. It might repeat later in the string.
            previousChar = currChar;
        }

        // Space-time trade-off: We could have created a second dataStructure to maintain the order of elements.
        for (char c : inputString.toCharArray()) {
            if (!repeatingCharacters.contains(c)) {
                return c; // return the first non repeating character
            }
        }
        return null; // if we've reached here, all characters are repeating. return null.
    }
}

class QuestionFive {
    /**
     * Return the length of the longest subarray such that
     * the sum of the elements in the subarray are equal to targetVal
     */
    public int getLongestSubarrayWithSum(int[] arr, int targetVal) {
        Map<Integer, Integer> firstTimeSumWasSeen = new HashMap<>();

        int longestSubarray = targetVal == 0 ? 0 : Integer.MIN_VALUE;
        // if the targetVal == 0, then the empty set is a trivial answer since it has sum of zero

        int currSum = 0;
        firstTimeSumWasSeen.put(0, -1); // Account for when sum(arr[0..i])== target, this is like an empty set at the start
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (!firstTimeSumWasSeen.containsKey(currSum)) {
                firstTimeSumWasSeen.put(currSum, i); // track the index where the sum value was first seen
            }

            // PrefixSum pattern but with a map:
                // if the sum of arr[0..m] == X
                // and the sum of arr[0..i] == Y
                // and (Y - X) == targetVal , then the sum arr[m..i] == targetVal
            int complement = currSum - targetVal;  // we need to find a value X such that Y - X == targetVal
            if (firstTimeSumWasSeen.containsKey(complement)) {
                int leftIndex = firstTimeSumWasSeen.get(complement);
                int localAnswer = i - leftIndex; // the longest subarray from arr[leftIndex..i]
                longestSubarray = Math.max(longestSubarray, localAnswer);
            }
        }

        if (longestSubarray == Integer.MIN_VALUE) {
            System.out.println("No such subarray exists that has sum equal to targetVal");
        }
        return longestSubarray;
    }
}
