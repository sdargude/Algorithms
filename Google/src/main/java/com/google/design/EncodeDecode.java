package com.google.design;

/*
Design an algorithm to encode a list of strings to a string.
The encoded string is then sent over the network and is decoded back to the original list of strings.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {

    public static String encode (List<String> list) {
        StringBuilder sb = new StringBuilder();

        for (String s: list) {
            sb.append(s.length()).append("/").append(s);
        }

        return sb.toString();
    }

    public static List<String> decode(String s) {
            List <String> list = new ArrayList<>();

            int i  = 0;
            int start = 0;
            int count = 0;
            StringBuilder str = new StringBuilder();
        while(i < s.length()){

                count = start;
                str.setLength(0);

                while(s.charAt(count)!= '/'){
                    count++;
                }

                System.out.println(start+ " " + count);
                System.out.println("Length " + s.substring(start,count));
                int len = Integer.valueOf(s.substring(start,start+1));

                i=i+count+len+1;
                start=i;
            }

            return list;
    }


    public static void main(String args[]) {
//        List<String> list = Arrays.asList("Shailesh", "Neelesh", "Sheetal");
        List<String> list = Arrays.asList("63/Rc","h","BmI/k000kk","7uBZ?7*/","24h+X","O ");



        String encodedString = encode(list);

        for (int i = 0; i<encodedString.length();i++) {
            System.out.println(i + " : " + encodedString.charAt(i));
        }

        System.out.println("Decoded String: ");
        for (String s :decode(encodedString)) {
            System.out.println(s);
        }
    }
}
