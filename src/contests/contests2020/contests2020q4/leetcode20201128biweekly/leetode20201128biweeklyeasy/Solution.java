package contests2020q4.leetcode20201128biweekly.leetode20201128biweeklyeasy;

// Accepted after first attempt
// Accepted after 18 minutes (9:48 am EST)

// SLoppy that this took me 18 minutes. Kind of an contests2020q4.leetcode20201226biweekly.easy problem
//  I stumbled on handling the index properly. A try catch was a nice solution
// Apparently a lot of people struggled with this problem though (only 1400 people were faster)

class Solution {
    public int maxRepeating(String sequence, String word) {

        int maxAns = 0;
        int localAns = 0;

        for (int i = 0; i < sequence.length() - word.length() +1; i++){
            String tempSubString = sequence.substring(i, i + word.length());
//            System.out.println("temp(matched) substring is equal to " + tempSubString);
            if (tempSubString.equals(word)){
                localAns += 1;
                int newIndex = i;
                String newIndexSubString;
                while (true){
                    newIndex += word.length();

                    try {
                        newIndexSubString = sequence.substring(newIndex, newIndex + word.length());
                    } catch (StringIndexOutOfBoundsException s){
                        break;
                    }
//                    System.out.println("new index substring is equal to " + newIndexSubString);
                    if (newIndexSubString.equals(word)){
                        localAns += 1;
                    } else {
                        break;
                    }
                }
                    if (localAns > maxAns){
                        maxAns = localAns;
                    }

                    localAns = 0;
            }
        }

        System.out.println("final answer is " + maxAns);
        return maxAns;
    }
}

class Tests{
    public static void main(String[] args) {
        Solution sol = new Solution();

        String firstSeq = "ababc";
        String secondSeq = "ababc";
        String thirdSeq = "ababc";
        String firstWord = "ab";
        String secondWord = "ba";
        String thirdWord = "ac";

        sol.maxRepeating(firstSeq, firstWord);
        sol.maxRepeating(secondSeq, secondWord);
        sol.maxRepeating(thirdSeq, thirdWord);
    }
}