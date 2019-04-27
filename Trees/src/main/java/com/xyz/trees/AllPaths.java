package com.xyz.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AllPaths {

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

    static void allpaths (List<Node> list, Node node,int index) {

        if (node.left== null && node.right==null) {

            for (int i = 0; i<index;i++) {
                System.out.print(list.get(i).value+ " ");
            }
            System.out.print(node.value);
            System.out.println();
            return;
        }

        list.add(index, node);
        if (node.left != null)
            allpaths(list,node.left, index+1);
        if (node.right != null)
            allpaths(list,node.right, index+1);
    }

    public static void main(String args[]){
        Node head = new Node(40);
        head.left = new Node ( 30 );
        head.left.left = new Node (10);
        head.left.right = new Node ( 20);
        head.right = new Node(50);
        head.right.left = new Node(60);
        head.right.right = new Node(70);
        head.right.right.left = new Node(80);
        head.right.right.right = new Node(90);

        List <Node> list = new ArrayList<>();
        allpaths(list, head,0);

        }
}
