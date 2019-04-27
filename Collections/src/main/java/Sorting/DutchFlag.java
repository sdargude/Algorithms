package Sorting;

import static Sorting.DutchFlag.swap;

public class DutchFlag {
    public static void swap(char [] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static String dutch_flag_sort(String str) {

        int r=0,b=0,g=0,i=0;
        char [] s = str.toCharArray();
        int len = s.length;
        b = len-1;
        System.out.println(r+ " " + g + " " + b);


        while(g<=b){
            System.out.println (" " + s[g] + " " + g);
            if (s[g] == 'B') {
                swap(s,b,g);
                b--;
            } else if (s[g] == 'G'){
                g++;

            } else if (s[g] == 'R'){
                swap(s,g,r);
                g++;
                r++;
            }

            System.out.println(s);
            System.out.println(r+ " " + g + " " + b);
        }
        return new String(s);
    }

    public static void main (String []s) {
       // String str = "BGRGBBRGBGRBGGBBRRRBRBGGGGGRRBGGBBBGGGRGGBBRGGBRGBRGBGBGBRBRBBGBGBGRGGBBBRRGRRBRRBRGBRRGGGGBRGRBRGGBBGRRBRGBGBGRRBGBRBBRGBBRBGBBGRBRRGRBBGBGBGRGRGGBBBBGBGRBBGRRRRGRBRBGGGRRRBGRBBGBGRBGGBRBBBGGGBRGRRRRRGBGRBRRRGGRRRGBBGBRBBGGBGRBBBRGBGBGBGBRBRGGRGGRRR";
        String str = "BGRGBBRG";
        System.out.println(str);
        String p = dutch_flag_sort(str);
        System.out.println(p);
    }
}
