import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class myArrayList {

    public static void main(String args[]) {

        ArrayList<String> mylist = new ArrayList<String>();
        mylist.add ("Hello");
        mylist.add("World");

        System.out.println(mylist);

        for (String x: mylist) {
            System.out.println(x);
        }


        mylist.remove("Hello");
        mylist.remove(0);
        System.out.println(mylist);

        mylist.add("IL");
        mylist.add("CA");
        mylist.add("NY");
        mylist.add("AK");
        mylist.add("AK");
        System.out.println(mylist);

;
        System.out.println(mylist.indexOf("CA"));
        System.out.println(mylist.size());

        Collections.sort(mylist);
        System.out.println(mylist);

        Collections.sort(mylist,Collections.reverseOrder());
        System.out.println(mylist);

        Collections.shuffle(mylist);
        System.out.println(mylist);

    }

}
