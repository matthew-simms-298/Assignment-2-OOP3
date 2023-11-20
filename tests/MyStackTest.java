package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import application.MyStack;

public class MyStackTest {
	MyStack myStack = new MyStack();

	@Test 
	public void testSizeAndPush() {
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);

		assertEquals(5, myStack.size());
	}

	@Test
	public void testPop() {
		myStack.pop();
		assertEquals(4, myStack.size());
	}

	@Test
	public void testPeek() {
		assertEquals(4, myStack.peek());

		myStack.push(10);
		assertEquals(10, myStack.peek());
	}

	@Test
	public void testContains() {

		assertEquals(true, myStack.contains(3));
		assertEquals(true, myStack.contains(3));
		assertEquals(false, myStack.contains(298));
	}

}
