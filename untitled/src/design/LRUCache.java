package design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh
 * @since 23/04/26
 */
public class LRUCache {

    Map<Integer, Node> nodeMap = new HashMap<>();
    int capacity;

    Node head;
    Node tail;

    public LRUCache(int capacity) {
        nodeMap.clear();
        this.capacity = capacity;

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!nodeMap.containsKey(key))
            return -1;

        Node node = nodeMap.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.val;

    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAfterHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }


    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            deleteNode(node);
            insertAfterHead(node);
        } else {
            if (capacity == nodeMap.size()) {
                Node node = tail.prev;
                nodeMap.remove(node.key);
                deleteNode(node);
            }

            Node node = new Node(key, value);

            insertAfterHead(node);
            nodeMap.put(key, node);
        }


    }


    static class Node {
        Node prev;
        Node next;
        int val;
        int key;

        Node(int val, int key) {
            this.val = val;
            this.key = key;
        }

    }
}
