package com.xyz.mystrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Trie {

    static TrieNode root = new TrieNode();

    static class TrieNode {
        Character c;
        HashMap<Character, TrieNode> children;
        boolean isWord;

        TrieNode(){
            children = new HashMap<>();
            isWord = false;
        }

        TrieNode(Character c){
            System.out.println("Created " + c);
            children = new HashMap<>();
            isWord = false;
            this.c = c;
        }
    }


    static void insert(String word) {

        TrieNode node = root;
        int i = 0;
        while(i < word.length()) {
            Character c = word.charAt(i);
            node = node.children.computeIfAbsent(word.charAt(i), k->new TrieNode(c));
            i++;
        }
        node.isWord = true;
    }

    static boolean find(String word) {
        TrieNode node = root;
        int i = 0;
        while(i<word.length()) {
            node = node.children.get(word.charAt(i));
            if (node == null) return false;
            i++;
        }

        return node.isWord;
    }


    static void printStack(Stack s) {
        System.out.println(s);
    }

    static void search(TrieNode node, Stack<Character> s) {
        if (node.children.isEmpty()){
            if (node.isWord) printStack(s);
            return;
        }

        if (node.isWord) {
            printStack(s);
        }

        for (Character k: node.children.keySet()) {
            TrieNode v = node.children.get(k);
            s.push(v.c);
            search(v,s);
            s.pop();
        }
    }

    static void findpre(String word) {
        TrieNode node = root;
        int i = 0;
        Stack<Character> stack = new Stack<>();

        while(i<word.length()) {
            node = node.children.get(word.charAt(i));
            if (node == null) {
                System.out.println("Not Found");
                return;
            }
            stack.push(node.c);
            i++;
        }

        if (node.isWord) {
            printStack(stack);
        }

        search(node,stack);

    }


    public static void main (String[]args) {

        insert("Help");
        insert("Hello");
        insert("Hell");
        insert("Heap");
        insert("Holla");
        insert("Horizon");
        insert("Bad");
        insert("Bald");
        insert("Balls");
        System.out.println(find("Help"));
        System.out.println(find("Hello"));
        System.out.println(find("Hel"));
        System.out.println(find("HelloP"));
        System.out.println(find("Hellx"));
        findpre("H");
        findpre("B");


    }

}
