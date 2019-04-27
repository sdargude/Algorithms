/*
Problem:
You are given a string s, containing only numerical characters ('0' - '9'). You are also given a non-negative number target.
You have to put between each pair of numerical characters, one of ("", "*", "+") operators such that the expression you get will evaluate to the target value.
Putting "" (an empty string) operator between two numerical characters means, that the they are joined (e.g. 1""2 = 12). Also the join can be extended further (e.g. 1""2""3 = 123).
Precedence of the operators matters. In higher to lower precedence:
Join ("") > Multiplication ("*") > Addition ("+")

Example:
s = "222"  and target = 24
Sample Output: ["22+2", "2+22"]


Solution:

    This can be solved by getting all permutation of string s and operators.  Hence base conditons becomes i==stringlen/

    We start with i = 1, on next steps there are always three possible branches to recurrsion,
    skip or + or *, every case we increase i. Since we have to evaluate the expression, we will have to store the
    expression in additional character array.

    Once we hit base condition, expression, which in our case will be infix expression, needs to evaluated and printed
    if the value is same as target.


    Complexity:
        Branching factor is of 3, hence base is 3.  Since we start with i= 1, we have compexity of 3 ^ (n-1).
        For every base case expression is evaluated, which is popping and pushing to stack. 2*n.

        Hence total time complexity is 3 ^ (n-1) * 2* n;
 */

import java.util.Stack;

public class PossibleExpression {


    static boolean evalexpression ( String expression, int target) {

        Stack<Integer> stack = new Stack<>();
        char array[]=expression.toCharArray();

        for (int i = 0;i<array.length;i++){

            if (array[i] == '*') {
                int pop = stack.pop();
                int value = Character.getNumericValue(array[i+1]) * pop;
                stack.push(value);
                i++;
                continue;
            }else if (array[i] == '+') {
                continue;
            }else{
                String number="";
                for (int j = i; j<array.length;j++) {
                        if (array[j]=='*' || array[j]=='+') {
                            i=j-1;
                            break;
                        }
                        number=number+array[j];
                        i++;
                }
                stack.push(Integer.valueOf(number));
            }
        }

        int finalvalue=0;
        while(!stack.empty()) {
            finalvalue+=stack.pop();
        }

        if (finalvalue == target) return true;
        return false;
    }

    static void permutation(char []array, String expression, int i, int target) {

        if (i == array.length) {

            if (evalexpression(expression,target)){
                System.out.println(expression);
            }
            return;
        }

        permutation(array, expression + array[i] , i+1, target );
        permutation(array, expression + "+" + array[i] , i+1, target );
        permutation(array, expression + "*" + array[i] , i+1, target );
        return;
    }

    public static void main (String [] args) {
        String s = "222";
        int target = 24;
        char array[] = s.toCharArray();
        permutation(s.toCharArray(),array[0]+"" ,1, target);
        evalexpression ("222" ,1231);
    }
}
