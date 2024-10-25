package Stack;

import Basics.Element;
import Basics.Node;

public class StackTest {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray(6);
        stackArray.push(new Element(3));
        stackArray.push(new Element(3));
        stackArray.push(new Element(3));
        stackArray.push(new Element(3));

        stackArray.pushK(3, 40);

        System.out.println("Array Stack:");
        stackArray.printStack();

        StackLinked stackLinked = new StackLinked();
        stackLinked.push(new Node(3));
        stackLinked.push(new Node(3));
        stackLinked.push(new Node(3));
        stackLinked.push(new Node(3));

        stackLinked.pushK(3, 40);

        System.out.println("Linked Stack:");
        stackLinked.printStack();


    }





}
