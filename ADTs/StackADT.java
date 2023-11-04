package ADTs;

public interface StackADT {
    
    public void push(int value);
    /** 
     * pre: value is an integer
     * post: value is added to the top of the stack
     */
    public int removeValue();
    /**
     * pre: stack is not empty
     * post: top value is removed from the stack and returned
     */
    public boolean isEmpty();
    /**
     * returns true if stack is empty, false otherwise
     */

//Temp Code Space-----------------------------------------------------------------------------------
    /*
    public int maxSize;
    public int top;
    public int[] stackArray;
    

    public StackADT(int size);
        maxSize = size
        stackArray = new int[maxSize];
        top = -1;
    

    public void push(int value);
       if (top < maxSize - 1) {
            stackArray[++top] = value;
        } else {
            System.out.println("Stack is full. Can't push " + value);
        } 
    

    public int pop();{
        if (top >= 0) {
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty.");
            return -1;
        }
    }

    public boolean isEmpty(); /*{
        return (top == -1);
    }
    */

}
