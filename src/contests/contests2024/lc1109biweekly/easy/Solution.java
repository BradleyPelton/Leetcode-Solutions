package contests.contests2024.lc1109biweekly.easy;

// Accepted after 2 minutes
// Accepted first attempt

// COol easy problem. Brute forced, but theres gotta be a cool solution

class Solution {
    public int smallestNumber(int n, int t) {

        for (int i = n; i < 10_000_000; i++) {
            int prod = getDigitProduct(i);

            if (prod % t == 0) {
                System.out.println(i);
                return i;
            }
        }

        System.out.println("no answer!");
        return -1;
    }

    private int getDigitProduct(int val) {
        int product = 1;
        while (val > 0) { // more efficient digit sum
            product *= (val % 10);
            val /= 10;
        }
        return product;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.smallestNumber(10, 2);
        sol.smallestNumber(15, 3);



    }
}
