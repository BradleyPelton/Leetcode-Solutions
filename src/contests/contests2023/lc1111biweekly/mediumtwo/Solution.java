package contests.contests2023.lc1111biweekly.mediumtwo;

class Solution {
    public int stringCount(int n) {
        long ans = 1;
        final long rem = 1_000_000_007L;
        if (n < 4) {
            System.out.println("trivial lesss than 4");
            return 0;
        } else if (n != 4) {
            for (int i = 1; i <= (n - 4) ; i++) {
//                ans =  ((ans * 26) % rem);
                ans = ans * 26;
            }
        }
        // ans = (int) ((ans) % rem);

        for (int i = 1; i <= n; i++) {
//            ans = ((ans * i) % rem);
            ans = ans * i;
        }

        // since e's are swappable without yielding a unique solution
//        ans = (int) ((ans / 2) % rem);

        int ansAsInt = (int) ans;
        System.out.println(ansAsInt);
        return ansAsInt;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.stringCount(4);
        sol.stringCount(10);
    }
}