package contests.contests2023.lc0513.mediumone;

// Accepted after 45 minutes
// Not a fan of Binary problems

class Solution {
    public boolean doesValidArrayExist(int[] derived) {


        if (derived.length == 1) {
            System.out.println("trivial 1 length");
            if (derived[0] == 1) {
                return false;
            }
            return true;
        }

        // Starts with either zero or one
        // starting with derived[0] = 0
        int[] originalZero = new int[derived.length];
        originalZero[0] = 0;

        for (int i = 0; i < derived.length - 1; i++) {
            int derivedVal = derived[i];
            int originalVal;

            if (i == derived.length - 1) {
                originalVal = originalZero[0];
            } else {
                originalVal = originalZero[i];
            }

            if (derivedVal == 0) {
                if (originalVal == 0) {
                    originalZero[i+1] = 0;
                } else {
                    originalZero[i+1] = 1;
                }
            } else {
                // else derivedVal == 1
                if (originalVal == 0) {
                    originalZero[i+1] = 1;
                } else { // else originalVal == 1
                    originalZero[i+1] = 0;
                }
            }
        }

        // else
        // starting with derived[0] = 1
        int[] originalOne = new int[derived.length];
        originalOne[0] = 1;

        for (int i = 0; i < derived.length - 1; i++) {
            int derivedVal = derived[i];
            int originalVal;
            if (i == derived.length - 1) {
                originalVal = originalZero[0];
            } else {
                originalVal = originalZero[i];
            }

            if (derivedVal == 0) {
                if (originalVal == 0) {
                    originalOne[i+1] = 1;
                } else {
                    originalOne[i+1] = 0;
                }
            } else {
                // else derivedVal == 1
                if (originalVal == 0) {
                    originalOne[i+1] = 0;
                } else { // else originalVal == 1
                    originalOne[i+1] = 1;
                }
            }
        }

        boolean isZeroConsistent = true;
        boolean isOneConsistent = true;
        for (int i = 0; i < derived.length; i++) {
            int expectedVal = derived[i];
            int zeroVal;
            int oneVal;

            if (i == derived.length - 1) {
                zeroVal = originalZero[i] ^ originalZero[0];
                oneVal = originalOne[i] ^ originalOne[0];
            } else {
                zeroVal = originalZero[i] ^ originalZero[i+1];
                oneVal = originalOne[i] ^ originalOne[i+1];
            }

            if (expectedVal != zeroVal) {
                isZeroConsistent = false;
            }
            if (expectedVal != oneVal) {
                isOneConsistent = false;
            }
        }

        System.out.println("isZeroConsistent = " + isZeroConsistent);
        System.out.println("isOneConsistent = " + isOneConsistent);
        System.out.println("-------");

        return isZeroConsistent || isOneConsistent;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.doesValidArrayExist(new int[]{1,1,0}); // true
        sol.doesValidArrayExist(new int[]{1,1});  //true
        sol.doesValidArrayExist(new int[]{1,0});  //false
        sol.doesValidArrayExist(new int[]{1});
        sol.doesValidArrayExist(new int[]{0});
        sol.doesValidArrayExist(new int[]{0,0,1}); // expected false
    }
}