package LinkedList;
import Basics.DoubleNode;
import Basics.Node;
import Stack.StackArray;

public class LinkedListTest {
    public static void main(String[] args) {

         LinkedList newList = new LinkedList();

        Node first = new Node(5);
        Node second = new Node(10);
        Node third = new Node(15);
        Node fourth = new Node(5);
        Node five = new Node(15);
        Node six = new Node(10);
        Node seven = new Node(15);
        Node eight = new Node(5);
        Node ten = new Node(10);

        newList.insertFirst(first);
        newList.insertLast(second);
        newList.insertLast(third);
        newList.insertLast(fourth);
        newList.insertLast(five);
        newList.insertLast(six);
        newList.insertLast(seven);
        newList.insertLast(eight);

        newList.insertLast(ten);


        System.out.println("First List After:");
        newList.printList();

        boolean flag = newList.containsOnlyTriplicates2();
        System.out.println(flag);

    }
}
