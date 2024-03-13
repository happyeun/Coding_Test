package data;

public class MyStackClass {
	public static void main(String args[]) {
		int size = 5;
		MyStack stack = new MyStack(size);
		
		stack.push("안");
		stack.push("녕");
		stack.push("하");
		stack.push("세");
		stack.push("요");
		stack.print();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
	}
	
}

class MyStack{
	// 멤버변수
	String[] stackArr;
	int arraySize;
	int top;
	
	// 생성자
	public MyStack(int size) {
		top=-1;
		this.arraySize = size;
		stackArr = new String[arraySize];
		
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == arraySize -1);
	}
	
	public void push(String text){
		if(isFull()) {
			System.out.println("Stack is Full");
			throw new ArrayIndexOutOfBoundsException();
		}
		stackArr[++top] = text;
		System.out.println("top: " + top);
	}
	
	public String pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			throw new ArrayIndexOutOfBoundsException();
		}
		System.out.println(stackArr[top]);
		stackArr[top] = null;
		return stackArr[top--];
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
		}else{
			for(int i =0; i <= top; i++) {
				if(i==top) {
					System.out.println(stackArr[i]);					
				}else {
					System.out.print(stackArr[i] + ", ");					
				}
			}
		}
	}
	//클래스 끝
}
