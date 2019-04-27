package Graphs;

/* Given  array of strings (dictionary), determine order of characters in it.
    E.g. Given words = ["baa", "abcd", "abca", "cab", "cad"], ouput should be "bdac".

    Algorithm: Compare two strings, if first char is not same then there
        is a edged between two first chars, else move the pointers of both strings to next.

        Once graph is created, for each vertex  do dfs push the output of dfs to end of string.
*/

import java.util.*;

public class AlienDictionary {
    static int index = 0;
    static int dfs (Graph g, int start, boolean visited[], char output[]) {
            LinkedList<Integer> list = g.getEdges(start);
            Iterator<Integer> it = list.iterator();
            visited[start] = true;
            output[index++] =  (char)(start+'a');
            while (it.hasNext()) {
                int i = it.next();
                if (visited[i]) continue;
                dfs(g, i, visited, output);
            }

            return index;
    }

    static String topologicalSort (Graph g){
        int total = g.getVerticesCount();
        boolean visited[] = new boolean[g.getMaxvertex()+1];
        char output[] = new char[total];
        char sorted[] = new char[total];
        Set<Integer> s = g.getVertices();
        Iterator<Integer> it = s.iterator();

         int scount =total-1;
         while(it.hasNext()) {
            int start = it.next();
            if (visited[start] == true) continue;
            index = 0;
            int count = dfs(g, start, visited, output);
            while (count >0) {
                sorted[scount] = output[count-1];
                count--;
                scount--;
            }
            total = total-count;
        }
        return new String(sorted);
    }

    static String find_order(String words[]) {

        Graph  g = new Graph();
        int totalWords = words.length;
        char cur [] = words[0].toCharArray();
        int curlen = cur.length;

        g.addVertex(cur[0]-'a');

        for (int i=1;i<totalWords;i++){

            char next[] = words[i].toCharArray();
            int nextlen = next.length;

            g.addVertex(next[0]-'a');

            if (next[0] != cur[0]){
               g.addEdge(cur[0]-'a', next[0]-'a');
            } else {

                int j=0, k= 0;

                while(cur[j] == next[k]) {
                    k++;j++;
                    if ( j >= curlen || k>= nextlen) break;
                }

                if (j<curlen && k<nextlen) {
                  g.addEdge(cur[j]-'a', next[k]-'a');
                }

            }

            cur = next;
            curlen = next.length;
        }


//        int total = g.getVerticesCount();
//        boolean visited[] = new boolean[g.getMaxvertex()+1];
//        char output[] = new char[total];
//
//        int count = dfs(g,'b'-'a', visited,output);
//        System.out.println(count);
        return topologicalSort(g);
        //return null;
    }



    public static void main(String args[]){
         // String words[] = {"baa", "abcd", "abca", "cab", "cad"};
         // String words[] = {"z", "a"};
         // String words[] = {"a", "ab", "acb", "aca", "aa"};
        //  String words[] = {"caa", "aaa", "aab"};
            String words[] = {"ddadd", "ddddd", "ddddd","ddcdd"};

        System.out.println(find_order(words));
    }
}
