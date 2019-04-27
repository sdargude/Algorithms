/*
Problem:
Given positive integer n, find all well formed round brackets of length 2n.

example: n=3
output=[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

public class Brackets {

    static boolean areBalanced(char []s) {
        int left = 0;
        int right = 0;

        for (int i = 0; i<s.length;i++) {
            if (s[i] == '(') {
                left++;
            } else if (s[i] == ')') {
                right++;
            }
            if (right > left) return false;
        }
        if (left == right) return true;
        return false;
    }

    static void printBrackets (char[] output, int i, int end) {
        if (i == end ) {
            if (areBalanced(output)) {
                System.out.println(output);
            }
            return;
        }
        output[i]='(';
        printBrackets(output,i+1, end);
        output[i]=')';
        printBrackets(output,i+1,end);
        return;
    }

    public static void main(String [] args) {
        int n = 3;
        char output[] = new char[2*n];
        output[0]='(';
        printBrackets(output,1,2*n);
    }
}
