package Stack;

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
        return stack[top];  // returns the element with the top index
    }

    public boolean isFull() {
        // true the top is at the highest index, false if it is not
        return top == (N - 1);
    }

    public boolean isEmpty() {
        // true if top is -1, false if it is not
        return top == -1;
    }

    public void push(Element newElement) {
        if (!isFull()) {
            top++;
            stack[top] = newElement;
        }
    }

    public Element pop() {
        if (!isEmpty()) {
            top--;
            return stack[top + 1];
        } else
            return null;
    }

    // This is a function which takes a string consisting of parenthesis and checks if the parenthesis are balanced.
    // It returns true if the string is null or empty. If not, it takes each '(' in the string and pushes them on a stack.
    // If the char is a ')' it pops one matching parentheses from the stack.
    // If the char is a ')' and the stack is empty it returns false because there is an unmatched closing parenthesis.
    // If the stack is empty, it means the string is balanced.

    public boolean isBalanced(String s) {
        if (s == null || s.isEmpty()) {
            return true; // if the string given is null or empty, we consider it balanced.
        }
// ((()))   )())
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false; // unmatched closing parenthesis
                } else
                    stack.pop(); // pop a matching parenthesis from the stack
            } else return false;
        }
        return stack.isEmpty();
    }

    // Write a function using stacks that determines if a parenthesis sequence
    // is balanced or not. For example the parenthesis sequence ( { ( ) [ { } ] } ( ) ) is balanced,
    // whereas the parenthesis sequence ( } ] ) ( is not.
    // You can assume that the character sequence contains just (, {, [, ), },] characters.

/*    public boolean isBalancedMany(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == stack.pop()) {

            } else return false;
        }

        return stack.isEmpty();
    }*/

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



}
