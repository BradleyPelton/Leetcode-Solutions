package contests.contests2021.lc1204.easy;

import java.util.Arrays;
import java.util.HashSet;

// Time limit exceeded on a fucking easy

// Accepted after 29 minutes
// Fucking difficult easy. Hardest easy I have seen in months

// Very rare the brute force doesnt work for an easy

class Solution {
    public int[] findEvenNumbers(int[] digits) {

        HashSet<Integer> ansStrings = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            int thirdDigit = digits[i];
            if (thirdDigit % 2 != 0) {
                continue;
            }

            for (int j = 0; j < digits.length; j++) {
                int secondDigit = digits[j];
                for (int k = 0; k < digits.length; k++) {
                    int firstDigit = digits[k];
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    if (firstDigit == 0) {
                        continue;
                    } else {
                        Integer digitConcat = firstDigit*100 + secondDigit*10 + thirdDigit;
                        ansStrings.add(digitConcat);
                    }
                }
            }
        }

//        System.out.println(ansStrings);

        int[] ans = new int[ansStrings.size()];

        int i = 0;
        for (Integer e : ansStrings) {
            ans[i] = e;
            i++;
        }
        Arrays.sort(ans);
//        System.out.println(Arrays.toString(ans));

        return ans;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.findEvenNumbers(new int[]{2,1,3,0});
        sol.findEvenNumbers(new int[]{2,2,8,8,2});
        sol.findEvenNumbers(new int[]{3,7,5});
        sol.findEvenNumbers(new int[]{0,2,0,0});
        sol.findEvenNumbers(new int[]{0,0,0});
    }
}
