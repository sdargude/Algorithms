public class Palindrome2 {

    static boolean isPalindrom(String str) {

        str = str.toLowerCase().replaceAll("[^a-z0-9]","");
        StringBuilder strb = new StringBuilder(str);
        return strb.reverse().toString().equals(str);
    }

    public static void main (String [] args) {

        String s = "A man, a plan, canal: Panama ";


        System.out.println(s);
        System.out.println(isPalindrom(s));
    }
}
