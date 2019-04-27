/*

Give an string, find a longest palindromic substring.

e.g. s="abcbad"

abcba 5
bcb 3

hence abcba is a longest palindromic substring.


Solution:

1. Brute force solution:

        Find all substring and check if each is palindrome.  Worst case n * n to find substring and for each substring
        find if its palindrome. Hence total is n*n*n = n^3.


2.  A string is a palindrome if the left and right halves of the center are same.

    In case of odd length string, center is one element.
    In case of even length string, center is of two elements.

    if can  have a function which would check left and right of a center and if they are equal expand, till they are not
    same. The function would give us palindrome.


    int blackbox (char[] a, int start, int end)   in case of odd, start==end, in case even they differ by one.

        diff = end-start +1;
        count=0;
        while(start>=0 && end < a.length){


            if (a[start] == a[end])
                count++;
                start--;
                end++;

            else break;

        }

        return count + diff;

end-start+count
 */



public class LongestPalindromeSubstring {

    public static int search(char[] a, int start, int end) {

        int diff = end - start + 1;

        int count = -1;

        while (start>=0 && end <a.length && a[start] == a[end]) {
            start--;
            end++;
            count++;
        }

        return 2*count+diff;
    }



    public static int lps(char[] s) {

        int max = 0;



        for (int i=0; i<s.length;i++) {
            int max1 = search(s,i,i);
            int max2 = search(s,i,i+1);
            System.out.println(max1 + " : " + max2 + " " + i);
            max = Math.max(max,Math.max(max1,max2));
        }

        return max;
    }

    public static void main (String args[]) {


        String s = "ababcd";

        System.out.println(lps(s.toCharArray()));

        System.out.println(search(s.toCharArray(),2,2));

    }
}
