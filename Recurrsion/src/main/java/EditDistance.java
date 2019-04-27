/* Problem Statement:

Given two strings S1 and S2, with length n, m respectively. With following permissible operations listed below, find
minimum number of operation which can be performed on S1, so that S1 == S2.

Operations:

Insert : Insert an character to S1 at  index.
Delete : Delete an character of S1 at index.
Replace : Replace a character of S1 at index.
Skip


Example:
 S1 : dhgh
 S2 : dgh

The minimum edit distance is one.

Solution:

A brute force approach to solve this problem is using recursion.  Idea is at every call, one has three option (i.e.
insert, delete and replace). What is definition of


si : index of S1, sj index of s2. (Start condition 0,0.
 int editdistnace ( S1, si, S2, sj) :


Insert Operation:  editfunction(S1, si, S2, sj+1).
                    E.g. Say S1 = RAT, S2 = PRAT. Index value is si=0, sj=0;
                    So S1[0] != S2[0], so we have three options here, Insert, Delete, Replace.
                    So what would we insert in S1[0] which would make it closer to S2? It should be P.
                    So the string becomes PRAT, RAT. Hence length of S1 increased by 1. From index of S1
                    stays same, but Sj moves on for next character.

delete Operation: editfunction (S1, si+1, S2, sj). = > Delete a character

Replace           editfunction(S1, si +1 , S2, sj +1)

Skip              editfunction(S1,si+1, S2, si+1). Done when character at si, sj are same.





base condition: if si == len(S1)  And Sj == len(S2) return 0;
                if si == len(S1) return len(S2)-sj; Remaining string.
                if sj == len(S2) return len(S1)-si; Remaining String.


if (S1[si] == S2[sj]) return editfunction (S1, si+1, S2, sj+1)
else
    i = editfunction(S1,si, S2, sj+1)
    d = editfunction(S1,si+1, S2, sj)
    r = editfunction(S1,si+1, S2, sj+1)
    return min(i,d,r) + 1
 */

public class EditDistance {

    public static int editfunction(String S1, int si, String S2,  int sj) {

        int i=0, d=0, r=0;

        if (si == S1.length() && sj == S2.length()) return 0;
        if (si == S1.length()) return  S2.length() - sj;
        if (sj == S2.length()) return S1.length() - si;

        if (S1.charAt(si) == S2.charAt(sj)) return editfunction(S1,si+1, S2,sj+1);
        else {
            i = editfunction(S1,si, S2,sj+1); // Insert
            d = editfunction(S1,si+1, S2, sj); // Delete
            r = editfunction(S1,si+1, S2, sj+1); // Replace
        }

        int min = 0;
        min = i < d ? i: d;
        min = r < min? r: min;
        return min + 1;
    }


    public static void main(String []args) {

        String S1 = "ABC";
        String S2 = "ek";

        int distance = editfunction(S1,0,S2,0);
        System.out.println(distance);
    }


}
