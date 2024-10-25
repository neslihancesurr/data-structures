package LinkedList;
import Basics.Node;

public class LinkedListTest {
    public static void main(String[] args) {

        LinkedList newList = new LinkedList();
        Node first = new Node(5);
        Node second = new Node(10);
        Node third = new Node(15);
        Node fourth = new Node(20);


        newList.insertFirst(first);
        newList.insertLast(fourth);
        newList.insertMiddle(third, first);
        newList.insertMiddle(second, first);

       newList.listAll();
    }
}
