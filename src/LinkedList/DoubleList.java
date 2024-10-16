package LinkedList;
import Basics.DoubleNode;

public class DoubleList {
    DoubleNode head;
    DoubleNode tail;

    public DoubleList() {
        head = null;
        tail = null;
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

    public void cutPaste(DoubleNode first, DoubleNode last, DoubleNode paste){

    }

    public void deletePrimes() {
        if (head == null) {
            return; // Liste boşsa, hiçbir şey yapma
        }
        DoubleNode current = head; // Baş düğümden başla
        DoubleNode prev = null; // Önceki düğüm için referans
        while (current != null) {
            if (isPrime((current).data)) { // Geçerli düğüm asal mı kontrol et
                if (current == head) {
                    head = head.next; // Baş düğümse, başı bir sonraki düğüme güncelle
                    if (head != null) {
                        head.previous = null; // Yeni baş düğümün prev referansını null yap
                    }
                } else {
                    // Önceki düğümün next referansını geçerli düğümün bir sonraki düğümüne ayarla
                    prev.next = current.next;
                    if (current.next != null) {
                        current.next.previous = prev; // Geçerli düğümden sonraki düğümün prev referansını önceki düğüme ayarla
                    }
                }
            } else {
                prev = current; // Eğer düğüm asal değilse, önceki düğümü güncelle
            }
            current = current.next; // Geçerli düğümü bir sonraki düğüme taşı
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





}


// H - 1 - 2 - T
