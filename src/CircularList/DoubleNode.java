package CircularList;

public class DoubleNode {
    DoubleNode previous;
    DoubleNode next;
    int data;

    public DoubleNode(int data){
        this.data = data;
        next = null;
        previous = null;
    }
}

