package Graph;

public class GraphList {
    EdgeList[] edges;
    int vertexCount;

    public GraphList(int vertexCount){
        this.vertexCount = vertexCount;
        edges = new EdgeList[vertexCount];
        for(int i = 0; i < vertexCount; i++){
            edges[i] = new EdgeList();
        }
    }

    public void insert(int to, int from, int weight){
        Edge edge = new Edge(from, to, weight);
        edges[from].insert(edge);
    }
}
