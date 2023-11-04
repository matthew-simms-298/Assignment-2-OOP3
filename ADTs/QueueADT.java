package ADTs;

public interface QueueADT { 

public void addFrontOfQueue(int item);
// Adds one item to the front of the queue.
public void addEndOfQueue(int item);
// Adds one item to the rear of the queue.
public int removeFrontOfQueue();
// Removes and returns the item at the front of the queue.
public int removeEndOfQueue();
// Removes and returns the item at the rear of the queue.
public boolean isEmpty(); 
// Returns true if the queue is empty, false otherwise.
public int size();
// Returns the number of items in the queue.

}
