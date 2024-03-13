package data;

//import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;


// 클래스 설명
/* 1. MyQueue 클래스 
 * 		-> main 메소드 실행
 * 2. CustomRegistry
 * 		-> 해시맵을 사용하여, 객체를 넣었다 뺏다함
 * 3. MyNode
 * 		-> MyLinkedList에 들어가는 Node class
 * 4. MyLinkedList
 *		-> MyNode를 사용한 커스텀 LinkedList
 */

public class MyQueue {
	public static void main(String args[]) {
			
			System.out.println("< 큐 : 해시맵이용 링크드 리스트 >");
			// FIFO, 선입선출, 단순하게 구성하자. 인덱스는 나중에.
			MyLinkedList myList = new MyLinkedList();

			//System.out.println(myList.getLength());
			myList.add(new MyNode("안"));
			
			myList.add(new MyNode("녕"));
			
			myList.add(new MyNode("하"));
			
			myList.add(new MyNode("세"));
			
			myList.add(new MyNode("요"));
			
			System.out.println(myList.getValueByIndex(3));
			/*
			System.out.println(myList.getLength());
			System.out.println(myList.peek());
			System.out.println(myList.peek());
			System.out.println(myList.peek());
			System.out.println(myList.peek());
			System.out.println(myList.peek());
			System.out.println(myList.getLength());
			myList.add(new MyNode("다시1"));
			myList.add(new MyNode("다시2"));
			myList.add(new MyNode("다시3"));
			myList.add(new MyNode("다시4"));
			myList.add(new MyNode("다시5"));
			System.out.println(myList.peek());
			*/
	}
}

class CustomRegistry {
    private final Map<Integer, Object> objectRegistry = new HashMap<>();

    // Method to register an object with its hash code
    public void registerObject(Object obj) {
        int hashCode = System.identityHashCode(obj);
        objectRegistry.put(hashCode, obj);
    }

    // Method to retrieve an object using its hash code
    public Object getObject(int hashCode) {
        return objectRegistry.get(hashCode);
    }
}


class MyNode{
	private int myHash;
	private int frontHash;
	private int backHash;
	private int index;
	private String value;
	
	// Constructors
	public MyNode() {
		this.myHash = System.identityHashCode(this);	
	}
	public MyNode(String val) {
		this.myHash = System.identityHashCode(this);
		this.value = val;
	}
	public MyNode(int frontHashCode) {
		this.myHash = System.identityHashCode(this);
		this.frontHash = frontHashCode;
	}
	
	//Methods
	public int getMyHash() {
		return this.myHash;
	}	
	public void setValue(String val) {
		this.value = val;
	}
	public String getValue() {
		return this.value;
	}
	public void setFront(int frontHash) {
		this.frontHash = frontHash;
	}
	public int getFront() {
		return this.frontHash;
	}
	
	public void setBackHash(int hash) {
		this.backHash = hash;
	}
	public int getBackHash() {
		return this.backHash;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getIndex() {
		return this.index;
	}
}

class MyLinkedList{
	int firstHash;
	int lastHash;
	int length = -1;
    CustomRegistry registry = new CustomRegistry();
	
	// Constructor
	public MyLinkedList() {
		
	}
	
	// Methods
	public int getLength() {	
		return length;
	}
	public boolean isEmpty() {
		return (length == -1);
	}
	
	public void add(MyNode current) {
		int currentHash = current.getMyHash();
		
		if(this.firstHash == 0) {
			registry.registerObject(current);
			this.firstHash = currentHash;
			this.lastHash = currentHash;
			current.setIndex(0);
			length++;
		}else {
			// 이전 node
			MyNode before = (MyNode)registry.getObject(lastHash);
			before.setBackHash(currentHash);
			
			// 현재 노드
			registry.registerObject(current);
			current.setFront(lastHash);
			current.setIndex(before.getIndex() + 1);
			this.lastHash = currentHash;
			length++;
		}
	}
	
	public String peek() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			throw new ArrayIndexOutOfBoundsException();
		}
		
		// 뽑을 Node  = last Node 선택
		MyNode peekNode = (MyNode)registry.getObject(firstHash);
		
		if(this.firstHash == this.lastHash) {
			this.firstHash = 0;
			this.lastHash = 0;
			this.length--;
			return peekNode.getValue();
		}else{
			this.firstHash = peekNode.getBackHash();
			String val = peekNode.getValue();
			this.length--;
			return val;
		}	
	}
	
	public String getValueByIndex(int index) {
		//System.out.println("오긴옴1");
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			throw new ArrayIndexOutOfBoundsException();
		}
		
		int hashCodeNow = -1;
		
		hashCodeNow = this.firstHash;
		MyNode currentNode = (MyNode)registry.getObject(this.firstHash);
		
		while(hashCodeNow != lastHash) {			
			
			currentNode = (MyNode)registry.getObject(hashCodeNow);
			//System.out.println("오긴옴2");
			if(currentNode.getIndex()==index) {
				//System.out.println("오긴옴3");
				//System.out.println(currentNode.getValue());
				return currentNode.getValue();
			}
			hashCodeNow = currentNode.getBackHash();
				//System.out.println("current index: " + currentNode.getIndex());
				//System.out.println("hashCodeNow: " + hashCodeNow);
				//System.out.println("lastHash: " + lastHash);
		}
		return "해당 index 없다. 마지막 index :  " + currentNode.getIndex();
	}
}
	

