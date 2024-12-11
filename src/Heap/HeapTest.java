package Heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap heap1 = new Heap(10);

        heap1.insert(new HeapNode(14, 14));
        heap1.insert(new HeapNode(8, 8));
        heap1.insert(new HeapNode(10, 10));
        heap1.insert(new HeapNode(4,4));
        heap1.insert(new HeapNode(7,7));
        heap1.insert(new HeapNode(9,9));
        heap1.insert(new HeapNode(3,3));
        heap1.insert(new HeapNode(2,2));
        heap1.insert(new HeapNode(1,1));

        heap1.printHeap();
        heap1.insert(new HeapNode(11, 11));
        heap1.printHeap();

        System.out.println(-1 / 2);

        //HeapNode node = heap1.deleteMax();




    }



}
