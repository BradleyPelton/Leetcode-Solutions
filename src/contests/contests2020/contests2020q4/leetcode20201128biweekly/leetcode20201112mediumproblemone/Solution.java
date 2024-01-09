package contests2020q4.leetcode20201128biweekly.leetcode20201112mediumproblemone;


// Struggled with linked list...
// I can reverse a linked list but I can't change values in a linked list?
// I guess that means I just memorized the reverse linked list algorthim and didnt understand it

// The stupid values werent updating in the second loop. They were updating fine in the first loop though. IDK


import util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *
 *     int val;
 *     ListNode next;
 *
 *     (CONSTRUCTOR)
 *     ListNode() {}
 *
 *     (ANOTHER CONSTRUCTR)
 *     ListNode(int val) { this.val = val; }
 *
 *     (ANOTHER CONSTRUCTOR)
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode dummy = new ListNode(0);
        dummy.next = list1;

        ListNode head = list1;
        System.out.println("initial value of head is " + head.val);

        // LOOP TO a
        for (int i = 1; i < 10000; i++) {
            if (i == a){
                break;
            } else {
                head = head.next;
//                head.val += 50; // testing that the value is being updated
                System.out.println("new value of head is " + head.val);
            }
        }

        ListNode listOneBackground = head.next; // a-1 PLUS AN EXTRA NEXT to get a

        head = list2;  // head equals a
        System.out.println("current head value after assigning list 2 is " + head.val);

        // REPLACE ALL VALUES UNTIL i = b
        for (int i = a + 1; i< 10000; i++) {
            if (i==b+1){
                head = listOneBackground.next;
                break;
            } else {

                head.val = 100;
                head = head.next;



                // UPDATE THE NEXT VALUE
//                ListNode nextTemp = head.next;
////                head.next = nextTemp.
//
//                head = head.next;
//                System.out.println("INSIDE B LOOP new value of head is " + head.val);

                // KEEPING LIST ONE UP TO DATE
                listOneBackground = listOneBackground.next;
            }
        }


        return dummy.next;
    }
}