/*
        Given two strings find longest matching subsequence :
        P = "BATD"
        Q = "ABACD"


        A B A C D
         / /   /
        B A T D


  Solution 1:

        Brute force approach, Assume we have blackbox function which ƒ count longest matching subsequence.
        So main function can call the blackbox function in an iterative way and which ever index returns maximum count
        that's the longest matching subsequence.

        Blackbox function would be following

        int ƒ (int i) :
            int j = 0;count=0;
            int lastmatch = 0;
            while (i < Q.len){
                if j == P.len: { j = lastmatch; i++;continue;}
                if P[i] == Q[j] { i++; j++;lastmatch=i,;count++}
                else j++;
            }
            return count;


  Solution 2:

        Recursive way to solve above problem would be as follows

        p & q are index of P and Q respectively
        int LCS(p, q):
            if (p == P.length or q == Q.length) return 0;
            if (P[p] == Q[q]) return 1 + LCS(p+1, q+1)
            return MAX( LCS(p+1,q), LCS(p,q+1)).

        Basic intitution here is a index of both the String matches, then we say we found one match, and move one.
        else we have two options, either skip an index in P or Q  get maximum return value.

        case1:  P="    x"
                Q="    x"   say we have x at same index of p and Q. then we say we found one subsequence/match.

        case2:  P="    x"
                Q="    y"


       So if we skip x from P, so problem becomes LCS  of (P="    ", Q="    y") or we skip y from Q, so problem becomes
       LCS of (P = "     x", Q="       ").
       And we can find maximum of both these problem.


       Analysis:
        Since for not matching case we always branch off by skipping one string, our branching order becomes 2.
        We traverse length of P and Q both in each aproach, hence our O(T) is 2 ^ P.length + Q.length.

 */


public class LongestSubsequence {


    static int blackbox (char P[], char Q[], int i) {
        int j = 0, count = 0, lastmatched = 0;
        while (i < P.length) {
            if (j == Q.length) {
                j = lastmatched;
                i++;
                continue;
            }
            if (P[i] == Q[j]) {
                count++;
                i++;
                lastmatched = j;
            } else {
                j++;
            }
        }
        return count;
    }

    static void BruteLCS(char P[], char Q[]) {
        System.out.println("Brute LCS ");
        int max = 0;
        for (int i = 0; i< P.length; i++) {
            int temp = blackbox(P,Q,i);
            if (max < temp){
                max = temp;
            }
        }
        System.out.println("Final count is " + max);
    }

    static int LCS(char P[], char Q[], int i, int j) {
        if ( i == P.length ||  j == Q.length) return 0;
        if (P[i] == Q[j]) return 1 + LCS(P,Q,i+1, j+1);
        int skip = LCS(P,Q,i+1,j);
        int pick = LCS(P,Q,i,j+1);
        return skip>pick? skip:pick;
    }

    public static void main (String []args) {
        String P = "BANANANANANNANANABAMAMANAM";
        String Q = "ABACDADNANNABAMANANARRAAAA";

        long start = System.currentTimeMillis();
        BruteLCS(P.toCharArray(), Q.toCharArray());
        long end = System.currentTimeMillis();

        System.out.println("Brute Force Time taken:" + (end-start));

        start = System.currentTimeMillis();
        System.out.println("Recursive : " + LCS(P.toCharArray(),Q.toCharArray(),0,0));
        end = System.currentTimeMillis();

        System.out.println("LSP Time taken " +  (end - start));
    }

}
