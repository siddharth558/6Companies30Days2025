package Atlassian;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    /*
     * we need ordering and the insertion and deletion need to be of constant time.
     * hashmaps are unordered.
     */
    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> node_map;
    int cache_capacity;

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }

    public LRUCache(int capacity) {
        node_map = new HashMap<>(capacity);
        this.cache_capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = node_map.get(key);
        if (node != null) {
            remove(node);
            add(node);
            return node.val; // Return the value if found
        }
        return -1; // Return -1 if not found
    }

    public void put(int key, int value) {
        Node node = node_map.get(key);
        if (node != null) {
            remove(node);
            node.val = value;
            add(node);
        } else {
            if (node_map.size() == cache_capacity) {
                node_map.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node new_node = new Node();
            new_node.key = key;
            new_node.val = value;

            node_map.put(key, new_node);
            add(new_node); // Add the new node to the list
        }
    }

    public void add(Node node) {
        Node head_next = head.next;
        head.next = node;
        node.prev = head;
        node.next = head_next;
        head_next.prev = node;
    }

    public void remove(Node node) {
        Node next_node = node.next;
        Node prev_node = node.prev;
        next_node.prev = prev_node;
        prev_node.next = next_node;
    }
}
