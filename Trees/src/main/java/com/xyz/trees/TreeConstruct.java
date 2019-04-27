/* Given a preorder and inorder traversal, construct a binary tree */

package com.xyz.trees;

public class TreeConstruct {

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


    static int findindex(int inlist[], int start, int end,int val){

        int i = 0;

        for (i = start;i<=end;i++) {
            if (inlist[i] == val) break;
        }

        return i;
    }

    static int p = 0;
    static Node getTree(int inlist[], int prelist[], int start, int end){

        Node node = new Node (prelist[p]);
        if (start == end || p == prelist.length) return node;
        int index = findindex(inlist, start,end, prelist[p]);

        p++;
        node.left = getTree(inlist,prelist, start, index -1);
        p++;
        node.right = getTree(inlist,prelist,index+1, end);

        return node;
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

        int inlist[] = {10,30,20,40,60,50,70};
        int prelist[]= {40,30,10,20,50,60,70};


        Node node = getTree(inlist, prelist,0,prelist.length-1);
        System.out.print("Reconstructed :");
        inorder(node);
        System.out.println();

    }
}
