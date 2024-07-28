package contests.contests2024.lc0720.easy;

// Accepted fist attempt
// Accepted after 7 minutes
// Tricky easy. I should have used bit operators instead of .toBinaryString()

//

class Solution {
    public int minChanges(int n, int k) {

        StringBuilder nAsString = new StringBuilder(Integer.toBinaryString(n));
        StringBuilder kAsString = new StringBuilder(Integer.toBinaryString(k));

        while (nAsString.length() > kAsString.length()) {
            kAsString.insert(0, '0');
        }




        int ans = 0;
        for (int i = 0; i < nAsString.length(); i++) {
            if (nAsString.charAt(i) == '1') {
                if (kAsString.charAt(i) == '0') {
                    ans++;
                    nAsString.setCharAt(i, '0');
                }
            }
        }

        boolean equalString = nAsString.toString().equals(kAsString.toString());
        if (equalString) {
            System.out.println(ans);
            return ans;
        } else {
            System.out.println("-1");
            return -1;
        }
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minChanges(13, 4);
        sol.minChanges(21, 21);
        sol.minChanges(14, 13);




    }
}
