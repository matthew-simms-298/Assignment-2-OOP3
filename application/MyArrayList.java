package application;
import java.util.NoSuchElementException;
import ADTs.*;

public class MyArrayList implements ListADT/*, Iterator*/ {


    public int size() {
        return 0;
    }


    public void clear() {

    }


    public boolean add(int index, Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
        return false;
    }

    public boolean add(Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
        return false;
    }

    public boolean addAll(ListADT toAdd) throws NullPointerException {
        return false;
    }


    public Object get(int index) throws IndexOutOfBoundsException {
        return null;
    }


    public Object remove(int index) throws IndexOutOfBoundsException {
        return null;
    }


    public Object remove(Object toRemove) throws NullPointerException {
        return null;
    }


    public Object set(int index, Object toChange) throws NullPointerException, IndexOutOfBoundsException {
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
        return false;
    }


    public Object[] toArray(Object[] toHold) throws NullPointerException {
        return null;
    }


    public Object[] toArray() {
        return null;
    }


    public Iterator iterator() {
        return null;
    }
}
