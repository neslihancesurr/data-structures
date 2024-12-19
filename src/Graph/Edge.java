package Graph;

public class Edge {
    int from;
    int to;
    int weight;
    Edge next;

    public Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
        this.next = null;
    }
}
