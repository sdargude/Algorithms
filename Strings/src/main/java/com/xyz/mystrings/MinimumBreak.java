package com.xyz.mystrings;
/*
Problem:
Given a string s, break s such that every substring of the partition can be found in the dictionary.
Return the minimum break needed.

Given a dictionary ["Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"]
Input :  Pattern "CatMat"
Output : 1
Explanation: we can break the sentences
in three ways, as follows:
CatMat = [ Cat Mat ]  break 1
CatMat = [ Ca tM at ] break 2
CatMat = [ C at Mat ] break 2  so the
         output is: 1

Input : Dogcat
Output : 1
 */


import java.util.HashMap;
import java.util.Stack;


public class MinimumBreak {

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


    static int minimumbreak(String pattern, int count, int i) {
        TrieNode  node = root;
        int min = Integer.MAX_VALUE;

        if (i >= pattern.length()) return count;

        while( i < pattern.length()){
            node = node.children.get(pattern.charAt(i));
            if (node == null) break;
            if (node.isWord == true){
                int temp = minimumbreak(pattern, count +1, i+1);
                if (temp < min) min=temp;
            }
            i++;
        }
        return min;
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

        insert("C");
        insert("CA");
        insert("CAT");
        insert("MAT");
        insert("TM");
        insert("AT");
       insert("ATMAT");
        insert("DO");
        insert("DOG");
        insert("OG");

        System.out.println(minimumbreak("ATMAT",0,0));
    }

}
