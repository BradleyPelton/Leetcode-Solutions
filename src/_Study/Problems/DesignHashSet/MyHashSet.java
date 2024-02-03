package _Study.Problems.DesignHashSet;

/**
 * 705. Design HashSet
 * https://leetcode.com/problems/design-hashset
 *
 * // TODO - Optimize "Separate Chaining" bucket collision approach
 * // TODO - BinarySearchTree as Bucket approach
 *
 */
class MyHashSet { // LinkedList as Bucket approach - 77% runtime, 55% memory

    class ListNode {
        public int val;
        public MyHashSet.ListNode next;
        public ListNode(int val) { this.val = val; }
    }

    MyHashSet.ListNode[] vals;
    public MyHashSet() {
        vals = new MyHashSet.ListNode[5001];
    }

    public void add(int key) {
        if (!contains(key)) {
            int hashValue = hashFunction(key);
            MyHashSet.ListNode keyNode = new MyHashSet.ListNode(key);
            keyNode.next = vals[hashValue];
            vals[hashValue] = keyNode;
        }
    }

    public void remove(int key) {
        if (contains(key)) {
            int hashValue = hashFunction(key);
            MyHashSet.ListNode head = vals[hashValue];
            if (head != null) {
                if (head.val == key) {
                    vals[hashValue] = head.next;
                } else {
                    while (head.next != null) {
                        if (head.next.val == key) {
                            head.next = head.next.next;
                            break;
                        }
                        head = head.next;
                    }
                }
            }
        }
    }

    public boolean contains(int key) {
        int hashValue = hashFunction(key);
        MyHashSet.ListNode head = vals[hashValue];
        if (head == null) {
            return false;
        } else {
            while (head != null) {
                if (head.val == key) {
                    return true;
                }
                head = head.next;
            }
            return false;
        }
    }

    private int hashFunction(int val) {
        return val % 5001;
    }
}
