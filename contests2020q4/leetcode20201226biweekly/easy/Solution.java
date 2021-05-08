package leetcode20201216biweekly.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

// Finished after 28 minutes
// Accpeted first try

// My first solution ended up taking too much time. It was 100% the faster solution to run, but much slower to code.
// CHange to a bruteforce queue worked flawlessly though

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        // CIRCULAR = 0
        // SQUARE = 1

        int numOfOneDemands = 0;
        int numOfZeroDemands = 0;

        ArrayDeque<Integer> stuDeq = new ArrayDeque<Integer>();
        ArrayDeque<Integer> sandDeq = new ArrayDeque<Integer>();

        for ( int i : students){
            stuDeq.add(i);
        }

        for (int j : sandwiches){
            sandDeq.add(j);
        }

        for (int k=0; k<10000; k++){
            if (stuDeq.size() == 0){
                break;
            }

            if (stuDeq.getFirst() == sandDeq.getFirst()) {
                stuDeq.pop();
                sandDeq.pop();
            } else {
                int popped = stuDeq.pop();
                stuDeq.add(popped);

            }
        }

        System.out.println("final length of stuDeq is " + stuDeq.size());

        return stuDeq.size();

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] firstStudent = {1,1,0,0};
        int[] secondStudent = {1,1,1,0,0,1};

        int[] firstSand = {0,1,0,1};
        int[] secondSand = {1,0,0,0,1,1};

        System.out.println(sol.countStudents(firstStudent,firstSand));
        System.out.println(sol.countStudents(secondStudent,secondSand));



    }
}