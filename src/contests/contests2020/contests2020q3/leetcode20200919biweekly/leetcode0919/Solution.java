package leetcode0919;

import java.util.Arrays;

// First attempt time out exceeded
// SEcond attempt time out exceeded
// Third attempt I expiremented with breaking the loop instead of just continuing. It worked.
// I don't know why I was so hesitant to use break in the first place. I was unsure if break was going to break
// both for loops? I'm not sure
class Solution {

    public int sumOddLengthSubarrays(int[] arr) {

        int dummySum = 0;
        int totalSum = 0;
        int currentIndex;

        for (int i = 0; i < 105; i++) {
            for (int j = 0; j < 100; j++) {
                try {
                    currentIndex = (i + 2 * j);
                    dummySum += arr[currentIndex];

                    int[] tempArr = Arrays.copyOfRange(arr, i, currentIndex + 1);
//                    System.out.println(Arrays.toString(tempArr));

                    for (int e : tempArr) {
                        totalSum += e;
                    }

                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
        }

        System.out.println("final answer is " + totalSum);
        return totalSum;

    }

    public Solution(){}

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] firstExample = {1,4,2,5,3};
        int[] secondExample = {1,2};
        int[] thirdExample = {10,11,12};
        int[] fourthExample = {1,14,10,11,12,12,1,16};
//        sol.sumOddLengthSubarrays(firstExample);
//        sol.sumOddLengthSubarrays(secondExample);
//        sol.sumOddLengthSubarrays(thirdExample);
//        sol.sumOddLengthSubarrays(fourthExample);
    }
}