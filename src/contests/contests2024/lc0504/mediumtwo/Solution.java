package contests.contests2024.lc0504.mediumtwo;

import java.util.HashMap;
import java.util.Map;

// Accepted after 14 minutes
// Cool math problem. GCD(a,b,c,d) = gcd(gcd(gcd(a,b),c),d));

class Solution {
    public int minAnagramLength(String s) {
        Map<Character, Integer> occMap = new HashMap<>();
        int gcd = Integer.MAX_VALUE;
        for (char c : s.toCharArray()) { // O(N)
            int updatedOcc = occMap.getOrDefault(c, 0) + 1;
            gcd = updatedOcc;
            occMap.put(c, updatedOcc);
        }

        for (int val : occMap.values()) { // O(26) == O(1)
            gcd = getGCD(gcd, val);
        }

        int ans = 0;
        for (int val : occMap.values()) { // O(26) == O(1)
            ans += (val / gcd);
        }
        System.out.println(ans);
        return ans;
    }

    public static int getGCD(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minAnagramLength("abba");
        sol.minAnagramLength("cdef");





    }
}
