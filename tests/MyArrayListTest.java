package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import application.MyArrayList;

public class MyArrayListTest {
	
	public MyArrayList <Object> myArrayList = new MyArrayList();
	
	@Test
	public void testSize() {;
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);

		assertEquals(3, myArrayList.size());
	}
	@Test
	public void testAdd() {
		Object obj = new Object();
		myArrayList.add(obj);
		assertEquals(1, myArrayList.size());
		assertEquals(obj, myArrayList.get(0));

	}
	@Test
	public void testRemove() {
		Object obj = new Object();
		myArrayList.add(obj);
		myArrayList.remove(obj);
		assertEquals(0, myArrayList.size());
	}
	

}
