package application;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;


import ADTs.*;
public class MyStack implements StackADT, Iterator {

	private int size = 0;
	private int cursor = 0;
	private Object[] originalArray = new Object[size];

	public void push(Object toAdd) throws NullPointerException {
		try {
			Object[] arrayCopy = originalArray;
			originalArray = new Object[size + 1];

			for (int index = 0; index < size() - 2; index++) {
				originalArray[index] = arrayCopy[index];
			}

			originalArray[size() - 1] = toAdd;
			size++;
			}
		catch (NullPointerException error) {
			System.out.println("ERROR");
		}
	}


	public Object pop() throws EmptyStackException {
		try {
			Object poppedValue = 0;
			Object[] arrayCopy = originalArray;
			originalArray = new Object[size() - 1];

			for (int index = 0; index < arrayCopy.length - 1; index++) {
				originalArray[index] = arrayCopy[index];
			}
			poppedValue = arrayCopy[size() - 1];
			return poppedValue;
		}
		catch (EmptyStackException error) {
			return null;
		}
	}

	public Object peek() throws EmptyStackException {
		try {
			return originalArray[size() - 1];
		}
		catch (EmptyStackException error) {
			return null;
		}
	}

	public void clear() {
		size = 0;
		originalArray = new Object[size()];
		
	}


	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		else {
			return false;
		}
	}


	public Object[] toArray() {
		return originalArray;
	}


	public Object[] toArray(Object[] holder) throws NullPointerException {
		try {
			holder = originalArray;
			return originalArray;
		}
		catch (NullPointerException error) {
			return null;
		}
	}


	public boolean contains(Object toFind) throws NullPointerException {
		try {
			boolean valueExisitence = false;
			for (int index = 0; index < size() - 1; index++) {
				if (originalArray[index] == toFind) {
					valueExisitence = true;
				}
				else {
					valueExisitence = false;
				}
			}
			return valueExisitence;
		} 
		catch (NullPointerException error) {
			return false;
		}
	}


	public int search(Object toFind) {
		int distance = 1;
		for (int index = 0; index < size; index++) {
			if (originalArray[index] != toFind) {
				distance++;
			}
			else {
				break;
			}
		}
		return distance;
	}


	public Iterator iterator() {
		// Anonymous inner class implementing the Iterator interface
        return new Iterator() {
            // Cursor to keep track of the current position during iteration
            private int cursor = 0;

            public boolean hasNext() {
                return cursor < size;
            }

            public Object next() {
                if (hasNext()) {
                    return originalArray[cursor++];
                } 
				else {
                    throw new NoSuchElementException();
                }
            }
        };
	}

	public boolean equals(StackADT that) {
		if (this.size == that.size()) {
			return true;
		}
		else {
			return false;
		}
	}

	public int size() {
		return size;
	}

	public boolean hasNext() {
		return cursor < size;
	}

	public Object next() throws NoSuchElementException {
		if (hasNext()) {
			return originalArray[cursor++];
		} else {
			throw new NoSuchElementException();
		}
	}

}
