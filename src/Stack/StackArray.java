package Stack;

import Basics.Element;

import java.util.Stack;

public class StackArray {
    Element[] stack;
    int top;  // the index showing the top element
    int N;    // the length of the stack array

    public StackArray(int N) {
        stack = new Element[N];
        this.N = N;
        top = -1;
    }

    Element top() {
        return stack[top];
    }

    public boolean isFull() {
        return top == (N - 1);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(Element newElement) {
        if (!isFull()) {
            top++;
            stack[top] = newElement;
        }
    }

    public Element pop(){
        if (!isEmpty()) {
            top--;
            return stack[top + 1];
        } else
            return null;
    }

    public void printStack(){
        int topIndex = top;

        while (topIndex > -1){
            if(stack[topIndex] == null){
                System.out.println("null");
            } else {
                System.out.println(stack[topIndex].data);
            }

            topIndex--;
        }
    }

    // Exercise 2
    // This method does not work with our self-made library.
    // It creates a stack from java.util.
    public static boolean isBalanced(String sequence){

        Stack<Character> stack = new Stack<>();

        for (char punct : sequence.toCharArray()){
            if (punct == '('){
                stack.push(punct);
            } else if (punct == ')'){
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    // Exercise 3
    public static boolean isBalancedAll(String sequence){
        Stack<Character> stack = new Stack<>();

        for (char punct : sequence.toCharArray()){
            if (punct == '(' || punct == '{' || punct == '['){
                stack.push(punct);
            } else if (punct == ')' || punct == '}' || punct == ']' ) {
                if (stack.isEmpty()){
                    return false;
                }
            Character topElement = stack.pop();
                if ((punct == ')' && topElement != '(') ||
                        (punct == '}' && topElement != '{') ||
                        (punct == ']' && topElement != '[')
                   ){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // Exercise 4
    public void enlarge() {
        if (!isFull()){
            System.out.println("Stack is not full. It cannot be enlarged!");
            return;
        }
        // store components in a separate array
        StackArray tempStack = new StackArray(N);
        for (int i = 0; i < N; i++){
            tempStack.push(this.pop());
        }
        // enlarge the original stack
        N = N * 2;
        top = 0;
        stack = new Element[N];

        // put back the old elements
        for (int i = 0; i < tempStack.N; i++){
            this.push(tempStack.pop());
        }
    }

    // Exercise 5
    boolean isPalindrome(String word) {

        N = word.length();
        StackArray newStack = new StackArray(N);

        for (char c : word.toCharArray()) {
            newStack.push(new Element(c));
        }

        for (char c : word.toCharArray()) {
            Element element = newStack.pop();
            if (c != element.data) {
                return false;
            }
        }

        return true;
    }

    // Exercise 6
    public void swapTopTwo() {
        Element top = pop();
        Element second = pop();
        push(top);
        push(second);
    }

    // Exercise 7
    public Element bottom(){
        StackArray newArray = new StackArray(N);

        while (!this.isEmpty()){
            newArray.push(pop());
        }

        int topIndex = newArray.top;
        Element topElement = newArray.stack[topIndex];

        while (!this.isEmpty()){
            this.push(newArray.pop());
        }

        return topElement;
    }

    // Exercise 9 - not allowed to use pop(), push()
    public int multiply(){
        if (isEmpty() || top == 0){
            System.out.println("Insufficient number of elements for multiplication.");
            return 0;
        }

        Element topElement = stack[top];
        top--;
        Element beforeTop = stack[top];
        top--;

        return topElement.data * beforeTop.data;
    }

    // Exercise 10 - only use pop, push and isEmpty
    // original  9 5 7 4 8 2
    // external
    public void removeBottom(){
        StackArray externalStack = new StackArray(N);
        int topIndex = top;
        int count = 0;

        while (count < topIndex){
            externalStack.push(this.pop());
            count++;
        }
        // pop the bottom one and don't keep it
        pop();

        // put the rest back in the original stack
        while (!externalStack.isEmpty()){
            this.push(externalStack.pop());
        }
    }

    // Exercise 11 - not allowed to use push and pop
    // 3  9  5  7  4  8  2       top = 6
    // 3  9  5  7  4  8  2
    public StackArray copy(){
        StackArray stackArray = new StackArray(N);

        int count = 0;
        while (count <= top){
            stackArray.stack[count] = stack[count];
            count++;
        }
        stackArray.top = top;

        return stackArray;
    }

    // Exercise 12
    // 4 5 6 7 8     -  4 4 5 5  66
    public void doubleStack(){

        if (isEmpty()){
            N = N * 2;
            stack = new Element[N];
            return;
        }

        Element topElement = pop();

        doubleStack();

        push(topElement);
        push(topElement);
    }

    // Exercise 13 - only use pop, push and isEmpty
    // 5 6 7 8 9 10 11    11 10 9
    public void removeMiddle() {
        StackArray stackArray = new StackArray(N);

        // if the top is at an even index, then there odd number of elements.
        // if top is odd then we have even number of elements, which we don't want.
        if (top % 2 != 0) {
            System.out.println("The stack has even number of elements.");
            return;
        }

        // find how many elements to extract 3
        int deletedIndex = top / 2;

        int count = 0;
        while (count < deletedIndex){
            stackArray.push(pop());
            count++;
        }
        // pop the element to be deleted
        pop();

        while (!stackArray.isEmpty()){
            push(stackArray.pop());
        }
    }

    //Exercise 14
    public void removeBottomK(){


    }
    // Exercise 19
    public void pushK(int k, int data){
       if (k == 1){
           this.push(new Element(data));
           return;
       }

       Element topElement = this.pop();
       pushK(k-1, data);
       this.push(topElement);
    }

    //Write a static method using an external stack (only one external stack
    //is allowed) that determines if an integer array is balanced or not. A
    //number k less than 10 is balanced with the number 10+k. For example,
    //the array 2, 3, 13, 12, 4, 14 is balanced, whereas 5, 15, 4, 3, 14, 13 not.
    //You are not allowed to use any stack attributes such as N, top, array
    //etc. Write the method in array implementation.
    // 5, 15, 4, 3, 14, 13 array
    // 4  stack

    public static boolean isBalanced(int [] a){
        StackArray externalStack = new StackArray(a.length);

        for (int number : a){

            if (number < 10){
                externalStack.push(new Element(number));
            } else if (externalStack.isEmpty()) {
                return false;
            } else {
                Element topElement = externalStack.pop();
                if (number - 10 != topElement.data){
                    return false;
                }
            }
        }
        return externalStack.isEmpty();
    }

    public void insertAfterLargest(int s){
        int largest = stack[top].data;
        int indexOfLargest = 0;


        for (int i = top; i >= 0; i--){
            int currentData = stack[i].data;

            if (currentData > largest){
                largest = currentData;
                indexOfLargest = i;
            }
        }

        for (int i = top; i > indexOfLargest; i--){
            stack[i + 1] = stack[i];
        }

        top++;
        stack[indexOfLargest + 1].data = s;

    }
}

