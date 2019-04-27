
/* Problem: Given a String, print all subsets/substrings of the string.

e.g. a = {t,d,c}

possible subsets are
{}
t
td
tdc
tc
d
dc
c

Solution:  The recurrsion can be seen as  2 sub problems
  {t} {dc}
  {}  {dc}

  first element is present in first recurrsion with subproblem of remainining string.
  In second call first element is not present, with subproblem of remainaing string.

  base condition : when size of subproblem is zero or size of first element is equal to size of original string.

    Time complexity of the algorithm is O(n x 2^n).
    Space complexity of the algorithm is hieght of the recurrsion tree, which is number of function calls on the stack.
    In this case max would O(n).

 */


public class SubSets {

    static int count = 0;
    static void findsubset(char current[], char array[], int start, int currpointer) {

        if (array.length == start) {
            for (int i = 0 ; i< currpointer;i++) /*(O(n))*/
                System.out.print(current[i]);
            System.out.println(" " + count++);
            return;
        }

        findsubset(current, array, start+1,currpointer); /*O(2 ^ n) */ //skip
        current[currpointer] = array[start];
        findsubset(current,array,start+1,currpointer+1); //Pick.
    }

    public  static void main(String a[]) {
        char array[] = {'B','A','N','A', 'N'};
        char current[] = new char[array.length];
        findsubset(current,array,0,0);

    }

}
