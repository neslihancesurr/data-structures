package Graph;
// N^2 cells of memory even when there are few edges.
public class GraphMatrix {
    int[][] edges;
    int vertexCount;

    public GraphMatrix(int vertexCount){
        this.vertexCount = vertexCount;
        edges = new int[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; i++){
            for (int j = 0; j < vertexCount; j++){
                edges[i][j] = 0;
            }
        }
    }

    public void addEdge(int from, int to){
        edges[from][to] = 1;
    }
    public void addEdge(int from, int to, int weight){
        edges[from][to] = weight;
    }
}
