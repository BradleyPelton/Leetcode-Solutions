package contests.contests2023.lc1028.mediumone;

// Accepted after 30 minuites
// 30 minutes of annoying edge case handling.
// Not really a brain teaser as much as this felt just like work.

class Solution {
    public long minSum(int[] nums1, int[] nums2) {

        long numberOfZeroesNum1 = 0;
        long numberOfZeroesNum2 = 0;
        long num1Sum = 0;
        long num2Sum = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                numberOfZeroesNum1++;
            } else {
                num1Sum += nums1[i];
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == 0) {
                numberOfZeroesNum2++;
            } else {
                num2Sum += nums2[i];
            }
        }


        long minSumForBoth = Integer.MAX_VALUE;
        // best case, replace all zeroes with ones in the largest array
        // replace all zeroes with with ones in the smallest array except

        // FLIP num1 and num2. WLOG num1Sum >= num2Sum
        if (num2Sum > num1Sum) {
            long tempNum1Sum = num1Sum;
            long tempNum1Zeroes = numberOfZeroesNum1;

            num1Sum = num2Sum;
            numberOfZeroesNum1 = numberOfZeroesNum2;

            num2Sum = tempNum1Sum;
            numberOfZeroesNum2 = tempNum1Zeroes;
        }



        if (num1Sum == num2Sum) {
            // HANDLE ZERO ZEROES
            if (numberOfZeroesNum1 == 0 && numberOfZeroesNum2 == 0) {
                minSumForBoth = num1Sum; // DO NOTHING
            } else if (numberOfZeroesNum1 == 0 && numberOfZeroesNum2 !=0) {
                System.out.println("zero zeroes");
                return -1;
            } else if (numberOfZeroesNum1 != 0 && numberOfZeroesNum2 ==0) {
                System.out.println("zero zeroes");
                return -1;
            }
            if (numberOfZeroesNum1 == numberOfZeroesNum2) {
                minSumForBoth = num1Sum + numberOfZeroesNum1;
            } else if (numberOfZeroesNum1 > numberOfZeroesNum2) {   /// (0,0,0) vs (0) -> (1,1,1) vs (3)
                minSumForBoth = num1Sum;
                minSumForBoth += numberOfZeroesNum1;
            } else {
                minSumForBoth = num1Sum;
                minSumForBoth += numberOfZeroesNum2;
            }
        } else if (num1Sum > num2Sum) {
            // HANDLE ZERO ZEROES
            if (numberOfZeroesNum1 == 0 && numberOfZeroesNum2 == 0) {
                System.out.println("zero zeroes");
                return -1;
            } else if (numberOfZeroesNum1 == 0 && numberOfZeroesNum2 !=0) {
                if (numberOfZeroesNum2 > (num1Sum -  num2Sum)) { // more zeroes than possible to replace with just ones
                    System.out.println("too many zeroes");
                    return -1;
                } else {
                    System.out.println("good num1sum == ");
                    minSumForBoth = num1Sum;
                }
            } else if (numberOfZeroesNum1 != 0 && numberOfZeroesNum2 ==0) {
                System.out.println("num2 can never catch up");
                return -1;
            }
            if (numberOfZeroesNum1 == numberOfZeroesNum2) {
                // 1 for each zero
                // +n for the diff
                minSumForBoth = num1Sum + numberOfZeroesNum1;

            } else if (numberOfZeroesNum1 > numberOfZeroesNum2) {
                // 1 for each numberOfZeroesNum1
                // +n for each
                minSumForBoth = num1Sum + numberOfZeroesNum1;
            } else { // numberOfZeroesNum1 < numberOfZeroesNum2
                num1Sum += numberOfZeroesNum1;
                num2Sum += numberOfZeroesNum2;
                minSumForBoth = Math.max(num1Sum, num2Sum);
                System.out.println("tweaking both zeroes");
            }
        } else { //else num1Sum < num2Sum
            throw new IllegalStateException("Never should be reached");
        }
        System.out.println("ans = " + minSumForBoth);
        return minSumForBoth;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minSum(
                new int[]{3,2,0,1,0},
                new int[]{6,5,0}
        );
        sol.minSum(
                new int[]{2,0,2,0},
                new int[]{1,4}
        );



    }
}