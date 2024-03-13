package data;

public class QueueLineArray {
    public static void main(String args[]) {
        int size = 3;
        ArrayQueue arrQueue = new ArrayQueue(size);
        
        arrQueue.enqueue("A");
        arrQueue.print();
        
        arrQueue.enqueue("B");
        arrQueue.print();

        arrQueue.peek();
        arrQueue.print();
        
        arrQueue.enqueue("C");
        arrQueue.print();
        
        arrQueue.enqueue("D");
        arrQueue.print();

        arrQueue.dequeue();
        arrQueue.print();

        arrQueue.enqueue("E");
        arrQueue.print();
        
        arrQueue.dequeue();
        arrQueue.print();
        
        arrQueue.clear();
        arrQueue.print();

        arrQueue.clear();

        arrQueue.dequeue();
    } 
}

class ArrayQueue {    
    private int front;
    private int rear;
    private int size;
    private String arr[];
 
    public ArrayQueue(int size) {
        front = -1;    
        rear = -1;    
        this.size = size;    
        arr = new String[this.size];    
    }
    
    public boolean isEmpty() {
        return (front == rear);
    }
    
    public boolean isFull() {
        return (rear == this.size - 1);
    }
    
    public void enqueue(String item) {
        if(isFull()) {
            System.out.println("Queue is full");
        } else {             
            arr[++rear] = item; 
        }
    }

    public String dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            System.out.println(arr[front + 1]);
            front = (front + 1) % this.size;
            return arr[front];
        }
    }
    
    public String peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else { 
            System.out.println(arr[front + 1]);
            return arr[front + 1];
        }
    }
    
    public void clear() {
        if(isEmpty()) {
            System.out.println("Queue is already empty");
        } else {
            front = -1;    
            rear = -1;    
            arr = new String[this.size];   
            System.out.println("Queue is clear");
        }
    }
    
    public void print() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
        } 
        else {
            for (int i = front + 1; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}