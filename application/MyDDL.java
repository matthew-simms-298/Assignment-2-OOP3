package application;

public class MyDDL {
	
	MyDDLNode head;
	MyDDLNode tail;
	int size = 0;

	public MyDDL() {
		size = 0;
	}
    public void insertAtHead(Object data) {
        MyDDLNode newnode = new MyDDLNode(data);
        if(isEmpty()){
            head = newnode;
            tail = newnode;
        } else {
            newnode.next = head;
            newnode.previous = newnode;
            head = newnode;
        }
        size++;
    }
    
    public void insertAtTail(Object data) {
        MyDDLNode newnode = new MyDDLNode(data);
        if(isEmpty()){
            head = newnode;
            tail = newnode;
        } else {
            newnode.previous = head;
            newnode.next = newnode;
            tail = newnode;
        }
        size++;
    }
    
    public void deleteAtHead() {
        if(isEmpty()){
            throw new IllegalStateException("List is empty");
        }
        head = head.next;
        if(head != null){
            head.previous = null;
        }else{
            tail = null;
        }
        size--;
    }
    
    public void deleteAtTail() {
        if(isEmpty()){
            throw new IllegalStateException("List is empty");
        }
        tail = tail.previous;
        if(tail != null){
            tail.previous = null;
        }else{
            head = null;
        }
        size--;
    }
    
    public void display() {

        if(isEmpty()){
            System.out.print("[Empty]");
        }else{
            MyDDLNode current = head;
            while(current != null){
                System.out.print(current + "->");
                current = current.next;
            }
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
	
    



