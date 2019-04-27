package com.xyz.mystrings;


/* Solution Given a  String and a string with wild cards, find if two strings represents same.

wildcard : '*' zero or more, '?' one charater.

e.g. str: abaacd
     pat: ab*cd

     str: aabaab
     pat  a.b*b


Solution: This can be solved using recurrsion or DP. speacial case for * ,where one can skip or include.

 */
public class WildCardPattern {

    public static boolean match(String str, String pattern, int i, int j) {

        if (i == str.length() && j == pattern.length()){
            return true;
        }

        if (i >= str.length() || j>= pattern.length() ){
            return false;
        }


        if ((pattern.charAt(j) == '.') || pattern.charAt(j) == str.charAt(i)){
            return match(str,pattern,i+1,j+1);
        }

        if (pattern.charAt(j) == '*') {
            return match(str,pattern,i+1,j) || match(str,pattern,i+1,j+1);
        }

        return false;
    }


    public static void main(String[] args){
        System.out.println(match("ABAAC","A*",0,0));
    }
}
