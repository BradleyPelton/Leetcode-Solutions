package contests.contests2023.lc1028.easy;


// Accepted after 16 minutes
// Fucking binary problems are annoying
// I need to study here.
//

class Solution {
    public int findKOr(int[] nums, int k) {

        String[] binNums = new String[nums.length];


        for (int i = 0; i < nums.length; i++) {
            String bin = Integer.toBinaryString(nums[i]);
            binNums[i] = bin;
//            for (int i = 0; i < ; i++) {
//                // is the i-th bit set?
//                boolean isBitSet = (((int) Math.pow(2, i)) & num) == Math.pow(2, i);
//                if (isBitSet) {
//                    kthBitIsSet[i]++;
//                }
//            }
        }

        int[] kBitsSet = new int[10000];
        for (String binString : binNums) {
            for (int i = 0; i < binString.length(); i++) {
                if (binString.charAt(binString.length() - 1 - i) == '1') {
                    kBitsSet[i]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 10000; i++) {
            if (kBitsSet[i] >= k) {
                ans += Math.pow(2, i);
            }

        }

        return ans;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findKOr(new int[]{7,12,9,8,9,15}, 4));
        System.out.println(sol.findKOr(new int[]{2,12,1,11,4,5}, 6));
        System.out.println(sol.findKOr(new int[]{10,8,5,9,11,6,8}, 1));
    }
}
