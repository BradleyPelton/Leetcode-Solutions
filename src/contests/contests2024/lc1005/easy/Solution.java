package contests.contests2024.lc1005.easy;

// Accepted after 6 minutes
// First problem was a medium 4 pointer.

// Brute force. TODO - clever solution?

class Solution {
    public int maxGoodNumber(int[] nums) {

        StringBuilder abc = new StringBuilder();
        abc.append(Integer.toBinaryString(nums[0]));
        abc.append(Integer.toBinaryString(nums[1]));
        abc.append(Integer.toBinaryString(nums[2]));

        StringBuilder acb = new StringBuilder();
        acb.append(Integer.toBinaryString(nums[0]));
        acb.append(Integer.toBinaryString(nums[2]));
        acb.append(Integer.toBinaryString(nums[1]));

        StringBuilder bac = new StringBuilder();
        bac.append(Integer.toBinaryString(nums[1]));
        bac.append(Integer.toBinaryString(nums[0]));
        bac.append(Integer.toBinaryString(nums[2]));

        StringBuilder bca = new StringBuilder();
        bca.append(Integer.toBinaryString(nums[1]));
        bca.append(Integer.toBinaryString(nums[2]));
        bca.append(Integer.toBinaryString(nums[0]));

        StringBuilder cab = new StringBuilder();
        cab.append(Integer.toBinaryString(nums[2]));
        cab.append(Integer.toBinaryString(nums[0]));
        cab.append(Integer.toBinaryString(nums[1]));

        StringBuilder cba = new StringBuilder();
        cba.append(Integer.toBinaryString(nums[2]));
        cba.append(Integer.toBinaryString(nums[1]));
        cba.append(Integer.toBinaryString(nums[0]));

        int maxVal = Integer.MIN_VALUE;
        maxVal = Math.max(maxVal, Integer.parseInt(abc.toString(), 2));
        maxVal = Math.max(maxVal, Integer.parseInt(acb.toString(), 2));
        maxVal = Math.max(maxVal, Integer.parseInt(bac.toString(), 2));
        maxVal = Math.max(maxVal, Integer.parseInt(bca.toString(), 2));
        maxVal = Math.max(maxVal, Integer.parseInt(cab.toString(), 2));
        maxVal = Math.max(maxVal, Integer.parseInt(cba.toString(), 2));

        System.out.println(maxVal);
        return maxVal;


    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxGoodNumber(
                new int[]{1,2,3}
        );
        sol.maxGoodNumber(
                new int[]{2,8,16}
        );



    }
}
