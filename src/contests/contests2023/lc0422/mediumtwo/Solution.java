package contests.contests2023.lc0422.mediumtwo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

// First Attempt TLE
//

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {

        ArrayList<Integer> e = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));

        int[] ans = new int[nums.length - k + 1];

        // Keep track of how many negative numbers
        //
        List<Integer> window = new ArrayList<>();
        int numberOfNegativeNumbers = 0;

        for (int i = 0; i < k; i++) {
            if (nums[i] < 0) {
                numberOfNegativeNumbers++;
            }
            window.add(nums[i]);

        }

        Collections.sort(window);

        if (numberOfNegativeNumbers < x) {
            ans[0] = 0;
        } else {
            ans[0] = window.get(x - 1);
        }

        for (int i = 1; i < nums.length - k + 1; i++) {
            int nextNumber = nums[k + i - 1];

            int numberBeingRemoved = nums[i - 1];
            // remove old number
            if (numberBeingRemoved < 0) {
                numberOfNegativeNumbers--;
            }
            window.remove(Integer.valueOf(numberBeingRemoved));

            if (nextNumber < 0) {
                numberOfNegativeNumbers++;
            }

            // Add new number
            int pos = Collections.binarySearch(window, nextNumber);
            if (pos < 0) {
                window.add(-pos-1, nextNumber);
            } else {
                window.add(pos, nextNumber);
            }



            int beautyNumber;
            if (numberOfNegativeNumbers < x) {
                beautyNumber = 0;
            } else {
                beautyNumber = window.get(x - 1);
            }
            ans[i] = beautyNumber;
        }

//        System.out.println("ans = " + Arrays.toString(ans));
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.getSubarrayBeauty(
                new int[]{1,-1,-3,-2,3},
                3,
                2
        );
        sol.getSubarrayBeauty(
                new int[]{-1,-2,-3,-4,-5},
                2,
                2
        );
        sol.getSubarrayBeauty(
                new int[]{-3,1,2,-3,0,-3},
                2,
                1
        );
    }

    private static void m2() throws IOException, IllegalStateException, TimeoutException {
        throw new FileNotFoundException("a");
    }
}