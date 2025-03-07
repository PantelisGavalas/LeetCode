import java.util.Stack;

/**
 * Solution 1 includes Java's pre-existing Stack data structure.
 * Also, a Map could be used to pair open-close Parentheses for faster checking (avoid multiple if statements)
 * */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty() ||
                        (c == ')' && stack.pop() != '(') ||
                        (c == ']' && stack.pop() != '[') ||
                        (c == '}' && stack.pop() != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}


/**
 * Solution 2 includes my implementation of a MyStack data structure.
 * */
class Solution2 {
    public boolean isValid(String s) {
        MyStack myStack = new MyStack(s.length());

        for (char c : s.toCharArray()) {
            // if myStack is empty
            if (myStack.getTop() == -1) {
                // if we try to close Parentheses with empty myStack => false
                if (c == ')' || c == ']' || c == '}') {
                    return false;
                }
                // if we open Parentheses push in myStack
                else {
                    myStack.push(c);
                }
            }
            // else myStack is not empty
            else {
                // if we open Parentheses -> push in myStack
                if (c == '(' || c == '[' || c == '{') {
                    myStack.push(c);
                }
                // if we close Parenthesis make sure we close the same as we last opened
                // if not => false
                // if yes => pop from myStack's top
                else {
                    if (c == ')' && myStack.peek() != '(') {
                        return false;
                    }
                    else if (c == ']' && myStack.peek() != '[') {
                        return false;
                    }
                    else if (c == '}' && myStack.peek() != '{') {
                        return false;
                    }
                    else {
                        myStack.pop();
                    }
                }
            }
        }

        // get myStack's size
        // if not empty => false
        // if empty => true
        return myStack.isEmpty();
    }
}

// Class for our MyStack to use in parsing the Parentheses string
class MyStack {
    public char[] arr;
    public int top;
    public int capacity;

    // constructor
    public MyStack(int size) {
        arr = new char[size];
        top = -1;
        capacity = size;
    }

    // getters and setters
    public char[] getArr() {
        return arr;
    }

    public void setArr(char[] arr) {
        this.arr = arr;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Push to MyStack
    public void push(char x) {
        if (top == capacity - 1) throw new StackOverflowError();
        arr[++top] = x;
    }

    // Pop for MyStack
    public char pop() {
        if (top == -1) throw new RuntimeException("MyStack is empty.");
        return arr[top--];
    }

    // Peek on MyStack's top
    public char peek() {
        if (top == -1) throw new RuntimeException("MyStack is empty.");
        return arr[top];
    }

    // Check if MyStack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}