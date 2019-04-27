package com.xyz.mystrings;


/* Given a pattern, check if it is present in the given string

E.g. String :Bananan (N)
     Pattern:nana     (M)
    Output = True.


Solution:
     Brute force approach is to have two loops  M X N.



 */
public class PatternMatchNaive {

    static boolean patternMatch (String str, String pat) {

        char s[] = str.toCharArray();
        char p[] = pat.toCharArray();

        int current = 0;
        for (int i = 0; i< s.length; i++) {
            current = i;
                int j = 0;
            for (j = 0; j<p.length; j++) {

                if (i == s.length || p[j] != s[i]) {
                    i = current;
                    break;
                }
                i++;
            }

            if (j == p.length) return true;
        }

        return false;
    }


    public static void main(String str[]) {
        System.out.println(patternMatch("Banana","np"));
    }
}
