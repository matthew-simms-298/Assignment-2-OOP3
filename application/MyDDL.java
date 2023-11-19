package application;

public class MyDDL {
	
	MyDDLNode head;
	MyDDLNode tail;
	int size = 0;

	public MyDDL() {
		size = 0;
	}
<<<<<<< HEAD
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
=======
    public void insertAtHead(int data) {
        /**
         * Add a new node to the beginning of the list
         */
        MyDDLNode newNode = new MyDDLNode(data); 

        // Check if the list is empty
        if (head == null) { 
            head = newNode; 
            tail = newNode; 
        } else {
            newNode.next = head; // Set the next pointer of the new node to the current head
            head.previous = newNode; // Set the previous pointer of the current head to the new node
            head = newNode; // Update the head pointer to the new node
        }
        size++; // Increment the size of the list
    }
    
    public void insertAtTail(int data) {
        /**
         * Add a new node to the end of the list
         */
        MyDDLNode newNode = new MyDDLNode(data);

        // Check if the list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // Set the next pointer of the current tail to the new node
            newNode.previous = tail; // Set the previous pointer of the new node to the current tail
            tail = newNode; // Update the tail pointer to the new node
        }
        size++; // Increment the size of the list
    }
    
    public void deleteAtHead() {
        /**
         * Delete the first node of the list
         */
        if (head == null) {
            // List is empty, nothing to delete
            return;
        }
        else{
            // Check if the list has only one node
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next; // Update the head pointer to the next node
                head.previous = null; // Set the previous pointer of the new head to null
            }
            size--; // Decrement the size of the list
        }

    }
    
    public void deleteAtTail() {
        /**
         * Delete the last node of the list
         */
        if (tail == null) {
            // List is empty, nothing to delete
            return;
        }
        else{
            // Check if the list has only one node
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.previous; // Update the tail pointer to the previous node
                tail.next = null; // Set the next pointer of the new tail to null
            }
            size--; // Decrement the size of the list
        }
    }
    
    //Dev Comment -> Not Sure If Needed
    public void display(int data) {
        /**
         * Print items in the list
         */
        MyDDLNode selectedNode = head; // Start from the head node

        //Prints every item in the list using while loop
        while (selectedNode != null) {
            System.out.print(selectedNode.data); // Print the data of the current node
            selectedNode = selectedNode.next; // Move to the next node
        }
>>>>>>> 29599097887180df86b534039918a1152490150b
    }
}
	
    



