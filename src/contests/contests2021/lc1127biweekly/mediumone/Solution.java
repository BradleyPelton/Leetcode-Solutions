package contests.contests2021.lc1127biweekly.mediumone;

class Solution {
    public int minimumBuckets(String street) {

        if (street.length() == 1) {
            if ("H".equals(street)) {
                System.out.println("impossible street, street = " + street);
                return -1;
            } else {
                return 0;
            }
        } else if (street.length() == 2) {
            if ("H.".equals(street) || ".H".equals(street)) {
                return 1;
            } else if ("..".equals(street)) {
                return 0;
            } else {
                System.out.println("impossible 2 length street, sstreet = " + street);
                return -1;
            }
        }


        int bucketsNeeded = 0;

        String[] splitStreet = street.split("H\\.H");
//        System.out.println(Arrays.toString(splitStreet));

        bucketsNeeded += splitStreet.length - 1;

        for (String word : splitStreet) {

            if (word.length() == 0) {
                continue;
            } else if (word.length() == 1) {
                if (word.charAt(0) == 'H') {
                    System.out.println("impossible 1 length word, word = " + word);
                    return -1;
                } else {
                    continue;
                }
            } else if (word.length() == 2) {
                if ("H.".equals(word) || ".H".equals(word)) {
                    bucketsNeeded++;
                    continue;
                } else if ("..".equals(word)) {
                    continue;
                } else {
                    System.out.println("impossible 2 length word, word = " + word);
                    return -1;
                }
            }

            // each word will not contain "H.H"
            // meaning if currSpot = ., then either spot before or spot after is not H

            // the split substrings will never inherit a free bucket from a removed "H.H" substring

            char prevSpot = word.charAt(0);
            char currSpot = word.charAt(1);
            char nextSpot = 'X';

            // Handle first case
            if (prevSpot == 'H') {
                if (currSpot == '.') {
                    bucketsNeeded++;
                } else {
                    System.out.println("impossible preloop condition, word = " + word);
                    return -1;
                }
            }
            for (int i = 2; i < word.length() - 1; i++) {
                nextSpot = word.charAt(i);

//                if (spot == 'H') {
////                    if (prevIsBucket) {
////                        prevIsBucket = false;
////                        continue;
////                    }
//                } else
                if (currSpot == '.') {
                    if (prevSpot == 'H' || nextSpot == 'H') {
                        bucketsNeeded++;
                    }
                }

                if (currSpot == 'H') {
                    if (prevSpot != '.' && nextSpot != '.') {
                        System.out.println("impossible word during word loop, word = " + word);
                        return -1;
                    }
                }

                prevSpot = currSpot;
                currSpot = nextSpot;
            }

            // handle the last spot
            if (currSpot == 'H') {
                if (nextSpot =='H') {
                    System.out.println("impossible last char, word = " + word);
                    return -1;
                } else if (nextSpot == '.') {
                    bucketsNeeded++;
                }
            }
        }

        System.out.println("final ans = " + bucketsNeeded);
        return bucketsNeeded;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

//        sol.minimumBuckets("H..H");
//        sol.minimumBuckets(".H.H.");
//        sol.minimumBuckets(".HHH.");
//        sol.minimumBuckets("H");
//        sol.minimumBuckets(".");

//        sol.minimumBuckets(".......HH"); // expeceted -1;

        sol.minimumBuckets(".....H.....");  // expected 1
    }
}