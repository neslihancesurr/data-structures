package Basics;

public class DoubleNode {
    public DoubleNode previous;
    public DoubleNode next;
    int data;

    public DoubleNode(int data){
        this.data = data;
        next = null;
        previous = null;
    }
}

