package com.algoprep.lu.list;

public class SinglyLinkedListMain {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.add(0);
		list.add(1);
		list.add(4);
		list.add(15);
		list.add(31);
		list.add(76);
		list.addCyclicCondition(2, list.head);
		SinglyLinkedList.Node temp = list.head;
		System.out.print("Head -> ");
		int count=0;
		while (temp != null) {
			if(count>15)
				break;
			System.out.print(temp.data + " -> ");
			temp = temp.next;
			count++;
		}
		System.out.println("null");
		System.out.println(FloydCycle.getStartingNodeValue(list.head));
	/*	list.addFirst(2);
		list.add(3, 3);
	
		list.add(2);
		list.printList();
		System.out.println(list.size());
		System.out.println(list.get(3));
		System.out.println(list.remove(3));
		list.printList();
//		System.out.println(list.indexOf(2));
		System.out.println(list.lastIndexOf(2));
		list.removeFirst();
		list.printList();
//		list.printList();*/
	}
}