package Stack;

import Basics.Element;
import Basics.Node;

public class StackTest {
    public static void main(String[] args) {

        StackLinked stackLinked = new StackLinked();
        stackLinked.push(new Node(1));
        stackLinked.push(new Node(6));
        stackLinked.push(new Node(2));
        stackLinked.push(new Node(8));
        stackLinked.push(new Node(3));
        stackLinked.push(new Node(9));
        //stackLinked.push(new Node(7));

        stackLinked.printStack();

        stackLinked.removeOddIndexed();
        System.out.println("After:");
        stackLinked.printStack();
    }
}

