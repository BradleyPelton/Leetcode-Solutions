package contests.contests2022.lc0326.mediumone;

// I fumbledm around with indices for an hour

// I deleted my answer and restarted 3 time
// Sloppy index handling, trying to rush through the answer.

class Solution {
    public int minDeletion(int[] nums) {

        // Worst case scenario, we arrive at a beautiful array who has odd length
        // Removing an element would make the array no longer beautiful

        // THEORY: It doesnt matter which element you remove, nums[i] or nums[i+1]
        // THEORY: Ignore worst case scenario. Nothing we can do. Brute force the worst case scenario

        // WAIT: Theory +1: Once we arrive at worse cast scenario, we can just pop an element off the end and we are
        // still guaranteed a beautiful array


//        nums[i] != nums[i+1] for even i

//        nums[0] != nums[1]
//        nums[2] != nums[3]
//        nums[4] != nums[5]



        int numOfDeletions = 0;
        int previousInt = nums[0];
        boolean previousIndexIsEven = true;

        for (int i = 1; i < nums.length; i++) {
            if (previousIndexIsEven) {
                // If previous index was even, validate against duplicate
                if (nums[i] == previousInt) {
                    numOfDeletions++;
                    // Don't toggle previousIndexIsEven, if the next char is still duplicate we have to keep removing
                } else {
                    // append and toggle
                    previousIndexIsEven = false;
                    previousInt = nums[i];
                }
            } else {
                // If previous index was not even, we can simply append
                previousIndexIsEven = true;
                previousInt = nums[i];
            }
        }

//        System.out.println("ans after for loop " + numOfDeletions);

        if ((nums.length - numOfDeletions) % 2 == 1) {
            numOfDeletions++;
        }

        System.out.println("final ans = " + numOfDeletions);
        return numOfDeletions;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minDeletion(new int[]{1,1,2,3,5});
        sol.minDeletion(new int[]{1,1,2,2,3,3});
        sol.minDeletion(new int[]{62907,1362});
    }
}