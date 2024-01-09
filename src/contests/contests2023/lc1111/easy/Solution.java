package contests.contests2023.lc1111.easy;

// Accepted after 2 minutes
// Brute Force


class Solution {
    public int maximumStrongPairXor(int[] nums) {

        int greatestXOR = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int leftVal = nums[i];
            for (int j = 0; j < nums.length; j++) {
                int rightVal = nums[j];
                if (Math.abs(leftVal - rightVal) <= Math.min(leftVal, rightVal)) {
                    greatestXOR = Math.max(greatestXOR, leftVal ^ rightVal);
                }
            }
        }

        System.out.println(greatestXOR);
        return greatestXOR;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumStrongPairXor(new int[]{1,2,3,4,5});
        sol.maximumStrongPairXor(new int[]{10,100});
        sol.maximumStrongPairXor(new int[]{5,6,25,30});




    }
}