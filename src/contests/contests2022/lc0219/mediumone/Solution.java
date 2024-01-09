package contests.contests2022.lc0219.mediumone;


//Definition for singly-linked list.
//public class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

// Accepted first
// Accepted at 7:05pm PST

import util.ListNode;

class Solution {
    public ListNode mergeNodes(ListNode head) {

        // SKip first zero
        head = head.next;
        ListNode originalNewListHead = null;

        ListNode newListHead = null;


        int currSum = 0;
        while (head != null) {
//            System.out.println("curren val of head.val = " + head.val);
            if (head.val == 0) {
//                System.out.println("truncating");
                // Truncate.
                // create a node with the right value
                ListNode nextNode = new ListNode();
                nextNode.val = currSum;

                if (newListHead == null) { // first node
                    newListHead = nextNode;
                    originalNewListHead = newListHead;
                } else {
                    newListHead.next = nextNode;
                    newListHead = newListHead.next;
                }
                currSum = 0;
            } else {
//                System.out.println("summing");
                // continue
                currSum += head.val;
            }
            head = head.next;
        }

        // print for debugging
        newListHead = originalNewListHead;
        while (newListHead != null) {
            System.out.println(newListHead.val);
            newListHead = newListHead.next;
        }

        return originalNewListHead;
    }
}

class Tests {
    public static void main(String[] args) {

    }
}