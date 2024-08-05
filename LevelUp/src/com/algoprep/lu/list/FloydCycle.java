package com.algoprep.lu.list;

public class FloydCycle {
    public static void main(String[] args) {

    }

    public static int getStartingNodeValue(SinglyLinkedList.Node head) {
        if (head == null) return -1;
        SinglyLinkedList.Node fastPointer = head;
        SinglyLinkedList.Node slowPointer = head;

        if (fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        if (fastPointer != slowPointer) {
            while (fastPointer != slowPointer && fastPointer.next != null && fastPointer.next.next != null) {
                fastPointer = fastPointer.next.next;
                slowPointer = slowPointer.next;
            }
        }
        fastPointer = head;
        while (fastPointer != slowPointer) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        return fastPointer.data;
    }
}
