package com.algoprep.lu.tree;

public class SizeOfTree {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.add(15);
        binaryTree.add(5);
        binaryTree.add(11);
        binaryTree.add(51);
        binaryTree.add(4);
        binaryTree.add(0);
        binaryTree.add(100);
        int result=binaryTree.sizeOfTree();
        System.out.println("Result : "+result);
    }
}
