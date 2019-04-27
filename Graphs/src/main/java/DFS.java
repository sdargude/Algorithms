import java.util.ArrayList;
import java.util.List;

class Vertex {
    private int label;
    private List<Vertex> alist;

    Vertex(int label) {
        this.label = label;
        alist = new ArrayList<>();
    }

    void addEdge(Vertex toVertx) {
        alist.add(toVertx);
    }

    List<Vertex> getalist(Vertex toVertex) {
        return alist;
    }
}


public class DFS {
    public static void main(String[] args) {

        List<Vertex> list = new ArrayList<>();

        for (int i = 0; i< 5; i++) {
            list.add(i, new Vertex(i));
        }


    }
}
