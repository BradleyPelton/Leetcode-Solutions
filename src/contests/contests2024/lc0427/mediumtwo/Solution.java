package contests.contests2024.lc0427.mediumtwo;

// Accepted after 22 minutes
// Cool binary problem. had to take a few minutes to think about it.

// A clean solution would have used shift operators >>, <<, but the string indexing always feels more natural

class Solution {
    public long minEnd(int n, int x) {
        if (n == 1) {
            System.out.println(x);
            return x;
        }

        // every num in the array has to have the same bits set as

        // nums[0] = x;
        // nums[1] = x;

        StringBuilder ansString = new StringBuilder(Integer.toBinaryString(x)).reverse();
        StringBuilder nString = new StringBuilder(Integer.toBinaryString(n - 1)).reverse();

        int nIndex = 0;
        for (int i = 0; i < ansString.length(); i++) {
            if (ansString.charAt(i) == '0') {
                if (nString.charAt(nIndex) == '1') {
                    ansString.setCharAt(i, '1');
                }
                nIndex++;

                if (nIndex == nString.length()) {
                    break;
                }
            }
        }

        while (nIndex < nString.length()) {
            ansString.append(nString.charAt(nIndex));
            nIndex++;
        }

        String ansReversed = ansString.reverse().toString();
        long ans = Long.parseLong(ansReversed, 2);
        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.minEnd(3, 4);
        sol.minEnd(2, 7);



    }
}
