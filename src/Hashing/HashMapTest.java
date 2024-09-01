package Hashing;

import Basics.Element;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap newMap = new HashMap(10);
        HashMap linearMap = new HashMap(10);
        int[] insertedElements = {71, 23, 73, 99, 44, 79, 89, 79, 85, 77, 60, 54 , 32, 78};

       // for (int i: insertedElements) {
         //   newMap.insertQuadratic(new Element(i));
        //}

        for (int i: insertedElements) {
            linearMap.insertLinear(new Element(i));
        }

        linearMap.printMap();
        }
    }

