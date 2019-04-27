
import java.util.ArrayList;
import java.util.List;

public class Wordbreak {

    void wordBreak(String s, String out, List<String>dict) {
        if (s.length()==0) {
            System.out.println(out);
            return;
        }

       // System.out.println(s);
        for (int i = 1 ;i <= s.length();i++ ){
            String prefix  = s.substring(0,i);
            if (dict.contains(prefix)) {
                // System.out.println(prefix);
                wordBreak(s.substring(i), out + " "+ prefix, dict);
              //  wordBreak(s.substring(i), out, dict);

            }
        }
    }

    public static void main(String[] s){
        List<String> dict =  new ArrayList<>();
        dict.add("kick");
        dict.add("start");
        dict.add("kickstart");
        dict.add("is");
        dict.add("awe");
        dict.add("some");
        dict.add("awesome");



        Wordbreak w = new Wordbreak();

        w.wordBreak("kickstartisawesome", "", dict);

    }
}
