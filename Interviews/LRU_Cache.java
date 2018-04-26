// Design and implement a data structure for Least Recently Used (LRU) cache. 
// It should support the following operations: get and set.
// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
//           otherwise return -1.
// set(key, value) - Set or insert the value if the key is not already present. 
//                   When the cache reached its capacity, 
//                   it should invalidate the least recently used item before inserting a new item.
                  
package com.company;
// lc 134.
import java.util.HashMap;

public class LRUCache {
    // HashMap<> + Doubly LinkedList.
    // build a class
    private static class Node {
        int key, val;
        Node next, pre;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            next = pre = null;
        }
    }

    private static int capacity;
    private static HashMap<Integer, Node> map;
    private static Node head;
    private static Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }

    public static int get(int key) {
        Node node = map.get(key);
        // not contain
        if (node == null) return -1;
        // contains, re-order.
        if (node != tail) { // if the node is the tail, no order change!
            if (node == head) {
                head = head.next;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = tail.next;
        }
        return node.val;
    }

    public static void set(int key, int value) {
        Node node = map.get(key);
        // contains, re-order.
        if (node != null) {
            node.val = value; // update value.
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = tail.next;
            }
        }
//        not contain, check capacity.
        else {
            Node newNode = new Node(key, value);
            if (capacity == 0) { // remove head(LRU);
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capacity++;
            }
            if (head == null && tail == null) { // 1st ele. to be insert.
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }
    }

    public static void main(String[] args) {
        new LRUCache(2);
        set(2, 1);
        set(1, 1);
        System.out.println(get(2)); // 1
        // this internal `get` method will update the key's position in the linked list.
        set(4, 1);
        System.out.println(get(1)); // -1
        System.out.println(get(2)); // 1
    }
}