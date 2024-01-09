package contests.contests2023.lc1111biweekly.easy;

// 35 minutes for an easy/
// I tried the recursive solution and fell flat on my face
// I need to study probability. This was the lognest I took on an easy in months.

class Solution {
    public int distributeCandies(int n, int limit) {
        if (limit * 3 < n) {
            System.out.println("too many candies");
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < limit + 1; i++) {
            for (int j = 0; j < limit + 1; j++) {
                for (int k = 0; k < limit + 1; k++) {
                    if (i + j + k == n) {
                        ans++;
                    }
                }

            }

        }
        System.out.println(ans);
        return ans;
    }

//    private int recurse(int n, int limit, int childOne, int childTwo, int childThree) {
//        if (childOne == limit) {
//            if (childTwo == limit) {
//                if (childThree == limit) {
//                    return 0; // exit
//                } else { // three
//                    return recurse(n, limit, childOne, childTwo, childThree + 1) + 1;
//                }
//            } else {
//                if (childThree == limit) { // two only
//                    return recurse(n, limit, childOne, childTwo + 1, childThree) + 1;
//                } else { // two and three
//                    return recurse(n, limit, childOne, childTwo + 1, childThree) + 1 +
//                            recurse(n, limit, childOne, childTwo, childThree + 1) + 1;
//                }
//            }
//        } else if (childTwo == limit) {
//            // childOne != limit
//            if (childThree == limit) { // one
//                return recurse(n, limit, childOne + 1, childTwo, childThree) + 1;
//            } else { // one and three
//                return recurse(n, limit, childOne + 1, childTwo, childThree) + 1 +
//                        recurse(n, limit, childOne, childTwo, childThree + 1) + 1;
//            }
//        } else if (childThree == limit) {
//            // else childOne != limit and childTwo != limit
//                return recurse(n, limit, childOne + 1, childTwo, childThree) + 1 +
//                        recurse(n, limit, childOne, childTwo + 1, childThree) + 1;
//        } else { // none at are at limit
//            return recurse(n, limit, childOne + 1, childTwo, childThree) + 1 +
//                    recurse(n, limit, childOne, childTwo + 1, childThree) + 1 +
//                    recurse(n, limit, childOne, childTwo, childThree + 1) + 1;
//        }
//    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.distributeCandies(5, 2);
        sol.distributeCandies(3, 3);





    }
}
