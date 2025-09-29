package monotonicstack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shanmukha Anirudh
 * @date 06/09/25
 */
public class LFUCache {
    int capacity;
    int currentCapacity;
    int minFrequency;
    Map<Integer, DllNode> cache;
    Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currentCapacity = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        DllNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        updateNode(node);
        return node.value;
    }

    private void updateNode(DllNode currNode) {
        int currFrequency = currNode.freq;
        DoublyLinkedList currList = freqMap.get(currFrequency);
        currList.removeNode(currNode);
        if (currFrequency == minFrequency && currList.size == 0) {
            minFrequency++;
        }
        currNode.freq++;
        DoublyLinkedList newList = freqMap.getOrDefault(currNode.freq, new DoublyLinkedList());
        newList.addNode(currNode);
        freqMap.put(currNode.freq, newList);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            DllNode node = cache.get(key);
            node.value = value;
            updateNode(node);

        } else {
            currentCapacity++;
            if (currentCapacity > capacity) {
                DoublyLinkedList minFreqList = freqMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currentCapacity--;
            }
            minFrequency = 1;
            DllNode newNode = new DllNode(key, value);
            DoublyLinkedList currList = freqMap.getOrDefault(1, new DoublyLinkedList());
            currList.addNode(newNode);
            freqMap.put(1, currList);
            cache.put(key, newNode);
        }
    }

    class DllNode {
        int key;
        int value;
        int freq;
        DllNode next;
        DllNode prev;

        DllNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;

        }
    }

    class DoublyLinkedList {
        int size;
        DllNode head;
        DllNode tail;

        DoublyLinkedList() {
            this.size = 0;
            this.head = new DllNode(0, 0);
            this.tail = new DllNode(0, 0);
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public void addNode(DllNode node) {
            DllNode currentAfterHead = head.next;
            head.next = node;
            node.prev = this.head;
            node.next = currentAfterHead;
            currentAfterHead.prev = node;
            size++;
        }

        public void removeNode(DllNode node) {
            DllNode next = node.next;
            DllNode prev = node.prev;
            next.prev = prev;
            prev.next = next;
            size--;

        }

    }

}
