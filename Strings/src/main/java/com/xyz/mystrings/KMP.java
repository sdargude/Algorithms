package com.xyz.mystrings;
/*

Knuth, Morris, Pratt (KMP) algorithm is an optimization over a naive pattern matching algorithm.

N - > String len, M-> Pattern len.

Search algorithm is O(N)
Preparation time is O(M)
Extra Space is O(M).


Brute force approach N X M (2 loops) resets position of j = 0, once there is there is mismatch.
Recomputing same pattern.

KMP algorithm spends some time building a prefix table, so that value is of j is not reset,but to optimum
value to avoid recomputing.


Definition:

Proper prefix: Is a prefix of a string with one or more cuts.
E.g. ABA - > A, AB (Note: ABA is not a proper preffix).

Proper suffix: Is a suffix of a string with one or more cuts.
E.G. ABA -> A, BA.

Prefix table:

Intuition behind prefix table: Say we have a pattern aabaabd

I is len of substring of pattern.


i           Proper Prefixes             Proper Suffixes                   Common              Max
0  a                                                                        0                   0 a
1  aa       a                            a                                  1                   1 a
2  aab      a, aa                        ab,b                               0                   0 b
3  aaba     a,aa,aab                     aba,ba,a                           1                   1 a
4  aabaa    a,aa,aab,aaba                a,aa,baa,abaaa                     2                   2 a
5  aabaab   a,aa,aab,aaba,aabaa          b,ab,aab,baab,abaab                3                   0 b
6  aabaabd  a,aa,aab,aaba,aabaa,aabaab   d,bd,abd,aabd,baabd,abaabd         0                   0 d


The max column represents prefix table.


Once we have prefix table, KMP algorithm is similar to naive approach, but rather than reseting j to 0 again, j is set
to value of prefixtable[j].

*/

public class KMP {


    static int [] prefixtable(char [] pattern) {
        int prefixtable[] = new int[pattern.length];


        int j = 0;
        int i = 1;

        prefixtable[0]=0;

        for (i=1;i<pattern.length;i++) {
            if (pattern[i] == pattern[j]) { // if i, j match, move j, set prefixtable value;
                prefixtable[i]=j+1;
                j++;
            } else{
                j=j-1;
                while (j>0 && pattern[i] != pattern[j]) { /* p[i] != p[j] , move j to previous positions value */
                    j=j-1;
                    j = prefixtable[j];
                }
                if (pattern[i] == pattern[j]) {
                    j++;
                }
                prefixtable[i]=j;
            }
        }

        return prefixtable;
    }

    public static boolean findpattern(int ptable[], char par[], char str[]) {

        int i = 0;
        int j = 0;

        for (i=0;i<str.length;i++){
            if (j==par.length) return true;

            if (str[i] == par[j]) {
                j++;
            }else{
                j = j-1;                                                /* Move j to previous cell  and then to value of prefix table */
                j=ptable[j];
            }
        }

        if (j == par.length) return true;
        return false;
    }


    public static void main(String[] args) {

        String str =  "aaaabaabdab";
        String pat =    "aabaabd";
        char[] p = pat.toCharArray();
        int j=0;

        int pt[] = prefixtable(pat.toCharArray());

        for (int i :pt) {
            System.out.println(p[j++] +" " + i);
        }

        boolean output = findpattern(pt,p,str.toCharArray());
        System.out.println(output);
    }

}

