package application;
import ADTs.Iterator;
import ADTs.ListADT;


public class MyArrayList<E> implements ListADT/*, Iterator*/{
	
	private int size = 0;

	public int size() {
		return size;
	}
	
	public void clear() {
		
	}

	public boolean add(int index, Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
		
		return false;
	}

	public boolean add(Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(ListADT toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove(Object toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object set(int index, Object toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray(Object[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
   
}
