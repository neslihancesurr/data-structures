package Heap;

public class Heap {
    HeapNode[] array;
    int count;

    public Heap(int N){
        array = new HeapNode[N];
        this.count = 0;
    }
    
    public boolean isEmpty(){
        return count == 0;
    }

    public void printHeap() {
        if (isEmpty()) {
            System.out.println("Heap is empty!");
            return;
        }

        for (int i = 0; i < count; i++){
            System.out.print(array[i].data + " ");
        }

    }

    public int search(int name){
        int i;

        for (i = 0; i < count; i++){
            if (array[i].name == name){
                return i;
            }
        }
        return -1;
    }

    public void update(int index, int newValue){
        int oldValue = array[index].data;
        array[index].data = newValue;

        if (oldValue > newValue){
            percolateDown(index);
        } else {
            percolateUp(index);
        }
    }

    public void swapHeapNode(int index1, int index2){
        HeapNode tmpNode = array[index1];
        array[index1] = array[index2];
        array[index2] = tmpNode;
    }
    
    public HeapNode deleteMax(){
        HeapNode tmp = array[0];
        
        array[0] = array[count-1];
        percolateDown(0);

        count--;

        return tmp;
    }

    public void insert(HeapNode node){
        count++;
        array[count-1] = node;
        percolateUp(count-1);
    }

    private void percolateUp(int addedIndex) {
        int parent = (addedIndex - 1) / 2;

        while (parent > -1){
            if (array[parent].data < array[addedIndex].data){
                swapHeapNode(parent, addedIndex);
                addedIndex = parent;
                parent = (addedIndex - 1) / 2;
            } else {
                break;
            }
        }
    }

    public void percolateDown(int index) {
        int leftChild, rightChild, largerChild;

        while (true) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2 ;

            // Check if left or right child exists and find the larger child
            if (leftChild < count && (rightChild >= count ||
                    array[leftChild].data > array[rightChild].data)) {
                largerChild = leftChild;
            } else if (rightChild < count) {
                largerChild = rightChild;
            } else {
                break; // No children left to compare
            }

            // If the current node is smaller than the larger child, swap them
            if (array[index].data < array[largerChild].data) {
                swapHeapNode(index, largerChild);
                index = largerChild; // Move to the next index
            } else {
                break; // Heap property satisfied
            }
        }
    }
}
