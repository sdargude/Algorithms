import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NutsBolts {

    static String [] solve (int nuts[], int bolts[]) {
        Map <Integer, Integer> mymap = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i: bolts) {
            mymap.put(i,0);
        }

        for (int i: nuts){
            if (mymap.containsKey(i))
                list.add(i + " " + i);
        }

        return list.toArray(new String[0]);
    }

    public static void main(String [] args) {
        int [] nuts = {4,32,5,7};
        int [] bolts = {32,7,4,5};

        String [] output = solve(nuts,bolts);
        for (String s : output) System.out.println(s);

    }

}
