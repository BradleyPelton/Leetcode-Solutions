package _Study.Problems.linkedListCycle;

import util.ListNode;


/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/description/
 *
 * Two Pointer Solution
 *
 * There's a hashmap solution as well, but nothing particularly clever.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {  // Two Pointer/"runner" solution. 100% runtime, 20% memory
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
