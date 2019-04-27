package com.xyz.mystrings;

import java.util.HashMap;
import java.util.Map;

/* Given a string create a suffix trie for

        e.g. Str = ABAA;

        output:
                A
                AA
                BAA
                ABAA

*/

public class SuffixTrie {

    static TrieNode root;

    static class TrieNode{
        Character c;
        boolean isend;
        Map<Character, TrieNode>  children;

        TrieNode(){

        }

        TrieNode(Character c) {
            this.c = c;
            isend = false;
            children = new HashMap<>();
        }
    }

    static void buildBranch(String str, int i) {
        TrieNode node = root;

        while (i < str.length()) {
            if (node.children.containsKey(str.charAt(i))) {
                node = node.children.get(str.charAt(i));
            } else {
                TrieNode newnode = new TrieNode(str.charAt(i));
                node.children.put(str.charAt(i), newnode);
                node = newnode;
            }
            i++;
        }
        node.isend = true;
    }


    static boolean findSubstring(String pat) {
        TrieNode node = root;
        int len = pat.length();
        int i = 0;
        while(i < len) {
            if (node.children.containsKey(pat.charAt(i))) {
                node = node.children.get(pat.charAt(i));
            }else{
                return false;
            }
            i++;
        }
        return true;
    }

    static TrieNode buildTrie(String str) {
        root = new TrieNode('$');
        for(int i = str.length()-1; i >=0 ; i--) {
            buildBranch(str,i);
        }
        return root;
    }

    public static void main(String[] str) {
        System.out.println("Building Tries");
        buildTrie("THIS IS TEST");
        System.out.println(findSubstring("TEST"));
        System.out.println(findSubstring("THIS"));
        System.out.println(findSubstring("IST"));
    }
}
