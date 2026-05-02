package design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh
 * @since 23/04/26
 */
public class LRUCache {

    private final Map<Integer, Node> nodeMap;

    private final Node head;
    private final Node tail;

    private final int capacity;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("Capacity must be greater than 0");
        }
        this.capacity = capacity;

        nodeMap = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }


    public int get(int key) {

        if (!nodeMap.containsKey(key))
            return -1;

        Node node = nodeMap.get(key);
        removeNode(node);
        insertAfterHead(node);
        return node.val;

    }

    public void put(int key, int val) {

        if (nodeMap.containsKey(key)) {

            Node node = nodeMap.get(key);
            node.val = val;
            removeNode(node);
            insertAfterHead(node);
            return;
        }

        if (capacity >= nodeMap.size()) {

            Node node = tail.prev;
            removeNode(node);
            nodeMap.remove(node.key);
        }

        Node node = new Node(key, val);
        insertAfterHead(node);
        nodeMap.put(key, node);


    }


    private void insertAfterHead(Node node) {

        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;

    }

    private void removeNode(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    static class Node {
        Node prev;
        Node next;
        int val;
        int key;

        Node(int key, int val) {
            this.val = val;
            this.key = key;
        }

    }
}
