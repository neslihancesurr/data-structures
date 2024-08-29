package Stack;

import SinglyLinkedList.Node;

public class StackLinked {
    Node top;

    public StackLinked(){
        top = null;
    }

    boolean isEmpty(){
        return top == null;
    }

    void push(Node newElement){
        newElement.next = top;
        top = newElement;
    }

    void pop(){
        

    }
}
