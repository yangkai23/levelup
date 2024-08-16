package com.algoprep.lu.tree;

public class BTMain {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.add(15);
        binaryTree.add(5);
        binaryTree.add(11);
        binaryTree.add(51);
        binaryTree.add(4);
        binaryTree.add(0);
        binaryTree.add(100);
        binaryTree.preOrderTraversal();
        System.out.println();
        binaryTree.InOrderTraversal();
        System.out.println();
        binaryTree.postOrderTraversal();
        System.out.println();
        binaryTree.levelOrderTraversal();
    }
}
