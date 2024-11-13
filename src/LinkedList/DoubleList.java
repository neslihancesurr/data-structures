package LinkedList;
import Basics.DoubleNode;

public class DoubleList {
    DoubleNode head;
    DoubleNode tail;

    public DoubleList() {
        head = null;
        tail = null;
    }

    public void printList(){
        DoubleNode temp = head;

        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void insertFirst(DoubleNode newNode) {

        if (tail == null) {
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
        }
        head = newNode;
    }

    public void insertLast(DoubleNode newNode) {

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }

        tail = newNode;
    }

    public void insertMiddle(DoubleNode newNode, DoubleNode before) {
        newNode.previous = before;
        newNode.next = before.next;
        before.next.previous = newNode;
        before.next = newNode;
    }

    public void deleteFirst() {
        if (tail == head) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
    }

    public void deleteFirstNode() {
        head = head.next;

        if (head == null) {
            tail = null;
        } else {
            head.previous = null;
        }
    }

    public void deleteLast() {
        tail = tail.previous;

        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
    }

    public void deleteMiddle(DoubleNode deleted) {
        deleted.previous.next = deleted.next;
        deleted.next.previous = deleted.previous;
    }

    public boolean isPalindrome() {
        DoubleNode p1 = head;
        DoubleNode p2 = tail;

        while (p1 != p2 && p1.next != p2) {

            if (p1.data != p2.data) {
                return false;
            } else {
                p1 = p1.next;
                p2 = p2.previous;
            }
        }
        return true;
    }

    void removeKthElementBeforeLast(int K) {

        DoubleNode tmp = this.tail;
        int numberOfElements = 1;

        while (tmp != head) {
            tmp = tmp.previous;
            numberOfElements++;
        }

        if (numberOfElements == K){
            head.next.previous = null;
            head = head.next;
        } else if (numberOfElements == 1){
            tail.previous.next = null;
            tail = tail.previous;
        } else {
            tmp = this.tail;

            for (int i = 1; i <= K; i++){
                tmp = tmp.previous;
            }

            tmp.previous.next = tmp.next;
            tmp.next.previous = tmp.previous;
        }
      }

      // Exercise 12
      // 4 (76 23 45) 2 34        5 8 98 (first..last) 4 32 6
    public void cutPaste(DoubleNode first, DoubleNode last, DoubleNode paste){
        // keep the information of the remaining nodes to link them back together later
        DoubleNode remainingBefore = first.previous;
        DoubleNode remainingAfter = last.next;

        // previous field of first + next field of paste + next field of last + previous field of after last(paste.next)
        first.previous = paste;
        last.next = paste.next;
        paste.next.previous = last;
        paste.next = first;

        // link the remaining nodes of the original list
        remainingBefore.next = remainingAfter;
        remainingAfter.previous = remainingBefore;
    }

    // 4 (76 23 45) 2 34        5 8 98 (first..last) 4 32 6
    // 76 23 45                     copiedFirst    loopingElement
    public void copyPaste(DoubleNode first, DoubleNode last, DoubleNode paste){
        DoubleNode temp = first;
        DoubleNode copiedFirst = new DoubleNode(first.data);
        DoubleNode loopingElement = copiedFirst;

        while (temp != last){
            temp = temp.next;
            DoubleNode copiedNode = new DoubleNode(temp.data);
            loopingElement.next = copiedNode;
            copiedNode.previous = loopingElement;
            loopingElement = copiedNode;
        }
        // copy of last is now looping element -

        loopingElement.next = paste.next;
        paste.next.previous = loopingElement;
        paste.next = copiedFirst;
        copiedFirst.previous = paste;
    }
    void copyPaste2(DoubleNode first, DoubleNode last, DoubleNode copy) {
        DoubleNode copied = first, pasted = copy;
        DoubleNode next = copied.next, newNode;

        while (copied != tail.next) {
            newNode = new DoubleNode(copied.data);
            newNode.previous = pasted;
            pasted.next = newNode;
            copied = copied.next;
            pasted = newNode;
        }
        next.previous = pasted;
        pasted.next = next;
    }

    public void deletePrimes() {
        if (head == null) {
            return;
        }
        DoubleNode current = head;
        DoubleNode prev = null;
        while (current != null) {
            if (isPrime((current).data)) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.previous = null;
                    }
                } else {

                    prev.next = current.next;
                    if (current.next != null) {
                        current.next.previous = prev;
                    }
                }
            } else {
                prev = current;
            }
            current = current.next;
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



    // Exercise 11  - 1 2 -  3 4 5 - 4 5 3 4
  //                  2 1
    //  first.previous   first second   second.next
    public void swapTwoNodes(DoubleNode first, DoubleNode second){
        if (head == null){
            System.out.println("The list is empty.");
            return;
        }
        if (head == tail){
            System.out.println("The list contains only one element.");
            return;
        }
        if (head == first && tail == second){
            first.previous = second;
            first.next = null;
            second.previous = null;
            second.next = first;
            head = second;
            tail = first;
            return;
        }
        if (first == head){
            head = second;
            first.previous = second;
            first.next = second.next;
            second.next.previous = first;
            second.previous = null;
            second.next = first;
        } else if (second == tail) {
            tail = first;
            second.next = first;
            second.previous = first.previous;
            first.previous.next = second;
            first.previous = second;
            first.next = null;
        } else {
            first.previous.next = second;
            first.previous = second;
            first.next = second.next;
            second.next.previous = first;
            second.next = first;
        }
    }


    // Exercise 32
    // 7 45 82 98 34 84 3 9 23    new list:45 98 84 9
    public DoubleList getEvenOnes(){

        DoubleList newList = new DoubleList();
        DoubleNode temp = head;
        int count = 1;

        while (temp != null){
            if (count % 2 == 0){
                DoubleNode newNode = new DoubleNode(temp.data);
                if (newList.head == null){
                    newList.head = newNode;
                    newList.tail = newNode;
                } else {
                    newNode.previous = newList.tail;
                    newList.tail.next = newNode;
                    newList.tail = newNode;
                }
            }
            count++;
            temp = temp.next;
        }
        return newList;
    }

    public void reverse(){

    }
}
