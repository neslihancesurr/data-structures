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
        for (Element element: this.stack){
            if(element == null){
                System.out.println("null");
            } else {
                System.out.println(element.data);
            }
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
    // 3 9 5 7 4 8 2
    // 2 8 5 7 4 8

    public void removeBottom(){
        StackArray stackArray = new StackArray(N);

        while (!isEmpty()){
            stackArray.push(pop());
            
        }

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




}
