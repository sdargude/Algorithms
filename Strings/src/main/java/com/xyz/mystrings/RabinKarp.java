package com.xyz.mystrings;


/* Rabin Karp algorithm is a linear time algorithm to find a substring/pattern in a given string

  Str : Len N
  Pat : Len M

  Search time is N  + Time take for prep is M.  Total time taken (N+M)

  Idea of Rabin Karp algorithm, is rolling hash with sliding window. Given a pattern compute a hash value with hash
  function. say Hp.

  For actual string

  A X X X X X X X X X X X
  _____   hashvalue for window.
    _____   hasvalue for window.
      _____
        ______


If hash value of anyof the window patches the hashvalue of pattern, then it's a match.


Rolling hash

A B C D E  are the alphabets in dictionary,  A=1,B=2,C=3,D=4,E=5 (#of distinct characters are 5).

Window size is 3.

String: ADBAED

hashfunction ("ADC") = valueof(A) * 5 pow(2) + valueof(D) * 5 pow(1) + valueof(C) * 5 pow(0)


move right by one position

hashfunction ("DBA") =  [ hashfunction("ADC") - valueof(A) * 5 pow(2) ] * 5 + valueof(A).



If # of disctinct characters are more , say 256 (Ascii values) then 256 * power of strlen will be a very high number.
It would better to do a moduluo operations (% #distinct characters

With modulo operations there is a chance of hash collision, we will have to perform addition check even when the hashvalue
of pattern and window matches.


Hence effective time for search is (M + N) + 1/P NM.

P is probability of hash collision.

 */
public class RabinKarp {


    static long rollinghash(String str, int i, int k, int size) {
        long value = 0;
        if (i == 0) {
            for (int j = 0; j<k ; j++) {

            }
        }


        return 0;
    }


}
