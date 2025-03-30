package com.others.sresta;

public class SinglyLinkedListXam {
     class SinglyLinkedListNode{
        int data;
        SinglyLinkedListNode next;
    }

    public static int findMid(SinglyLinkedListNode head) {
        if (head == null) return -1;
        int listLen = 1;
        SinglyLinkedListNode temp = head;
        while (temp.next != null) {
            listLen++;
            temp = temp.next;
        }
        int pointer = 1;
        SinglyLinkedListNode mid = head;
        while (pointer <= listLen / 2) {
            mid = mid.next;
            pointer++;
        }
        return listLen % 2 == 0 ? mid.next.data : mid.data;
    }
}
