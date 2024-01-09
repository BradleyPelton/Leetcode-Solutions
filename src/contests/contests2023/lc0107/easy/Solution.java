package contests.contests2023.lc0107.easy;

class Solution {
    public int maximumCount(int[] nums) {

//        int indexOfZero = Arrays.binarySearch(nums, 0);
//
        final int numberOfPositiveNumberes;
        final int numberOfNegativeNumbers;
//        if (indexOfZero > 0) {
//            numberOfNegativeNumbers = indexOfZero;
//            numberOfPositiveNumberes = nums.length - indexOfZero - 1;
//        } else if (indexOfZero == 0) { // Zero is the first element
//            numberOfNegativeNumbers = 0;
//            numberOfPositiveNumberes = nums.length - 1;
//        } else {
//            int insertIndex =
//        }

        int numberOfNegative = 0;
        int numberOfZeroes = 0;
        int numberOfPostiives = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                numberOfNegative++;
            } else if (nums[i] == 0) {
                numberOfZeroes++;
            } else {
                numberOfPostiives++;
            }
        }

        int ans = Math.max(numberOfNegative, numberOfPostiives);
        System.out.println("ans  = " + ans);
        return ans;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumCount(new int[]{-2,-1,-1,1,2,3});
        sol.maximumCount(new int[]{-3,-2,-1,0,0,1,2});
        sol.maximumCount(new int[]{5,20,66,1314});
    }
}
