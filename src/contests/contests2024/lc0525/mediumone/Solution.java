package contests.contests2024.lc0525.mediumone;

// ACcepted after 6 minutes
// Trivial. Annoying string indexing problem

class Solution {
    public String compressedString(String word) {


        StringBuilder ansBuilder = new StringBuilder();


        int index = 0;
        while (true) {
            char firstChar = word.charAt(index);
            int occ = 1;

            for (int i = index + 1; i < Math.min(index + 9, word.length()); i++) {
                if (word.charAt(i) == firstChar) {
                    occ++;
                } else {
                    break;
                }
            }

            index += occ;

            ansBuilder.append(occ);
            ansBuilder.append(firstChar);

            if (index == word.length()) {
                break;
            }
        }

        String ans = ansBuilder.toString();
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.compressedString("abcde");
        sol.compressedString("aaaaaaaaaaaaaabb");





    }
}
