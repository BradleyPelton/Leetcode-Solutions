package contests.contests2023.lc0114.easy;


// 3 minutes
// Trivial. Had to look up Integer.parseInt(String.valueOf(c)); though.
// char to int always tricks me up

class Solution {
    public int differenceOfSum(int[] nums) {

        int digitSum = 0;
        int totalSum = 0;

        for(int num : nums) {
            totalSum += num;

            String numAsString = String.valueOf(num);
            for (char c : numAsString.toCharArray()) {
                digitSum += Integer.parseInt(String.valueOf(c));
            }
        }

        int ans = Math.abs(digitSum - totalSum);
        System.out.println("ans = " + ans);
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.differenceOfSum(new int[]{1,15,6,3});
        sol.differenceOfSum(new int[]{1,2,3,4});
    }
}
