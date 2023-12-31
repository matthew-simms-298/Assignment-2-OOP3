package application;
import java.util.NoSuchElementException;

import ADTs.Iterator;
import ADTs.ListADT;


public class MyArrayList<E> implements ListADT<E> , Iterator<E>{
	
	private int size = 0;
	public Object[] originalArray;
	private int cursor = 0;

	// ListADT interface  methods:
	public int size() {
		return size;
	}
	
	public void clear() {
		size = 0;
		originalArray =  new Object[size];
		// seems simple enough to me lol
	}

	public boolean add(int index, Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
		try {
			Object[] arrayCopy = originalArray;
			originalArray = new Object[size() + 1];

			for (int jndex = 0; jndex < originalArray.length - 2; jndex++) {
				originalArray[jndex] = arrayCopy[jndex];
			}

			Object temp = originalArray[index];
			originalArray[originalArray.length - 1] = temp; 
			originalArray[index] = toAdd;
			size++;
			return true;
		}
		catch (NullPointerException error) {
			return false;
		}
		catch (IndexOutOfBoundsException error) {
			return false;
		}
	}

	public boolean add(Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
		try {
			Object[] arrayCopy = originalArray;
			originalArray = new Object[size() + 1];

			for (int index = 0; index < originalArray.length - 2; index++) {
				originalArray[index] = arrayCopy[index];
			}

			originalArray[size() - 1] = toAdd;
			size++;
			return true;
		}
		catch (NullPointerException error) {
			return false;
		}
		catch (IndexOutOfBoundsException error) {
			return false;
		}
	}

	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		try {
			int index = 0;
			Object[] arrayCopy = originalArray;
			originalArray = new Object[originalArray.length + toAdd.size()];

			for (; index < arrayCopy.length - 1; index++) {
				originalArray[index] = arrayCopy[index]; 
			}
			for (; index < toAdd.size() - 1; index++) {
				originalArray[index] = toAdd.get(index);
			}
			size = originalArray.length;
			return true;	
		}	
		catch (NullPointerException error) {
			return false;
		}
	}

	public E get(int index) throws IndexOutOfBoundsException {
		try {
			return (E) originalArray[index];
		}
		catch (IndexOutOfBoundsException error) {
			return null;
		}
	}


	public E remove(int index) throws IndexOutOfBoundsException {
		try {
			Object[] newArray = new Object[originalArray.length - 1];
			Object indexValue = 0;
			
			for (int jndex = 0, kndex = 0; jndex < newArray.length - 1; jndex++, kndex++) {
				if (jndex != index) {
					newArray[jndex] = originalArray[kndex]; 
				}
				else {
					indexValue = originalArray[kndex];
					newArray[jndex] = originalArray[kndex + 1];
					kndex++;
				}
			}
			return (E) indexValue;
		}
		catch (IndexOutOfBoundsException error) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Object remove(Object toRemove) throws NullPointerException {
		try {
			boolean firstInstanceFound = false;
			Object savedInstance = 0;
			Object[] arrayCopy = originalArray;
			originalArray = new Object[originalArray.length - 1];
			
			for (int index = 0, jndex = 0; index < originalArray.length; index++, jndex++) {
				if (arrayCopy[index] != toRemove) {
					originalArray[index] = arrayCopy[jndex];
				}
				else {
					if (firstInstanceFound == true) {
						originalArray[index] = arrayCopy[jndex];
					}
					else {
						firstInstanceFound = true;
						savedInstance = arrayCopy[jndex];
						
						originalArray[index] = arrayCopy[jndex + 1];
						jndex++;
						
					}
				}
			}
			return savedInstance;
		}
		catch (NullPointerException error) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Object set(int index, Object toChange) throws NullPointerException, IndexOutOfBoundsException {
		try {
			originalArray[index] = toChange;
		}
		catch (NullPointerException error) {
			return error.getMessage();
		}
		catch (IndexOutOfBoundsException error) {
			return error.getMessage();
		}
		return null;
	}


	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		else {
			return false;	
		}
	}


	public boolean contains(Object toFind) throws NullPointerException {
		try {
			boolean response = false;

			for (int index = 0; index < originalArray.length; index++) {
				if (originalArray[index] == toFind) {
					response = true;
					break;
				}
			}
			return response;
		}
		catch (NullPointerException error) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public Object[] toArray(Object[] toHold) throws NullPointerException {
		try {
			toHold = originalArray;
			return toHold;
		}
		catch(NullPointerException error) {
			return null;
		}
	}
	
	// am i tweakin' or these almost the same methods?

	public Object[] toArray() {
		return originalArray;
	}

    public Iterator<E> iterator() {
        // Anonymous inner class implementing the Iterator interface
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
	
	// Iterator interface Methods:

	@Override
	public boolean hasNext() {
		return cursor < size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() throws NoSuchElementException {
		if (hasNext()) {
			return (E) originalArray[cursor++];
		} 
		else {
			throw new NoSuchElementException();
		}
	}
}
