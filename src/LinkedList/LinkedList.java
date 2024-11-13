package LinkedList;
import Basics.DoubleNode;
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
        }
        newNode.next = head;
        head = newNode;
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

    public void printList(){
        Node temp = head;

        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
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

    public Node searchIthNode(int i) { // Index number starting from 0
        Node tmp = head;
        int count = 0;

        while (tmp != null && count < i) {
            count++;
            tmp = tmp.next;
        }

        if (tmp == null) {
            throw new IndexOutOfBoundsException("Index" + i + "is out of bounds.");
        }

        return tmp;
    }

    public void deleteFirst(){
        //different from the code in the book
        if (head == null){
            System.out.println("The list is already empty.");
            return;
        }
        head = head.next;

        if (head == null){
            tail = null;
        }
    }

    //we know there is at least one element
    //if there is only one element, head will point to null.
    //tail also needs to point to null

    public void deleteLast(){
        Node tmp = head;
        Node previous = null;

        if (head == null){
            System.out.println("The list is already empty!");
            return;
        }

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

    public void listAll() {
        Node tmp = head;

        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public LinkedList reverse() {
        Node prev = null;
        Node current = head;
        Node following = null;

        // Traverse through the list and reverse the links
        while (current != null) {
            following = current.next;   // Store the next node
            current.next = prev;   // Reverse the current node's pointer
            prev = current;        // Move `prev` one step forward
            current = following;        // Move `current` one step forward
        }

        // Update the head to the new first node (prev)
        head = prev;
        return this;  // Return the modified list
    }
    public static LinkedList primeFactors(int N) {
        LinkedList factors = new LinkedList();

        // Divide N by 2 as long as it's divisible
        while (N % 2 == 0) {
            factors.insertLast(new Node(2));
            N /= 2;
        }

        // Now check for odd factors from 3 onwards
        // You increment by 2 to check/divide by all odd numbers. Square root is for the optimization
        for (int i = 3; i <= Math.sqrt(N); i += 2) {
            while (N % i == 0) {
                factors.insertLast(new Node(i));
                N /= i;
            }
        }

        // If N is still greater than 2, it must be prime
        if (N > 2) {
            factors.insertLast(new Node(N));
        }

        return factors;
    }

    // Exercise 29
    public void deletePrimes() {
        if (head == null) {
            return;
        }
        Node current = head;
        Node previous = null;

        while (current != null)
            if (isPrime(current.data)) {
                if (current == head) {
                    deleteFirst();
                } else {
                    deleteMiddle(current);
                }
            }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 5  6  3  5  6  3  6
    // temp 3
    // inner 5
    public boolean containsOnlyTriplicates(){
        Node temp = head;
        Node innerTemp;

        while (temp != null) {
            int currentData = temp.data;
            innerTemp = head;
            int count = 1;
            while (innerTemp != null){
                if (temp != innerTemp){
                    if (currentData == innerTemp.data){
                        count++;
                    }
                }
                innerTemp = innerTemp.next;
            }
            if (count != 3){
                return false;
            }

            temp = temp.next;
        }
        return true;
    }

    public boolean containsOnlyTriplicates2() {
/** ASSESSMENT
 * @grade 1
 * @feedback
 */
        Node current = head;

/** ASSESSMENT
 * @grade 13
 * @feedback outer while 5, inner while 6, if check 2
 */
        while (current != null) {
            Node innerCurrent = head;
            int count = 1;
            while (innerCurrent != null) {
                if (innerCurrent.data == current.data) {
                    count++;
                }
                innerCurrent = innerCurrent.next;
            }
            if (count != 3) {
                return false;
            }
            current = current.next;
        }
/** ASSESSMENT
 * @grade 1
 * @feedback
 */
        return true;
    };

}


// H - 1 - 2 - 3 - 4 - 5 - T
// H-1-T