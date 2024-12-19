package Graph;

public class EdgeList {
    Edge head;
    Edge tail;

    public EdgeList(){
        head = null;
        tail = null;
    }
    public void insert(Edge newEdge){
        if (head == null){
            head = newEdge;
        } else{
            tail.next = newEdge;
        }
        tail = newEdge;
    }
}
