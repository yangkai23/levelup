package com.algoprep.lu.list;

public class ReverseLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(31);
        list.add(0);
        list.add(76);
        list.add(1);
        list.add(15);
        list.add(4);
        list.add(45);
        reverse(list.head);
//        System.out.println(result);
        list.printList();
    }

    private static void reverse(SinglyLinkedList.Node head) {
        SinglyLinkedList.Node prev = null;
        SinglyLinkedList.Node curr = head;
        while (curr != null) {
            SinglyLinkedList.Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
        SinglyLinkedList.Node temp = head;
        System.out.print("Head -> ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
