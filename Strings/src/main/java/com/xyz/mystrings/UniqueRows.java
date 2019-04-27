package com.xyz.mystrings;

/*
Given a binary matrix your task is to complete the function printMat which prints all unique rows of the given matrix.

E.g.

Above the matrix of size 3x4 looks like
1 1 0 1
1 0 0 1
1 1 0 1
The two unique rows are 1 1 0 1 and 1 0 0 1 .

Solution:

    Trie:

    Insert each row in a trie and print the row if the isWord flag is true or last node is newlycreated.
    While inserting second row, if the we end up at the same node which has isword set to true then printit.


    One pass print, with space complexity of
    O (Alphabet_size * key_length * N) : Number of elements.
 */

public class UniqueRows {
}
