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
		Object[] newArray = new Object[0];
		originalArray = newArray;
		// seems simple enough to me lol
	}

	public boolean add(int index, Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
		try {
			/**@author Matthew
			 *  we need to use arrays, so that means we cant mutate them.
			 *  thats why we need to use a new array with the size of the og
			 *  plus one, then we save the data of the og to a copy of it.
			 *  now going through it we save all the og data to the new one, 
			 *  leaving the last one empty. this is where we simulate the "add".
			 *  were gonna save the data of that index first, then override the index data
			 *  the new data. after that we simply place the saved copy of the data of
			 *  the index that was selected in the parameter to it. simulating adding a
			 *  new index to the array. finally we take the array and assign it to the new
			 *  array we just created so it's not locked behind the method.
			 */
			Object[] arrayCopy = originalArray;
			Object[] newArray = new Object[size() + 1];
			originalArray = newArray;

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
			Object[] newArray = new Object[size() + 1];
			originalArray = newArray;

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
			Object[] newArray = new Object[originalArray.length + toAdd.size()];
			originalArray = newArray;

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

	@SuppressWarnings("unchecked")
	public E get(int index) throws IndexOutOfBoundsException {
		return (E) originalArray[index];
		// im gonna ask Khosro about this
	}


	public E remove(int index) throws IndexOutOfBoundsException {
		Object[] newArray = new Object[originalArray.length - 1];
		
		for (int jndex = 0, kndex = 0; jndex < newArray.length - 1; jndex++, kndex++) {
			if (jndex != index) {
				newArray[jndex] = originalArray[kndex]; 
			}
			else {
				newArray[jndex] = originalArray[kndex + 1];
				kndex++;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Object remove(Object toRemove) throws NullPointerException {
		try {
			/** @author Matthew
			 *  this is going to cause an error, it calls to remove the first instance.
			 * however this will make it remove all instances. but looking at
			 * the array itself it will only remove one index since we only need to get 
			 * rid of the first instance of that value from @param toRemove
			 */
			Object savedInstance = 0;
			Object[] newArray = new Object[originalArray.length - 1];
			
			for (int index = 0, jndex = 0; index < newArray.length; index++, jndex++) {
				if (originalArray[index] != toRemove) {
					newArray[index] = originalArray[jndex];
				}
				else {
					savedInstance = originalArray[jndex];
					newArray[index] = originalArray[jndex + 1];
					jndex++;
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
			for (int index = 0; index < originalArray.length - 1; index++) {
				if (originalArray[index] == toFind) {
					response = true;
					break;
				}
				else {
					response = false;
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
                } else {
                    throw new NoSuchElementException();
                }
	}
}
