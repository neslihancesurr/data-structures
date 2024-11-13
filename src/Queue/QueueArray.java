package Queue;

import Basics.Element;


/*    The element objects are stored in a static array.
      One integer points to the first element (first) and another points to the node after the last element (last).
      We also create and int to store the total number of elements.
*/

public class QueueArray {
    Element[] array;
    int first;
    int last;
    int N;

    // When first created with no elements, the first and last elements are equal to 0.
    // The first element does not necessarily start from the 0th index and the last is not necessarily at N-1.
    // This is because we need to keep it dynamic and change these indexes with enqueue and dequeue operations.
    public QueueArray(int N){
        array = new Element[N];
        first = 0;
        last = 0;
        this.N = N;
    }

    public void printQueue(){
        System.out.println("First");
        int tmp = first;
        while (true){
            System.out.println(array[tmp].data);

            tmp = (tmp + 1) % N;

            if (tmp == last){
                break;
            }
        }
        System.out.println("Last");
    }

    public void printQueueWithDeleted(){

        for (int i = 0; i < N; i++){
            if (array[i] != null){
                System.out.println(array[i].data);

                if (i == first - 1){
                    System.out.println("First");
                }

                if (i == last - 1){
                    System.out.println("Last");
                }
            }
        }
    }

    // The queue is full when the last element comes right before the first element.
    // We need to check if the next element would overwrite the existing data.
    // If N, is one and last is at N-1, when we add an element N is supposed to go one up (to N), exiting the bounds of the array.
    // With the modulo operator, we make sure if wraps around the array. If the first element equals last at that point, it means
    // that the queue is full.
    public boolean isFull(){
        return (first == (last + 1) % N);
    }

    // The queue is empty if the first and last elements point to the same element.
    public boolean isEmpty(){
        return first == last;
    }


    // check to see if the queue is full or not
    // If not full, the element is added to the index of last.
    // Last is incremented by one with the modulo operator.
    public void enqueue(Element newElement){

        if (!isFull()){
            array[last] = newElement;
            last = (last + 1) % N;
        } else
            System.out.println("Queue is full!");
    }

    // We need to return and remove the first element in the queue.
    // First, check if the queue is empty or not. If it is not empty, you return the element at the first index.
    // The first index is modified to be the next element. If first++ does not exceed the bounds of the array, no problem.
    // If it exceeds the bounds, then it should wrap around the array.
    public Element dequeue(){

        Element dequeued = null;

        if (isEmpty()){
            System.out.println("Queue is empty!");
        } else {
            dequeued = array[first];
            first = (first + 1) % N;
        }
        return dequeued;
    }
    //  6 4 5
    // moved = 5
    public void moveToRear(){
        if (isEmpty()){
            System.out.println("Empty queue!");
            return;
        }

        Element moved = dequeue();
        enqueue(moved);
    }

    //      (1)(2)(3)(4)(5)(6)(7)(8)
    // first   4  8  6  3  2  9 2 last  - first 4 6 2
    // external  4 6 2      original 4 6 2
    public void removeOddIndexed(){
        QueueArray external = new QueueArray(N);

        int index = 1;
        while (!isEmpty()){
            if (index % 2 == 0){
                external.enqueue(dequeue());
            } else {
                dequeue();
            }
            index++;
        }

        while (!external.isEmpty()){
            enqueue(external.dequeue());
        }


    }
}
