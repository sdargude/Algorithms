package Pattern4;

public class PalindromPartion {


    public static boolean isPalindrom(char c[], int start, int end) {

        for (int i = start; i<end; i++) {
            if (c[i] != c[end])
                return false;
            end = end - 1;
        }

        return true;
    }

    public static int partition (char c[], int start) {

        int min = Integer.MAX_VALUE;

        if (start >= c.length) return Integer.MAX_VALUE;

        for (int i = start; i<c.length; i++) {

            if (isPalindrom(c,start,i)) {
                min = Math.min(min, (i-start +1));
                min = Math.min(min, partition(c,i+1));
            }
        }

        return  min;

    }




    public static void main(String args[]) {

    }


}
