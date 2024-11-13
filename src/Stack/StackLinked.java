package Stack;

import Basics.Element;
import Basics.Node;

public class StackLinked {
    Node top;

    public StackLinked(){
        top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(Node newNode){
        newNode.next = top;
        top = newNode;
    }

    public Node pop(){
        Node e = top;
        if (!isEmpty()){
            top = top.next;
        }
        return e;
    }

    private Node peek() {
        return top;
    }

    public void printStack(){
        Node tmp = top;

        while (tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    // push the data as k'th element from the top
    public void pushK(int k, int data){
        if(k == 1){
            this.push(new Node(data));
            return;
        }

        Node topNode = this.pop();
        pushK(k-1, data);
        this.push(topNode);
    }
    
    // 45(1) 78(2) 98(3) 34(4) 23(5) 46(6) -top
    // 78 34 46


    // implement external stack

    //put everything in the new stack

    //use pop and an index to find odd ones -push back even ones + get rid of odd ones
    void removeOddIndexed() {
        StackLinked external = new StackLinked();

        while (!isEmpty()) {
            external.push(pop());
        }

        int index = 1;
        while (!external.isEmpty()) {
            if (index % 2 == 0) {
                push(external.pop());
            } else {
                external.pop();
            }
            index++;
        }
    }
}
