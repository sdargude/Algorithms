package Palindrome;

import java.util.ArrayList;
import java.util.List;

public class PalindromPrint {


    boolean isPalindrome (String str, int low, int high) {
        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }





    public static void main(String [] args) {
        ArrayList<ArrayList <String>> listofList = new ArrayList<ArrayList<String>>();
        ArrayList<String> currentlist = new ArrayList<>();
        String s = "banana";
        PalindromPrint p = new PalindromPrint();


    }
}
