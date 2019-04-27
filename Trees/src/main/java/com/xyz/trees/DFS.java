package com.xyz.trees;

public class DFS {

    static class Node {
        Node left;
        Node right;
        int value;

         Node (int value){
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }


    static void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print (node.value + " ");
        inorder(node.right);
    }


    static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    static void postorder(Node node){
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String args[]){
        Node head = new Node(40);
        head.left = new Node ( 30 );
        head.left.left = new Node (10);
        head.left.right = new Node ( 20);
        head.right = new Node(50);
        head.right.left = new Node(60);
        head.right.right = new Node(70);

        System.out.print("PreOrder : ");
        preorder(head);
        System.out.println();

        System.out.print("InOrder  : ");
        inorder(head);
        System.out.println();

        System.out.print("PostOrder: ");
        postorder(head);
        System.out.println();
    }
}
