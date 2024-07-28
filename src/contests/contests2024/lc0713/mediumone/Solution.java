package contests.contests2024.lc0713.mediumone;

import util.ListNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


// First attempt wrong answer
// Second attempt accepted

// missed the edge case setting last node to null

// Accepted after 5 minutes. Very fast LinkedList problem

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }

        ListNode headAltered = new ListNode(Integer.MIN_VALUE);
        ListNode ans = headAltered;

        while (head != null) {
            if (!uniqueNums.contains(head.val)) {
                headAltered.next = head;
                headAltered = headAltered.next;
            }
            head = head.next;
        }
        headAltered.next = null;

        return ans.next;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.modifiedList(
//                new int[]{1,2,3},
//                ListNode.fromArray(new int[]{1,2,3,4,5})
//        ));
//        System.out.println(sol.modifiedList(
//                new int[]{1},
//                ListNode.fromArray(new int[]{1,2,1,2,1,2})
//        ));
//        System.out.println(sol.modifiedList(
//                new int[]{5},
//                ListNode.fromArray(new int[]{1,2,3,4})
//        ));
        System.out.println(sol.modifiedList(
                new int[]{9,2,5},
                ListNode.fromArray(new int[]{2,10,9})
        )); // 10



    }
}
