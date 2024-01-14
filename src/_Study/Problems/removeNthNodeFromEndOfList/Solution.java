package _Study.Problems.removeNthNodeFromEndOfList;

import util.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 *
 * // TODO - There is a much cleaner solution with two pointers/runners
 *
 */
class Solution {
    int maxDepth = 0;
    int n;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.n = n;

        ListNode sentinel = new ListNode(-42);
        sentinel.next = head;

        return removeRecursive(sentinel, 0).next;
    }

    private ListNode removeRecursive(ListNode head, int currDepth) {
        if (head == null) {
            maxDepth = currDepth;
            return null;
        }

        head.next = removeRecursive(head.next, currDepth + 1);

        if (maxDepth - currDepth - 1 == n) {
            head.next = head.next.next;
        }
        return head;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode.printLinkedList(
                sol.removeNthFromEnd(
                        ListNode.fromArray(new int[]{1,2,3,4,5}),
                        2
                )
        );
        ListNode.printLinkedList(
                sol.removeNthFromEnd(
                        ListNode.fromArray(new int[]{1}),
                        1
                )
        );
        ListNode.printLinkedList(
                sol.removeNthFromEnd(
                        ListNode.fromArray(new int[]{1,2}),
                        1
                )
        );
        ListNode.printLinkedList(
                sol.removeNthFromEnd(
                        ListNode.fromArray(new int[]{1,2}),
                        2
                )
        );
    }
}