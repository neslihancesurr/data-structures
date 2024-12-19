package Graph;

public class GraphTest {
    public static void main(String[] args) {
        GraphMatrix graphMatrix = new GraphMatrix(4);
        GraphList graphList = new GraphList(5);

        graphList.insert(0,1,0);

        graphMatrix.addEdge(0,1);
        graphMatrix.addEdge(0,1,4);



    }
}
