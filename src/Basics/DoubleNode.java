package Basics;

public class DoubleNode {
    public DoubleNode previous;
    public DoubleNode next;
    public int data;

    public DoubleNode(int data){
        this.data = data;
        next = null;
        previous = null;
    }
}

