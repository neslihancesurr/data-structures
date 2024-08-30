package Queue;

import Basics.Element;

public class QueueArray {
    /* The element objects are stored in a static array.
       One integer points to the first element (first) and another points to the node after the last element (last).
       We also create and int to store the total number of elements.
    */
    Element[] array;
    int first;
    int last;
    int N;

    public QueueArray(int N){
        // When first created with no elements, the first and last elements are equal to 0.
        // The first element does not necessarily start from the 0th index and the last is not necessarily at N-1.
        // This is because we need to keep it dynamic and change these indexes with enqueue and dequeue operations.

        array = new Element[N];
        first = 0;
        last = 0;
        this.N = N;
    }

    public boolean isFull(){
        // The queue is full when the last element comes right before the first element.
        // We need to check if the next element would overwrite the existing data.
        // If N, is one and last is at N-1, when we add an element N is supposed to go one up (to N), exiting the bounds of the array.
        // With the modulo operator, we make sure if wraps around the array. If the first element equals last at that point, it means
        // that the queue is full.

            return (first == (last + 1) % N);
    }

    public boolean isEmpty(){
        // The queue is empty if the first and last elements point to the same element.

        return first == last;

    }
    public void enqueue(Element newElement){
        // check to see if the queue is full or not
        // If not full, the element is added to the index of last.
        // Last is incremented by one with the modulo operator.

        if (!isFull()){
            array[last] = newElement;
            last = (last + 1) % N;
        } else
            throw new IllegalStateException("Queue is full!");
    }

    public Element dequeue(){
        // We need to return and remove the first element in the queue.
        // First, check if the queue is empty or not. If it is not empty, you return the element at the first index.
        // The first index is modified to be the next element. If first++ does not exceed the bounds of the array, no problem.
        // If it exceeds the bounds, then it should wrap around the array.
        Element dequeued;

        if (isEmpty()){
            throw new IllegalStateException("Queue is empty!");
        } else {
            dequeued = array[first];
            first = (first + 1) % N;
        }
        return dequeued;
    }


}
