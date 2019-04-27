/* Problem statement:
Given number of nodes, write a program which would count number of  different binary trees which can be formed with
N nodes.

For e.g. If N =1 , number of trees is 1.
            N = 2, number of trees is 2.
            N = 3, number of trees is 5. root->left->left,
                                         root->left->right,
                                         root->right->right,
                                         root->right->left,
                                         root->left, root->right



Solution:
    For a root node, it can add a child in three ways
        To left,
        To right,
        or both left and right.

        left = totaltreefunc (left+1, right)
        right = totaltreefunc (left, right+1)
        both = totaltreefunc (left+1, right+1)

        return left + right + both.


        Base condition:

            if (left+right == MaxNode -1) return 1;   Root node is already counted
            if (left+right == maxnode) return 0;

 */

public class MaxBtreecount {
    static int MaxNode;


    public static int treetotal (int left, int right, char c[]) {


        /* MaxNode-1? , Root node is already counted */
        if (left+right == MaxNode -1 ) {
            for (int i = 0; i<MaxNode;i++) {
                System.out.print (c[i] + " ");
            }
            System.out.println();

            return 1;
        }

        if (left+right == MaxNode) {
            return 0;
        }

        c[left+right+1] = 'l';
        int lc  = treetotal(left+1, right,c);
        c[left+right+1] = 'r';
        int rc  = treetotal(left,right+1,c);
        c[left+right+1] = 'l';
        c[left+right+2] = 'r';
        int bc = treetotal(left+1, right+1, c);
         return lc + rc + bc ;
    }



    public static void main (String args[]){
        for (int i = 4; i<5; i++) {
            MaxNode = i;
            char c[] = new char[i+1];
            c[0]='R';
            System.out.println(i + " : " + treetotal(0, 0,c));
        }
    }
}
