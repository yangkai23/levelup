package com.algoprep.lu.list;

public class LinkedListMid {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(31);
        list.add(0);
        list.add(76);
        list.add(1);
        list.add(15);
        list.add(4);
        list.add(4);
        int result = findMidVal(list.head);
        System.out.println(result);
    }

    private static int findMidVal(SinglyLinkedList.Node head) {
        if (head == null) return 0;
        SinglyLinkedList.Node fastPointer = head;
        SinglyLinkedList.Node slowPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer.data;
    }
}
