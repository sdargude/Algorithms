package Graphs;

import com.sun.tools.corba.se.idl.IncludeGen;
import sun.misc.ASCIICaseInsensitiveComparator;

import java.util.ArrayList;
import java.util.Iterator;

public class DFS {

    static void traverse(int v, boolean visited[], Graph g, ArrayList output) {
        //no instance
        visited[v] = true;
        output.add(v);
        Iterator<Integer> i = g.getEdges(v).listIterator();
        for (boolean x : visited)
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                traverse(n,visited,g,output);
            }
        }
    }


    public static void main(String [] args) {
        int total = 4;
        Graph g = new Graph(total);
        boolean visited[] = new boolean[total];
        ArrayList<Integer> output = new ArrayList<>();
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);


        total = 6;
        Graph   gc = new Graph (total);
        boolean visitedvc[] = new boolean[total];
        output.clear();

        gc.addEdge('a'-'a', 'b'-'a');
        gc.addEdge('a'-'a', 'c'-'a');
        gc.addEdge('a'-'a', 'e'-'a');
        gc.addEdge('b'-'a', 'e'-'a');
        gc.addEdge('b'-'a', 'd'-'a');
        gc.addEdge('c'-'a', 'e'-'a');
        gc.addEdge('d'-'a', 'f'-'a');
        gc.addEdge('e'-'a', 'f'-'a');

        Iterator <Integer> it = gc.getEdges('c'-'a').iterator();

        System.out.println("Traversing");

        traverse('a'-'a', visitedvc,gc, output);
        for(Integer i : output)
            System.out.print(Character.toString((char)('a' + i)) + " ");
        System.out.println();


    }
}
