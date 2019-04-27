import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public static String mostCommonWord (String paragraph, String[] banned) {

        int count=0;
        String result=null;
        char [] array = paragraph.toCharArray();
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> hashmap = new HashMap<>();
        Set<String> bannedset = new HashSet<>();
        for (String s: banned) bannedset.add(s);


        for (char c : array){

            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
                continue;
            }

            if(sb.length() > 0) {
                String word = sb.toString();
           //     System.out.println(word);
                if (bannedset.contains(word)) {
                    sb.setLength(0);
                    continue;
                }
                hashmap.put(word, hashmap.getOrDefault(word, 0) + 1);
                int temp = hashmap.get(word);
                System.out.println(word + " " + temp);
                if (temp > count) {
                    count = temp;
                    result = word;
                }

                sb.setLength(0);
            }

        }

        if (result == null && sb.length() > 0){
            return sb.toString();
        }
        return result;
    }

    public static void main(String args[]){
       // String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
       // String [] banned = {"hit"};

        String paragraph = "Bob Babe Bob!";
        String [] banned = {"bob"};
        System.out.println(mostCommonWord(paragraph,banned));
    }

}
