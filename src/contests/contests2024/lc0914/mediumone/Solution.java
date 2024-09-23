package contests.contests2024.lc0914.mediumone;

// First attempt: TLE
// Second attempt: TLE
// Third attempt: TLE

class Solution {
    public long maxScore(int[] a, int[] b) {
        int n = b.length;

        long ans = Long.MIN_VALUE;
        long firstMin = Long.MAX_VALUE;
        long firstMax = Long.MIN_VALUE;
        long secondMin = Long.MAX_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMin = Long.MAX_VALUE;
        long thirdMax = Long.MIN_VALUE;
        long fourthMin = Long.MAX_VALUE;
        long fourthMax = Long.MIN_VALUE;


        FIRST_LOOP:
        for (int firstIndex = 0; firstIndex < n - 3; firstIndex++) {
            if (a[0] == 0) {
                if (firstIndex != 0) {
                    break FIRST_LOOP;
                }
            } else if (a[0] > 0) {
                if (b[firstIndex] < firstMax) {
                    continue FIRST_LOOP;
                }
                firstMax = Math.max(b[firstIndex], firstMax);
            } else {
                if (b[firstIndex] > firstMin) {
                    continue FIRST_LOOP;
                }
                firstMin = Math.min(b[firstIndex], firstMin);
            }
            long firstVal = ((long)a[0]) * b[firstIndex];

            SECOND_LOOP:
            for (int secondIndex = firstIndex + 1; secondIndex < n - 2; secondIndex++) {
                if (a[1] == 0) {
                    if (secondIndex != firstIndex + 1) {
                        break SECOND_LOOP;
                    }
                } else if (a[1] > 0) {
                    if (b[secondIndex] < secondMax) {
                        continue SECOND_LOOP;
                    }
                    secondMax = Math.max(b[secondIndex], secondMax);
                } else {
                    if (b[secondIndex] > secondMin) {
                        continue SECOND_LOOP;
                    }
                    secondMin = Math.min(b[secondIndex], secondMin);
                }
                long secondVal = ((long)a[1]) * b[secondIndex];

                THIRD_LOOP:
                for (int thirdIndex = secondIndex + 1; thirdIndex < n - 1; thirdIndex++) {
                    if (a[2] == 0) {
                        if (thirdIndex != secondIndex + 1) {
                            break THIRD_LOOP;
                        }
                    } else if (a[2] > 0) {
                        if (b[thirdIndex] < thirdMax) {
                            continue THIRD_LOOP;
                        }
                        thirdMax = Math.max(b[thirdIndex], thirdMax);
                    } else {
                        if (b[thirdIndex] > thirdMin) {
                            continue THIRD_LOOP;
                        }
                        thirdMin = Math.min(b[thirdIndex], thirdMin);
                    }

                    long thirdVal = ((long)a[2]) * b[thirdIndex];

                    FOURTH_LOOP:
                    for (int fouthIndex = thirdIndex + 1; fouthIndex < n; fouthIndex++) {
                        if (a[3] == 0) {
                            if (fouthIndex != thirdIndex + 1) {
                                break FOURTH_LOOP;
                            }
                        } else if (a[3] > 0) {
                            if (b[fouthIndex] < fourthMax) {
                                continue FOURTH_LOOP;
                            }
                            fourthMax = Math.max(b[fouthIndex], fourthMax);
                        } else {
                            if (b[fouthIndex] > fourthMin) {
                                continue FOURTH_LOOP;
                            }
                            fourthMin = Math.min(b[fouthIndex], fourthMin);
                        }

                        long fourthVal =  ((long)a[3]) * b[fouthIndex];

                        long localAns = firstVal + secondVal + thirdVal + fourthVal;
                        ans = Math.max(ans, localAns);
                    }
                }
            }
        }

        System.out.println(ans);
        return ans;
    }

//    int[] a;
//    int[] b;
//    int n;
//    Long[][] dp;
//    public long maxScore(int[] a, int[] b) {
//        this.a = a;
//        this.b = b;
//        this.n = b.length;
//        dp = new Long[n + 1][4];
//        // Split b into 4 subarrays
//
//        long ans = topDownDP(0, 0);
//        System.out.println(ans);
//        return ans;
//    }
//
//
//    public long topDownDP(int index, int aIndex) {
//        if (index >= n) {
//            if (aIndex >= 4) {
//                return 0;
//            } else {
//                return Long.MIN_VALUE;
//            }
//        } else if (aIndex >= 4) {
//            return 0;
//        }
//        if (dp[index][aIndex] != null) {
//            return dp[index][aIndex];
//        }
//
//
//        long aVal = a[aIndex];
//        long ans = Long.MIN_VALUE;
//        if (aVal == 0) {
//            ans = topDownDP(index + 1, aIndex + 1);
//        } else if (aVal > 0) {
//
//            long maxValSoFar = Long.MIN_VALUE;
//            for (int i = index; i < n; i++) {
//                if (b[i] < maxValSoFar) {
//                    continue;
//                }
//                maxValSoFar = Math.max(maxValSoFar, b[i]);
//                long localAns = topDownDP(i + 1, aIndex + 1);
//                if (localAns != Long.MIN_VALUE) {
//                    localAns += aVal * b[i];
//                    ans = Math.max(ans, localAns);
//                }
//            }
//
//
//        } else { // aVal < 0
//
//            long minValSoFar = Long.MAX_VALUE;
//            for (int i = index; i < n; i++) {
//                if (b[i] > minValSoFar) {
//                    continue;
//                }
//                minValSoFar = Math.min(minValSoFar, b[i]);
//                long localAns = topDownDP(i + 1, aIndex + 1);
//                if (localAns != Long.MIN_VALUE) {
//                    localAns += aVal * b[i];
//                    ans = Math.max(ans, localAns);
//                }
//            }
//        }
//
//        dp[index][aIndex] = ans;
//        return ans;
//    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxScore(
                new int[]{3,2,5,6},
                new int[]{2,-6,4,-5,-3,2,-7}
        );
        sol.maxScore(
                new int[]{-1,4,5,-2},
                new int[]{-5,-1,-3,-2,-4}
        );
        sol.maxScore(
                new int[]{10,-9,-9,10},
                new int[]{-4,6,6,8,0,6,-4,6,-6}
        ); // 176





    }
}