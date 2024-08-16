package com.algoprep.lu.tree;

public class BinaryTree {
    private Node root;

    public Node add(Object data) {
//        if (data instanceof Integer) {
        return addRecursiveInt(this.root, data);
//        }
    }

    private Node addRecursiveInt(Node root, Object data) {
        if (root == null) {
            Node node = new Node(data);
            if (this.root == null) this.root = node;
            return node;
        }
        int valToBeAdded = (Integer) data;
        int nodeVal = (Integer) root.data;
        if (valToBeAdded < nodeVal) root.left = addRecursiveInt(root.left, data);
        if (valToBeAdded > nodeVal) root.right = addRecursiveInt(root.right, data);
        return root;
    }

    public void preOrderTraversal() {
        System.out.print("Pre order Traversal : ");
        preOrder(this.root);
//        System.out.println("Ani"+root);
    }

    private void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " -> ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public void InOrderTraversal() {
        System.out.print("In-order Traversal : ");
        inOrder(this.root);
    }

    private void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " -> ");
        inOrder(root.right);
    }

    public void postOrderTraversal() {
        System.out.print("Post order Traversal : ");
        postOrder(this.root);
    }

    private void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " -> ");
    }

    private class Node {
        Object data;
        Node right;
        Node left;

        Node(Object data) {
            this.data = data;
        }
    }
}
