package contests.contests2024.lc1012biweekly.mediumone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Accepted at 10:42
// Accepted after first attempt

// Had trouble conceptualizing the problem

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, -1);
        dp.put(1, 0);
        dp.put(2, -1);

        // nums[i] is prime, no divisors,
        // nums[i] is therefore odd


        // MIN VALUE is (0,1,1,1) where last bit is at 4
        // MAX VALUE nums[i] ??? PROVE

        // There is always an answer for n > 2

        int[] ans = new int[n];
        OUTER_LOOP:
        for (int i = 0; i < n; i++) {
            int target = nums.get(i);
            if (dp.containsKey(target)) {
                ans[i] = dp.get(target);
                continue;
            }

            // 1 0 1 1 (11)
            // 1 0 0 1 (9) (ans)
            // 1 0 1 0 (10)

            // 1 1 1 1 1  (31)
            // 0 1 1 1 1  (15) (ans)
            // 1 0 0 0 0  (16)

            // 1 1 0 1  (13)
            // 1 1 0 0  (12) (ans)
            // 1 1 0 1  (13)

            String targetAsBinString = Integer.toBinaryString(target);
            int binStringLen = targetAsBinString.length();
            int lastConsecutiveOne = 0;
            for (int j = binStringLen - 1; j >= 0; j--) {
                if (targetAsBinString.charAt(j) != '1') {
                    lastConsecutiveOne = j + 1;
                    break;
                }
            }

            StringBuilder ansBuilder = new StringBuilder(binStringLen);
            if (lastConsecutiveOne == 0) {
                ansBuilder.append('0');
                for (int j = 1; j < binStringLen; j++) {
                    ansBuilder.append('1');
                }
            } else {
                for (int j = 0; j < lastConsecutiveOne; j++) {
                    if (targetAsBinString.charAt(j) == '1') {
                        ansBuilder.append('1');
                    } else {
                        ansBuilder.append('0');
                    }
                }

                // lastConsecutiveOne
                ansBuilder.append('0');
                for (int j = lastConsecutiveOne + 1; j < binStringLen; j++) {
                    ansBuilder.append('1');
                }
            }

            int localAns = Integer.parseInt(ansBuilder.toString(), 2);
            ans[i] = localAns;
            dp.put(target, localAns);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minBitwiseArray(List.of(2,3,5,7));
        sol.minBitwiseArray(List.of(11,13,31));



    }
}