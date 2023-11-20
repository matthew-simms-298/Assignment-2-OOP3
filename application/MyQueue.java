package application;
import java.util.NoSuchElementException;
import exceptions.EmptyQueueException;
import ADTs.*;

public class MyQueue<E> implements QueueADT, Iterator  {

	private int size = 0;
	private int cursor = 0;
	private Object[] originalArray = new Object[size];

	@Override
	public void enqueue(Object toAdd) throws NullPointerException {
		try {
			// Create a new array with increased size
			Object[] newArray = new Object[size + 1];

			// Copy the elements from the old array to the new array
			for (int i = 0; i < size; i++) {
				newArray[i] = originalArray[i];
			}

			// Add the new element to the end of the new array
			newArray[size] = toAdd;
			
			// Update the originalArray reference and size
			originalArray = newArray;
			size++;
		} catch (NullPointerException error) {
			System.out.println("Original Array is empty/null.");
		}
	}

	@Override
	public Object dequeue() throws EmptyQueueException{
		
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is empty.");
		} else {
			Object firstElement = originalArray[0]; // Store the first element in a variable
			// Create a new array with decreased size
			Object[] newArray = new Object[size - 1];
			// Copy the elements from the old array to the new array, excluding the first element
			for (int i = 0; i < size - 1; i++) {
				newArray[i] = originalArray[i + 1];
			}
			// Update the originalArray reference and size
			originalArray = newArray;
			size--;
			return firstElement;
		}
	}

	@Override
	public Object peek() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is empty.");
		}
		return originalArray[0]; // Return the first element in the queue
	}

	@Override
	public void dequeueAll() {
		// Reset the originalArray to an empty array with size 0
		originalArray = new Object[0];
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		else {
			return false;	
		}
	}

	@Override
	public Iterator iterator() {
        return new Iterator<E>() {
            // Cursor to keep track of the current position during iteration
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                if (hasNext()) {
                    return (E) originalArray[cursor++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
	}

	@Override
	public boolean equals(QueueADT that) {
		try{
			if (that == null) {
				return false;
			}
			if (!(that instanceof QueueADT)) {
				return false;
			}
			
			if (this.size() != that.size()) {
				return false;
			}
			for (int i = 0; i < this.size(); i++) {
				if (this.originalArray[i] != that.peek()) {
					return false;
				}
			}
		}
		catch(EmptyQueueException error) {
			System.out.println("Queue is empty.");
		}

		return true;
	}

	@Override
	public Object[] toArray() {
		return originalArray;
	}

	@Override
	public Object[] toArray(Object[] holder) throws NullPointerException {
		try {
			holder = originalArray;
			return holder;
		}
		catch(NullPointerException error) {
			return null;
		}
	}

	@Override
	public boolean isFull() {
		return size == originalArray.length;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean hasNext() {
		return cursor < size;
	}

	@Override
	public E next() throws NoSuchElementException {
		if (hasNext()) {
            return (E) originalArray[cursor++];
        } else {
            throw new NoSuchElementException();
        }
	}

}
