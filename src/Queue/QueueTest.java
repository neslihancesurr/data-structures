package Queue;

import Basics.Element;
import Basics.Node;

public class QueueTest {
    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(10);
        QueueArray queueArray2 = new QueueArray(10);
       // System.out.println(queueArray.last);
       // System.out.println(queueArray.first);
       // System.out.println(queueArray.isEmpty());
       // System.out.println(queueArray.isFull());

        queueArray.enqueue(new Element(1));
        queueArray.enqueue(new Element(2));
        queueArray.enqueue(new Element(3));
        queueArray.enqueue(new Element(4));
        queueArray.enqueue(new Element(5));

        queueArray2.enqueue(new Element(88));
        queueArray2.enqueue(new Element(32));

        queueArray.cutPaste(queueArray2, 1,3);

        queueArray.printQueue();
        queueArray2.printQueue();




  /*      QueueLinked queueLinked = new QueueLinked();
        queueLinked.enqueue(new Node(1));
        queueLinked.enqueue(new Node(2));
        queueLinked.enqueue(new Node(3));
        queueLinked.enqueue(new Node(4));
        queueLinked.enqueue(new Node(5));
        queueLinked.enqueue(new Node(6));
        queueLinked.enqueue(new Node(7));

        queueLinked.removeOddIndexed();
        queueLinked.printQueue();*/

    }
}
