package Hashing;

import Basics.Element;
import Basics.Node;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap linearMap = new HashMap(7);
        int[] insertedElements = {23, 33, 27, 51, 40, 51, 51};

        for (int i: insertedElements) {
            linearMap.insertQuadratic(new Element(i));
        }


        linearMap.printMap();
        linearMap.rehash();
        linearMap.printMap();




        // for (int i: insertedElements) {
        //   newMap.insertQuadratic(new Element(i));
        //}
       /*
        LinkedHashMap linkedMap = new LinkedHashMap(10);
        Node node1 = new Node(54);
        Node node2 = new Node(39);
        Node node3 = new Node(22);
        Node node4 = new Node(32);
        Node node5 = new Node(41);
        Node node6 = new Node(24);
        Node node7 = new Node(34);
        Node node8 = new Node(44);

        linkedMap.insertion(node1);
        linkedMap.insertion(node2);
        linkedMap.insertion(node3);
        linkedMap.insertion(node4);
        linkedMap.insertion(node5);
        linkedMap.insertion(node6);
        linkedMap.insertion(node7);
        linkedMap.insertion(node8);

        linkedMap.deletion(node1);
        linkedMap.printLinkedMap();
*/
        }
    }

