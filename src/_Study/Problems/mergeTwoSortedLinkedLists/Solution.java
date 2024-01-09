package _Study.Problems.mergeTwoSortedLinkedLists;

import util.ListNode;


/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * <p>
 *      Iterative Approach: (BETTER APPROACH, SMALLER SPACE COMPLEXITY)
 *     Time Complexity: Big O(m+n) - number of nodes in list1(m) and number of nodes in list2(n)
 *     Space Complexity: Big O(1) - constant amount of space consumed(variables)
 * </p>
 *
 * <p>
 *     Recursive Approach:
 *     Time Complexity: Big O(m+n) - number of nodes in list1(m) and number of nodes in list2(n)
 *     Space Complexity: Big O(m+n) - m+n number of recursive method calls on the stack
 * </p>
 */
class Solution {
    public ListNode mergeTwoListsITERATIVE(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode newListHead; // set first element
        if (list1.val < list2.val) {
            newListHead = list1;
            list1 = list1.next;
        } else {
            newListHead = list2;
            list2 = list2.next;
        }
        ListNode rootOfNewList = newListHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newListHead.next = list1;
                list1 = list1.next;
            } else {
                newListHead.next = list2;
                list2 = list2.next;
            }
            newListHead = newListHead.next;
        }

        if (list1 != null) {
            newListHead.next = list1;
        } else if (list2 != null) {
            newListHead.next = list2;
        }
        return rootOfNewList;
    }

    public ListNode mergeTwoListsRECURSIVE(ListNode list1, ListNode list2) {
        if (list1 == null) { return list2; }
        if (list2 == null) { return list1; }

        ListNode head;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        head.next = mergeTwoListsRECURSIVE(list1, list2);
        return head;
    }

    public ListNode mergeTwoListsRECURSIVE2(ListNode list1, ListNode list2) { // recursive2
        ListNode originalHead = new ListNode();
        originalHead.next = merge(list1, list2);
        return originalHead.next;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        int valOne = list1.val;
        int valTwo = list2.val;
        if (valOne < valTwo) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }
}