package com.xyz.trees;

import java.util.Deque;
import java.util.LinkedList;

public class CommonAncestor {

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

    static boolean findcommon(Node node, int j, int k) {
        if (node == null) return false;

        if (node.value == j || node.value == k)
            return true;

        boolean left = findcommon(node.left,j,k);
        boolean right = findcommon(node.right,j,k);

        if (right && left) {
            System.out.println("Common Ancestor is " + node.value);
            return true;
        }

        return right || left;

    }

    public static void main(String args[]) {
        Node head = new Node(40);
        head.left = new Node(30);
        head.left.left = new Node(10);
        head.left.left.right= new Node(350);
        head.left.left.left = new Node (100);
        head.left.left.left.left = new Node(200);
        head.left.left.left.right = new Node(300);
        head.left.right = new Node(20);
        head.right = new Node(50);
        head.right.left = new Node(60);
        head.right.right = new Node(70);
        findcommon(head,350,300);
    }
}
