package com.xyz.trees;

import java.util.Deque;
import java.util.LinkedList;

public class LevelWise {

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

    static void levelwise(Deque<Node> list, int count){

        int j = 0;
        if (count == 0) return;
        for (int i = 0; i< count;i++) {

            Node node = list.removeFirst();
            System.out.print (node.value + " ");
            if (node.left != null)  {
                list.addLast(node.left);
                j++;
            }

            if (node.right != null) {
                list.addLast(node.right);
                j++;
            }
        }

        System.out.println();
        levelwise(list, j);

    }

    public static void main(String args[]){
        Node head = new Node(40);
        head.left = new Node ( 30 );
        head.left.left = new Node (10);
        head.left.right = new Node ( 20);
        head.right = new Node(50);
        head.right.left = new Node(60);
        head.right.right = new Node(70);

        Deque<Node> list = new LinkedList<>();
        list.addLast(head);
        levelwise(list,1);
    }
}
