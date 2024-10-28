package Stack;

import Basics.Element;
import Basics.Node;

public class StackTest {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray(6);
        stackArray.push(new Element(77));
        stackArray.push(new Element(3));
        stackArray.push(new Element(3));
        stackArray.push(new Element(4));
        stackArray.push(new Element(5));
        stackArray.pushK(3, 40);

        System.out.println("Array Stack: ");
        stackArray.printStack();

        System.out.println(stackArray.multiply());


       // StackLinked stackLinked = new StackLinked();
       // stackLinked.push(new Node(3));
       // stackLinked.push(new Node(3));
       // stackLinked.push(new Node(3));
       // stackLinked.push(new Node(3));

       // stackLinked.pushK(3, 40);

        //System.out.println("Linked Stack:");
       // stackLinked.printStack();

    }





}
