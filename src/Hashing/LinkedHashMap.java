package Hashing;

import Queue.Element;
import SinglyLinkedList.LinkedList;

/**
 * This class shows the implementation of hash maps as linked lists.
 * This implementation illustrates the method of separate chaining to avoid collisions.
 * Both inserting and searching a specific element will take O(1) time.
 */
public class LinkedHashMap {
    LinkedList[] table;
    int N;

    /**
     * The constructor initializes the main static array of size N.
     * It iterates over the array to initialize a new linked list at every index.
     * @param N the length of the main static array
     */
    public LinkedHashMap(int N){
        table = new LinkedList[N];
        this.N = N;
        for (int i = 0; i < table.length; i++){
            table[i] = new LinkedList();
        }

    }
}
