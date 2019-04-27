package com.xyz.mystrings;

/*
Problem:
Given a list of strings words, of size n, check if there is any pair of words,
that can be joined (in any order) to form a palindrome then return the pair of
words forming palindrome.

E.G. Words = {'CAT','TAC','BAT','BUT','TUB'}

- CAT + TAC = CATTAC
- BUT + TUB = BUTTUB

Solution:

Brute force approach for this would be try joining every node word with other and check it its palindrom.

N X N comparisions of words, and M comparisions for each combinations.


Other approach would be create a tri with reverse words and then compare each word in dictionary if it is present.



 */

import java.util.HashMap;
import java.util.Map;

public class JoinPalindrome {

    static TrieNode root;

    static class TrieNode{
        Character c;
        boolean isend;
        Map<Character, TrieNode>  children;
        int index;
        TrieNode(){

        }

        TrieNode(Character c) {
            this.c = c;
            isend = false;
            index = 0;
            children = new HashMap<>();
        }
    }

    static void buildBranch(String str, int index) {

        TrieNode node = root;

        int i = str.length()-1;
        while (i >=0) {
            if (node.children.containsKey(str.charAt(i))) {
                node = node.children.get(str.charAt(i));
            } else {
                TrieNode newnode = new TrieNode(str.charAt(i));
                node.children.put(str.charAt(i), newnode);
                node = newnode;
            }
            i--;
        }
        node.isend = true;
        node.index = index;
    }


    static int findSubstring(String pat) {

        TrieNode node = root;
        int len = pat.length();
        int i = 0;
        while(i < len) {
            if (node.children.containsKey(pat.charAt(i))) {
                node = node.children.get(pat.charAt(i));
            }else{
                return -1;
            }
            i++;
        }
        if (node.isend == true) return node.index;
        return -1;
    }

    static TrieNode buildTrie(String [] str) {
        root = new TrieNode('$');
        for(int i = 0; i < str.length ; i++) {
            buildBranch(str[i],i);
        }
        return root;
    }

    static void findPalindrom (String[] str) {
        for (int i = 0; i < str.length;i++) {
            int val = findSubstring(str[i]);
            if (val >= 0) {
                System.out.println(str[i] + ":" +  str[val] + " Is a palindrome" );
            }
        }
    }

    public static void main(String[] str) {
        System.out.println("Building Tries");
        String[] dict = {"CAT", "TAC", "NAT", "BAT", "ZEB", "TUB", "BUT"};
        buildTrie(dict);
        findPalindrom(dict);
    }
}
