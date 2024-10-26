package _Study.Problems.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/
 *
 * A new type of data structure. A good implementation of DoublyLinkedList
 *
 * // TODO - LinkedHashMap version
 */
class LRUCache {

    static class DoublyListNode {
        public int key;
        public int val;
        public DoublyListNode next;
        public DoublyListNode prev;
        public DoublyListNode(int key, int val) { this.key = key; this.val = val; }
    }


    int MAX_CAPACITY;
    int currCapacity;
    Map<Integer, DoublyListNode> nodeMap;
    DoublyListNode head;
    DoublyListNode tail;
    public LRUCache(int capacity) {
        this.MAX_CAPACITY = capacity;
        currCapacity = 0;
        nodeMap = new HashMap<>();
        head = new DoublyListNode(Integer.MAX_VALUE, Integer.MAX_VALUE); // sentinel
        tail = new DoublyListNode(Integer.MIN_VALUE, Integer.MIN_VALUE); // sentinel
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            System.out.println(-1);
            return -1;
        }
        DoublyListNode node = nodeMap.get(key);
        insertNodeAtHead(node);
        System.out.println(node.val);
        return node.val;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            DoublyListNode node = nodeMap.get(key);
            node.val = value;
            insertNodeAtHead(node);
        } else {
            if (currCapacity == MAX_CAPACITY) {
                // trim tail
                DoublyListNode nodeToDelete = tail.prev;
                nodeMap.remove(nodeToDelete.key);
                nodeToDelete.prev.next = nodeToDelete.next;
                tail.prev = nodeToDelete.prev;
            } else {
                currCapacity++;
            }
            DoublyListNode node = new DoublyListNode(key, value);
            nodeMap.put(key, node);
            insertNodeAtHead(node);
        }

    }

    private void insertNodeAtHead(DoublyListNode node) {
        if (node.next != null && node.prev != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        DoublyListNode prevHead = head.next;

        node.prev = head;
        node.next = prevHead;

        prevHead.prev = node;

        head.next = node;
    }
}

class Test {
    public static void main(String[] args) {
//        LRUCache sol = new LRUCache(2);
//        sol.put(1,1);
//        sol.put(2,2);
//        sol.get(1);
//        sol.put(3,3);
//        sol.get(2);
//        sol.put(4,4);
//        sol.get(1);
//        sol.get(3);
//        sol.get(4);

//        LRUCache sol2 = new LRUCache(2);
//        sol2.put(2, 1);
//        sol2.put(1, 1);
//        sol2.get(2); // 1
//        sol2.put(4, 1);
//        sol2.get(1); // -1
//        sol2.get(2); // 1


//        LRUCache sol3 = new LRUCache(2);
//        sol3.put(1, 0);
//        sol3.put(2, 2);
//        sol3.get(1); // 0
//        sol3.put(3, 3);
//        sol3.get(2); // -1
//        sol3.put(4,4);
//        sol3.get(1); // -1
//        sol3.get(3); // 3
//        sol3.get(4); // 4
    }
}
