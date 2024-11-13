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


    // first 5  4  last
    public void printQueue(){
        Node tmp = first;

        System.out.println("First");
        while (true) {

            if (tmp == last){
                break;
            }

            System.out.println(tmp.data);
            tmp = tmp.next;
        }
        System.out.println("Last");
    }

    public void enqueue(Node newNode){
        if (isEmpty()){
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    // Handle the case for when the queue is empty.
    // Handle the case when there is only one element.
    public Node dequeue(){

        Node dequeued = first;

        if (!isEmpty()){
            first = first.next;
            if (first == null){
                last = null;
            }
        } else {
            System.out.println("Queue is empty!");
        }

        return dequeued;
    }


    //  first 4 last 5
    public void moveToRear(){
        if (isEmpty()){
            System.out.println("Empty queue!");
            return;
        }

        Node moved = dequeue();
        enqueue(moved);
    }

    public void removeOddIndexed(){
        QueueLinked external = new QueueLinked();

        int index = 1;
        while (!isEmpty()){
            if (index % 2 == 0) {
                external.enqueue(dequeue());
            } else {
                dequeue();
            }
            index++;
        }

        while (!external.isEmpty()){
            enqueue(external.dequeue());
        }
    }
}

