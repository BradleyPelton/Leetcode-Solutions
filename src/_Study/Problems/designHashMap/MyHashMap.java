package _Study.Problems.designHashMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 706. Design HashMap
 * https://leetcode.com/problems/design-hashmap
 *
 * // No good solution? Editorial sucks.
 */
class MyHashMap {

    List<List<List<Integer>>> buckets;
    public MyHashMap() { // 3d ArrayList - 50% runtime, 39% memory
        buckets = new ArrayList<>();
        for (int i = 0; i < 5001; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public void put(int key, int value) {
        int hashValue = hashFunction(key);
        List<List<Integer>> bucket = buckets.get(hashValue);
        for (List<Integer> pair : bucket) {
            if (pair.get(0) == key) {
                pair.set(1, value);
                return;
            }
        }
        bucket.add(new ArrayList<>(List.of(key, value)));
    }

    public int get(int key) {
        int hashValue = hashFunction(key);
        List<List<Integer>> bucket = buckets.get(hashValue);
        for (List<Integer> pair : bucket) {
            if (pair.get(0) == key) {
                return pair.get(1);
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hashValue = hashFunction(key);
        List<List<Integer>> bucket = buckets.get(hashValue);
        int lookupIndex = -1;
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).get(0) == key) {
                lookupIndex = i;
                break;
            }
        }
        if (lookupIndex != -1) {
            bucket.remove(lookupIndex);
        }
    }

    private int hashFunction(int key) {
        return key % 5001;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */