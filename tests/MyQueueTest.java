package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import application.MyQueue;

public class MyQueueTest {

	MyQueue<String> myQueueTest = new MyQueue<>();

	@Test
	public void testEnqueue() {
		// Enqueue some objects
		myQueueTest.enqueue("Object 1");
		myQueueTest.enqueue("Object 2");
		myQueueTest.enqueue("Object 3");
		myQueueTest.enqueue("Object 4");
		myQueueTest.enqueue("Object 5");

		// Check the size
		assertEquals(5, myQueueTest.size());

		//Print Item(s) in Queue
		System.out.println(myQueueTest.toString());
	}

	@Test
	public void testSize() {
		// Check the size
		assertEquals(5, myQueueTest.size());
	}

	@Test
	public void testDequeue() {
		try {
			// Dequeue an object
			Object dequeued = myQueueTest.dequeue();

			// Check the dequeued object
			assertEquals("Object 1", dequeued);

			// Check the size
			assertEquals(4, myQueueTest.size());
			System.out.println(myQueueTest.toString());
		} catch (Exception e) {
			fail("Queue is empty");
		}
	}

	@Test
	public void testDequeueAll() {
		try {
			// Dequeue all objects
			myQueueTest.dequeueAll();

			// Check the size
			assertEquals(0, myQueueTest.size());
			System.out.println(myQueueTest.toString());
		} catch (Exception e) {
			fail("Queue is empty");
		}
	}
}
