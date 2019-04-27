import java.util.PriorityQueue;
import java.util.Queue;

public class Heap {

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(100, (o1,o2)-> o2-o1);
        q.add(41);
        q.add(8);
        q.add(15);
        q.add(1);
        q.add(3);
        System.out.println(q.peek());
        System.out.println(q.size());
        q.remove(q.peek());
        System.out.println(q.peek());

    }
}
