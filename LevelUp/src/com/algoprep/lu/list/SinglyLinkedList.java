package com.algoprep.lu.list;

//import java.util.HashMap;

public class SinglyLinkedList {
	public Node head;
	private int size;
//	private HashMap<Integer, Integer> map;

	public SinglyLinkedList() {
		this.head = null;
		this.size = 0;
//		map = new HashMap<>();
	}

	 class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void addFirst(int data) {
		Node node = new Node(data);
		node.next = this.head;
		head = node;
		size++;
	}

	public void add(int data) {
		Node node = new Node(data);
		Node temp = this.head;
		if (this.head == null) {
			head = node;
			size++;
			return;
		}
		while (temp.next != null)
			temp = temp.next;
		temp.next = node;
		size++;

	}

	public void addAll(SinglyLinkedList list) {
		Node temp = this.head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = list.head;
		size += list.size;
	}

	public void add(int position, int data) {
		if (position > size) {
			System.err.println("Index is out of bound");
			return;
		}
		if (position == 0) {
			addFirst(data);
			return;
		}
		Node node = new Node(data);
		Node temp = this.head;
		int pointer = 0;
		while (pointer < position - 1 && temp != null) {
			pointer++;
			temp = temp.next;
//			System.out.println("check");
		}
		node.next = temp.next;
		temp.next = node;
		size++;
	}

	public int get(int position) {
		if (position >= size) {
			System.err.println("Index out of bound");
			return -1;
		}
		if (position == 0)
			return this.head.data;
		Node temp = this.head;
		while (position > 0 && temp != null) {
			position--;
			temp = temp.next;
		}
		return temp.data;

	}

	public boolean contains(int data) {
		Node temp = this.head;
		while (temp != null) {
			if (temp.data == data)
				return true;
			temp = temp.next;
		}
		return false;
	}

	public int removeFirst() {
		Node temp = this.head;
		this.head = temp.next;
		temp.next = null;
		size--;
		return temp.data;
	}

	public int remove(int position) {
		if (position > size) {
			System.out.println("Index not bound");
			return -1;
		}
		Node temp = this.head;
		if (position == 0) {
			this.head = null;
			size--;
			return temp.data;
		}
		while (position > 1 && temp != null) {
			temp = temp.next;
			position--;
		}
		Node removalNode = temp.next;
		temp.next = removalNode.next;
		removalNode.next = null;
		size--;
		return removalNode.data;
	}

	public void printList() {
		Node temp = this.head;
		System.out.print("Head -> ");
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public int indexOf(int data) {
		Node temp = this.head;
		int index = 0;
		while (temp != null) {
			if (temp.data == data)
				return index;
			index++;
			temp = temp.next;
		}
		return -1;
	}

	public int lastIndexOf(int data) {
		Node temp = this.head;
		int index = 0, lastIndex = -1;
		while (temp != null) {
			if (temp.data == data) {
				lastIndex = index;
			}
			index++;
			temp = temp.next;
		}
		return lastIndex;
	}

	public int size() {
		return size;

	}
	public void addCyclicCondition(int position,Node head){
		if(head==null)
			return;
		Node temp=head;
		Node temp2=head;
		int count=position;
		while(count>1 && temp!=null){
			temp=temp.next;
		count--;
		}
		while(temp2.next!=null){
			temp2=temp2.next;
		}
		temp2.next=temp;
	}

	public boolean isEmpty() {
		return size == 0;
	}
}
