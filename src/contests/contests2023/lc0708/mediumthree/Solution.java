package contests.contests2023.lc0708.mediumthree;

// First attempt wrong answer
// Second attempt TLE;


// Third attempt accepted
// Removed extra for loop at the end and Accepted
// Super duper ultra rare, skip first and second medium, go straight to third medium (5 pointer)

class Solution {
    public boolean checkArray(int[] nums, int k) {

        for (int i = 0; i < nums.length - k + 1; i++) {
            int currVal = nums[i];

            if (currVal == 0) {
                // skip
                continue;
            } else if (currVal < 0) {
                System.out.println("found an impossibility at index i = " + i);
                return false;
            } else {
                for (int j = 0; j < k; j++) {
                    nums[i + j] -= currVal;
                }
            }
        }

        for (int i = nums.length - k; i < nums.length; i++) {
            if (nums[i] != 0) {
                System.out.println("AFTERALL, found an impossibility at index i = " + i);
//                System.out.println("end reached, arr = " + Arrays.toString(nums));
                return false;
            }
        }

//        System.out.println("end reached, arr = " + Arrays.toString(nums));
        return true;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.checkArray(new int[]{2,2,3,1,1,0}, 3);
//        sol.checkArray(new int[]{1,3,1,1}, 2);
        sol.checkArray(new int[]{60,72,87,89,63,52,64,62,31,37,57,83,98,94,92,77,94,91,87,100,91,91,50,26}, 4);

    }
}