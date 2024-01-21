package cheatsheet;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class JavaCheatsheet {
    public static void main(String[] args) {
        int n = 0;
        String word = "bob";
        String[] words = {"cat", "dog", "penguin"};
        String sentenceStr = "bob is a cat";
        int val = 42;
        int[] nums = {1, 2, 3};
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<String> stringList = List.of("a","b","def");
// =====================================================================================================================
// =====================================================================================================================
// =====================================================================================================================
        //Hashmap

        Map<Integer, Integer> occMap = new HashMap<>();
        for (int num : nums) {
            occMap.put(num, occMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> indicesMap = new HashMap<>();
        for (int num : nums) {
            indicesMap.computeIfAbsent(num, unused -> new ArrayList<>()).add(num);
        }
// =====================================================================================================================
// =====================================================================================================================
// =====================================================================================================================
        // PQ
        Queue<Double[]> arrivalPQ = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0].equals(b[0])) {
                return 0;
            } else {
                return 1;
            }
        });

        Queue<Integer[]> intArrPQ = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        Queue<Integer> intPQ = new PriorityQueue<>(Comparator.reverseOrder());

        Queue<String> stringPQ = new PriorityQueue<>(Comparator
                        .comparingInt(a -> ((String)a).length())
                        .thenComparing((b,c) -> ((String) b).compareTo((String) c))
        );


        // .isEmpty()
        // .poll() - pop the head
        // .peek() - retrieve head but don't pop
        // .add()/.offer()
// =====================================================================================================================
// =====================================================================================================================
// =====================================================================================================================
        // Custom Comparator inner class (Deprecated, use Comparator.comparingInt()
        Arrays.sort(grid, new java.util.Comparator<>() { // lambda is better here
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
// =====================================================================================================================
// =====================================================================================================================
// =====================================================================================================================
        // Streams
        // IntStream
        int sum = Arrays.stream(nums).sum();
        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int[] distinctNums = Arrays.stream(nums).distinct().toArray();
        int[] evenNums = Arrays.stream(nums).filter(x -> x % 2 == 0).toArray();
        long countOfFives = Arrays.stream(nums).filter(e -> e != 5).count();
        List<Integer> numsAsList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        // Stream<T>
        List<String> wordsAsList = Arrays.stream(words).collect(Collectors.toList());
        String[] sortedWords = (String[]) Arrays.stream(words).sorted(String.CASE_INSENSITIVE_ORDER).toArray();
        String[] strippedWords = (String[]) Arrays.stream(words).map(String::strip).toArray();

// =====================================================================================================================
// =====================================================================================================================
// =====================================================================================================================
        // List
        // int[] -> List<Integer>
        List<Integer> arrList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> arrList2 = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));

        // List<Integer> -> int[]
        int[] arr2 = arrList.stream().mapToInt(i -> i).toArray();

        // List<String> -> String[]
        String[] strArr = {"bob", "cat", "alice"};
        List<String> strList = new ArrayList<>(Arrays.asList(strArr));

        // String[] -> List<String>
        String[] strArrConvert = strList.toArray(new String[0]);
        List<String> strList2 = Arrays.stream(new String[]{"leet","code"}).collect(Collectors.toList());


        // int[][] -> List<List<Integer>>
        List<List<Integer>> dumb = Arrays.stream(new int[][]{{1,2,3},{4,5},{1,2,3}})
                .map(i -> Arrays.stream(i)
                        .boxed()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

// =====================================================================================================================
// =====================================================================================================================
// =====================================================================================================================
        // Arrays

        if (Arrays.binarySearch(nums, val) >= 0) {n++;}

        // binary insert , binaryInsert
        int pos = Collections.binarySearch(arrList, val);
        if (pos < 0) {
            arrList.add(-pos - 1, val); // not in
        } else {
            arrList.add(pos, val);
        }

        // sum 2d array
        int totalSum = Arrays.stream(grid).flatMapToInt(Arrays::stream).sum();

        // flatmap 2d array to 1d array

// =====================================================================================================================
// =====================================================================================================================
// =====================================================================================================================
        // StringBuilder
        String reversedWord = new StringBuilder(word).reverse().toString();

        StringBuilder sb = new StringBuilder(word);
        sb.append("other");
        String toString = sb.toString();
        sb.charAt(4);
        sb.deleteCharAt(4);
        
// =====================================================================================================================
// =====================================================================================================================
// =====================================================================================================================
        // char
        // char -> int
        // '5' -> 5
        char c = '5';
        int cAsInt = '5' - '0';
        int cAsINt = '5' - 48; // '0' == 48
        int cAsInt2 = c - 97; // 'a' = 97, b = '98', ... so `char - 97` will yield [0,25]
        int cAsInt3 = c - 'a'; // Since 'a' = 97, and since arithmetic operator automatically upcast to int, c-97=c-'a'
        int cAsInT = Character.getNumericValue(c);
        int cAsINT = Integer.parseInt(String.valueOf(c));;

        // digit -> char
        // 5 -> '5'
        int e = 5;
        char eAsChar = Character.forDigit(e, 10);

        // digitSum
        int digitSum = String.valueOf(val).chars().map(a -> a - 48).sum(); // 10 is the digit sum
        int digitSum2 = 0;
        while (val > 0) { // more efficient digit sum
            digitSum += val % 10;
            val /= 10;
        }


        // Unsorted
        char myChar = (char) 50;
        char myCHar = 50;

        // famous char values
        int aAsInt = 'a'; // 1
        int AAsInt = 'A'; //
        int zeroAsInt = '0'; // 48

        //  a,b,...,z lowercase
        for (char ch = 'a'; ch < 123; ch++) {continue;}
        //List<Character> lowerCaseAlphabet = ;
// =====================================================================================================================
// =====================================================================================================================
// =====================================================================================================================
        //String
        // reverse
        String reversedWord2 = new StringBuilder(word).reverse().toString();


        // REGEX
        String[] splitWords = sentenceStr.split("\\s+"); // split on space
        String[] splitWords2 = sentenceStr.split("[^\\w']+"); // split on NON APOSTROPHE
        String[] vals = sentenceStr.split("(?<=\\d)-"); // split on negative symbols that are preceded by a digit // `(?<=\\d)` SYMBOL BEFORE (lookback)
        

        // MISC
        String sub = word.substring(0, 3);
        boolean contains = sentenceStr.contains(word.toLowerCase());
        int len = word.length();
        char c3 = word.charAt(2);
        String lower = word.toLowerCase();
        String upper = word.toUpperCase();
        char[] chars = word.toCharArray();
        String catDog = word.replace("bob", "cat");
        for (char c2 : word.toCharArray()) {continue;}
// =====================================================================================================================
// =====================================================================================================================
// =====================================================================================================================
        //mod
        // 10**9 + 7

        final long rem = 1_000_000_007L;
        int nMod = (int)(n % rem);
// =====================================================================================================================
// =====================================================================================================================
// =====================================================================================================================
        // Big Integer Big Double
        BigInteger bigInt  = BigInteger.valueOf(54);
        BigInteger bigInt2  = new BigInteger("123456789123456789");
        BigInteger bigInt3 = bigInt.add(bigInt2);
                // .add
                // .subtract
                // .multiply
                // .pow
                // .modPow
// =====================================================================================================================
// =====================================================================================================================
// =====================================================================================================================

        }
}
