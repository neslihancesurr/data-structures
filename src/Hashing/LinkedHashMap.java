package Hashing;
import Basics.Node;
import LinkedList.LinkedList;

/**
 * This class shows the implementation of hash maps as linked lists.
 * This implementation illustrates the method of separate chaining to avoid collisions.
 * Both inserting and searching a specific element will take O(1) time.
 */

public class LinkedHashMap {
    LinkedList[] table;
    int N;

    public LinkedHashMap(int N){
        table = new LinkedList[N];
        this.N = N;
        for (int i = 0; i < table.length; i++){
            table[i] = new LinkedList();
        }
    }
    
    public void printLinkedMap(){
        for (int i = 0; i < N; i++){
            System.out.println(i + " th Index: ");
            table[i].printList();
        }
    }

    /**
     * The constructor initializes the main static array of size N.
     * It iterates over the array to initialize a new linked list at every index.
     * @param N the length of the main static array
     */
    public int hashFunction(int value){
        return value % N;
    }

    public int hashFunction(String stringValue){
        int i;
        int position = 0;

        for (i = 0; i < stringValue.length(); i++){
            position = 36 * position + stringValue.charAt(i);
        }
        position = position % N;
        return position;
    }

    /**
     * Search algorithm for linked list implementation of hash maps. The searched value is sent to the hash function
     * to find the index. The index is found in the static element array and the corresponding linked list
     * is searched with the searchNode algorithm from the LinkedList class.
     * @param searched the value to be search
     * @return the node with the corresponding value
     */
    public Node search(int searched){
        int index = hashFunction(searched);
        return table[index].searchNode(searched);
    }

    /**
     * Insertion algorithm for the linked list implementation of hash maps. The data within the node to be inserted
     * is sent to the hash function. The node is added to the linked list which is found in the corresponding index.
     * insertLast function from the Linked List class is used.
     * @param inserted the node to be inserted
     */
    public void insertion(Node inserted){
        int index = hashFunction(inserted.data);
        table[index].insertLast(inserted);
    }

    public void deletion(Node deleted){
        int index = hashFunction(deleted.data);
        LinkedList list = table[index];
        Node deletedNode = list.searchNode(deleted.data);

        if (deletedNode != null){
            if (deletedNode == list.head){
                list.deleteFirst();
            } else if (deletedNode == list.tail){
                list.deleteLast();
            } else {
                list.deleteMiddle(deletedNode);
            }
        }
    }
}
