package LinkedList;

import Basics.Node;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList(){
        head = null;
        tail = null;
    }

    public int length(){
        Node tmp = head;
        int number = 0;

        while (tmp != null){
            number++;
            tmp = tmp.next;
        }

        return number;
    }

    public void insertFirst(Node newNode) {
        if (tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            newNode.next = head; //make the next field of the new node point to the previous head FIRST
            head = newNode; //THEN set the new head as the new node
        }
    }

    public void insertLast(Node newNode){
        if (head == null){
            head = newNode;
        }
        else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void insertMiddle(Node newNode, Node previous){

        newNode.next = previous.next;
        previous.next = newNode;

    }

    public Node searchNode(int i){
        Node tmp = head;

        while (tmp != null){
            if (tmp.data == i){
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public int searchIndex(int number){
        Node tmp = head;
        int index = 0;

        while (tmp != null){
            if (tmp.data == number){
                return index;
            }

            tmp = tmp.next;
            index++;
        }

        return -1;
    }

    public Node searchIthNode(int i){ // Index number starting from 0
        Node tmp = head;
        int count = 0;

        while (tmp != null && count < i) {
            tmp = tmp.next;
            count++;
        }

        if (tmp==null){
            throw new IndexOutOfBoundsException("Index" + i + "is out of bounds.");
        }

        return tmp;
    }

    public void deleteLast(){
        Node tmp = head;
        Node previous = null;

        while (tmp != tail && tmp != null){
            previous = tmp;
            tmp = tmp.next;
        }

        if (previous == null){
            head = null;
            tail = null;
        } else {
            previous.next = null;
            tail = previous;
        }
    }


    public void deleteMiddle(Node deleted){
        Node tmp = head;
        Node previous = null;

        while (tmp != deleted){
            previous = tmp;
            tmp = tmp.next;
        }

        if (previous != null) {
            previous.next = deleted.next;
            deleted.next = null;
        }
    }

    public int nodeCount(){
        int count = 0;
        Node tmp = head;

        while (tmp != null){
            tmp = tmp.next;
            count++;
        }
        return count;
    }

    public LinkedList merge(LinkedList L1, LinkedList L2){
        if (L1.head == null){
            return L2;
        }
        if (L2.head == null){
            return L1;
        }

        LinkedList newList = new LinkedList();

        newList.head = L1.head;
        newList.tail = L2.tail;
        L1.tail.next = L2.head;

        return newList;
    }

    // Write a function that will find the smallest number in a singly linked list.

    public int smallestNumber(){
        Node tmp = head;
        int smallest = tmp.data;

        if (tail == null) {
            System.out.println("No elements in the linked list!");
            return 0;
        }
        else {
            while (tmp != tail) {
                if (smallest > tmp.next.data) {
                    smallest = tmp.next.data;
                }
                tmp = tmp.next;
            }
            return smallest;
        }
    }

    //Write a function that will ass a new node before the last node of a singly linked list.

    public void insertBeforeLast(Node newNode){
        Node tmp;
        Node previous = null;
        tmp = head;

        if (head.next == null){
            newNode.next = head;
            head = newNode;
        }
        else {
            while (tmp != tail) {
                previous = tmp;
                tmp = tmp.next;
            }

            newNode.next = tail;
            previous.next = newNode;
        }

    }

    public LinkedList getIndexed(LinkedList list){

        LinkedList newList = new LinkedList();
        Node tmpIndex = list.head;
        Node tmpNode = this.head;

        while (tmpIndex != null){
            int currentIndex = tmpIndex.data;

            for (int i = 1; i < currentIndex; i++){
                tmpNode = tmpNode.next;
            }

            Node newNode = new Node(tmpNode.data);

            if (newList.head == null){
                newList.head = newNode;
            } else {
                newList.tail.next = newNode;
            }
            newList.tail = newNode;

            tmpIndex = tmpIndex.next;
        }

        return newList;
        // find the first index go to that index get the data and put it in the new array.

    }





    }


// H - 1 - 2 - 3 - 4 - 5 - T
// H-1-T