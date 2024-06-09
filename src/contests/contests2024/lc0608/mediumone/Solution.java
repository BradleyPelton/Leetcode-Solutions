package contests.contests2024.lc0608.mediumone;

import java.util.Arrays;

// Accepted first attempt
// Accepted after 6 minutes
// Trivial simulation

class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        final long rem = 1_000_000_007L;


        for (int i = 0; i < k; i++) {
            int prevSum = 0;
            for (int j = 0; j < n; j++) {
                int temp = arr[j];
                arr[j] = (int)((arr[j] + prevSum) % rem);
                prevSum = (int)((prevSum + temp) % rem);
            }
        }

        int ans = arr[n - 1];
//        System.out.println(ans);
        return ans;

    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.valueAfterKSeconds(
                4,
                5
        );
        sol.valueAfterKSeconds(
                5,
                3
        );




    }
}
