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

    void enlarge() {

        if (this.isFull()) {
            for (int i = 0; i < N; i++) {
                this.push(new Element(0));
            }
        }
    }

    boolean isPalindrome(String s) {

        N = s.length();
        StackArray newStack = new StackArray(N);

        for (char c : s.toCharArray()) {
            newStack.push(new Element(c));
        }

        for (char c : s.toCharArray()) {
            Element element = newStack.pop();
            if (c != element.data) {
                return false;
            }
        }

        return true;
    }

    // This method swaps the top 2 elements in a stack.
    public void swapTwo() {

        Element tmptop = pop();
        Element second = pop();
        push(tmptop);
        push(second);
    }

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
