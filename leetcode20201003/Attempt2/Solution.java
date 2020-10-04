package Attempt2;

// Accepted after 43 minutes. I don't know why I struggled with this one.
// Just starting fresh and coming up with a really brute force solution ended up working.
// I'm curious what the fast solutions look like for this.
// NOTE: The extra time it took me to compelete this wasnt because of Java. I was just blanking on figuring out a
// solution that worked.

class Solution {
    public int specialArray(int[] nums) {

        int specialValue = -1;
        for (int i = 0; i < (nums.length + 2); i++) {
            int numsGreaterOrEqual = 0;
            for (int e : nums) {
                if (e >= i) {
                    numsGreaterOrEqual++;
                }
            }

            if (numsGreaterOrEqual == i) {
                specialValue = i;
//                System.out.println("Found a special value " + i);
            }
        }
        System.out.println(specialValue);
        return specialValue;
    }
}


class Tests {
    public static void main(String[] args) {
        int[] first = {3,5};
        int[] second = {0,0};
        int[] third = {0,4,3,0,4};
        int[] fourth = {3,6,7,7,0};

        Solution sol = new Solution();
        sol.specialArray(first);
        sol.specialArray(second);
        sol.specialArray(third);
        sol.specialArray(fourth);
    }
}