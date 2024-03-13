package data;


class Stack {
    private int top;
    private int[] stackArr;
    private int size;

    // 생성자
    public Stack(int size) {
        top = -1;
        this.stackArr = new int[size];
        this.size = size;
    }

    public boolean isEmpty() {
    	return (top == -1);
    }
    
    public boolean isFull() {
    	return (top == size - 1);
    }
    
    public void push(int val) {
        if (isFull()) {
        	System.out.println("Stack is Full.");
            throw new ArrayIndexOutOfBoundsException();
        }
        stackArr[++top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return stackArr[top--];
    }


    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        }
        else {
            for (int i = 0;  i <= top;  i++) {
                System.out.print(stackArr[i] + " ");
            }
        }
        System.out.println("");
    }
}


public class StackArray {
	public static void main(String[] args) {
		int size = 5;
		Stack stack = new Stack(size);
		stack.printStack();
		stack.push(1);
		stack.printStack();
		stack.push(2);
		stack.printStack();
		stack.push(3);
		stack.printStack();
		stack.push(4);
		stack.printStack();
		stack.push(5);
		stack.printStack();
		stack.push(6);
		stack.printStack();
		/*
		stack.push(1);
		stack.printStack();
		stack.push(2);
		stack.printStack();
		stack.push(3);
		stack.printStack();
		stack.pop();
		stack.printStack();
		 */
	}
}