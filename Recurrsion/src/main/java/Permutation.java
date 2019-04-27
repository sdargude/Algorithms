public class Permutation {

    static void swap(char a[], int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /* Time complexity of this function is O(N . N!) , space complexity is O(N) */

    static void permutate(char[] a, int start) { /* O(N!) */

        if (start == a.length -1) {
            System.out.println(a); /* O(n) */
            return;
        }

        for (int i=start; i<a.length; i++) {
            swap(a,start,i);
            permutate(a,start+1);
            swap(a,start,i);
        }
    }

    public static void main(String[] args) {
        char a [] = {'A','B','C','D'};
        permutate(a,0);
    }
}