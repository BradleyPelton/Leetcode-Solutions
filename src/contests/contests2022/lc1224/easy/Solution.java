package contests.contests2022.lc1224.easy;

class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        if (words[startIndex].equals(target)) {
            System.out.println("zero");
            return 0;
        }
        
        // forward
        int forwardIndexMinDistance = Integer.MAX_VALUE;

        int currentIndex = startIndex + 1;
        int numberOfForwardSteps = 1;
        for (int i = 0; i < words.length - 1; i++) {
            currentIndex %= words.length;
            if (words[currentIndex].equals(target)) {
                break;
            } else {
                currentIndex++;
                numberOfForwardSteps++;
            }
        }

        int currentIndexBackward = startIndex - 1;
        int numberOfBackwardSteps = 1;
        for (int i = 0; i < words.length - 1; i++) {
            if (currentIndexBackward == -1) {
                currentIndexBackward = words.length - 1;
            }
            if (words[currentIndexBackward].equals(target)) {
                break;
            } else {
                currentIndexBackward--;
                numberOfBackwardSteps++;
            }
        }

        int ans = Math.min(numberOfBackwardSteps, numberOfForwardSteps);
        if (ans == words.length) {
            ans = -1; // SOlutoon not found
        }

        System.out.println("answer = " + ans);
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.closetTarget(new String[]{"hello","i","am","leetcode","hello"},
                "hello",
                1);

        sol.closetTarget(new String[]{"a","b","leetcode"},
                "leetcode",
                0);

        sol.closetTarget(new String[]{"i","eat","leetcode"},
                "ate",
                0);
    }
}
