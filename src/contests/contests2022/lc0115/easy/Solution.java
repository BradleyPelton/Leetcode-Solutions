package contests.contests2022.lc0115.easy;

// Accepted after 11 minutes
// Longer than normal easy problem

class Solution {
    public String[] divideString(String s, int k, char fill) {

        int numWholeGroups = s.length() / k;

        boolean partialGroup = false;
        String[] ans;
        if (numWholeGroups * k < s.length()) {
            partialGroup = true;
            ans = new String[numWholeGroups + 1];
        } else {
            ans = new String[numWholeGroups];
        }


        for (int i = 0; i < numWholeGroups; i++) {
            ans[i] = s.substring(i*k, i*k + k);
        }

        if (partialGroup) {
            String unWholeGroup = s.substring(k*numWholeGroups);
            StringBuilder sb = new StringBuilder(unWholeGroup);
            while(sb.length() < k) {
                sb.append(fill);
            }

            ans[numWholeGroups] = sb.toString();
        }

//        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.divideString("abcdefghi", 3, 'x');
        sol.divideString("abcdefghij", 3, 'x');

    }
}
