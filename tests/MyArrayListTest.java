package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import application.MyArrayList;

public class MyArrayListTest {
	
	MyArrayList myArrayList = new MyArrayList();
	@Test
	public void testSize() {
		myArrayList.add(10, 0);
	}

}
