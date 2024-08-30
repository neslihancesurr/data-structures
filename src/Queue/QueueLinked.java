package Queue;

import Basics.Node;

public class QueueLinked {
    Node first;
    Node last;

    public QueueLinked(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(Node newNode){
        if (isEmpty()){
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    public Node dequeue(){
        // Handle the case for when the queue is empty.
        // Handle the case when there is only one element.

        Node dequeued = first;

        if (!isEmpty()){
            first = first.next;
            if (first == null){
                last = null; // if the next field of first was null (only one element in the queue, the last should be updated to be null.
            }
        } else throw new IllegalStateException("Queue empty!");

        return dequeued;
    }

}
