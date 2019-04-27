package Graphs;
import java.util.*;

public class Graph {
    private int vertices;
    private int maxvertex;
    private HashMap<Integer, LinkedList<Integer>> adjlist;

    Graph(int V){
        this.vertices = V;
        this.adjlist =  new HashMap<>();
        for (int i = 0; i<V; i++){
            LinkedList<Integer> l = new LinkedList<>();
            adjlist.put(i, l);
        }
    }

    Graph(){
        this.vertices = 0;
        this.adjlist = new HashMap<>();
    }

    void addVertex(int v){
        if (adjlist.containsKey(v)) return;
        if (v > maxvertex) maxvertex = v;
        this.vertices++;
        LinkedList<Integer> l = new LinkedList<>();
        adjlist.put(v,l);
    }

    LinkedList<Integer> getEdges(int V) {
        return adjlist.get(V);
    }

    void addEdge (int V, int w) {
        if (adjlist.containsKey(V) == false) {
            addVertex(V);
        }
        if(adjlist.containsKey(w) == false) {
            addVertex(w);
        }
        adjlist.get(V).add(w);
    }

    Set getVertices(){
        return adjlist.keySet();
    }
    int getVerticesCount(){
        return vertices;
    }
    int getMaxvertex(){
        return maxvertex;
    }

    boolean ifexists(int V) {
        return adjlist.containsKey(V);
    }

}
