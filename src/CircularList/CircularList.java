package CircularList;

public class CircularList {
    DoubleNode head;

    public CircularList(){
        head = null;
    }

    public void addNode(DoubleNode newNode){
        if (head == null){
            head = newNode;
            newNode.next = newNode;
            newNode.previous = newNode;
        } else {
            newNode.next = head;
            newNode.previous = head.previous;
            head.previous.next = newNode;
            head.previous = newNode;
            head = newNode;
        }
    }
}
