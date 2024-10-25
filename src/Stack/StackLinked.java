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

    // 4 7 3 9 7(top)
    // 4 7 3 6 9 7(top)
    // (3, 6)

    // 7yi tut, 9u kaydır, 6yı koy, 7yi en tepeye ekle top yap


}
