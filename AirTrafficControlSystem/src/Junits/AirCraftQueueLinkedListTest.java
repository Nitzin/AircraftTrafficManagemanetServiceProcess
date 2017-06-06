package Junits;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Test;

import airTrafficSystem.AirCraft;
import airTrafficSystem.AirCraftQueueLinkedList;
import airTrafficSystem.AirCraftQueueNode;
import airTrafficSystem.AirCraft.AirCraftSize;
import airTrafficSystem.AirCraft.AirCraftType;

public class AirCraftQueueLinkedListTest {

	@Test
	public void test() {
		AirCraftQueueLinkedList queue = new AirCraftQueueLinkedList();
		
		assertTrue(queue.printQueue().toString().equals("Queue is empty"));
		
		AirCraft a = new AirCraft( AirCraftSize.SMALL, AirCraftType.PASSENGER);
		Timestamp tp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		a.setEnqueueTime(tp);
		AirCraftQueueNode node = new AirCraftQueueNode(a);
		
		queue.enQueue(node);
		assertFalse(queue.printQueue().toString().equals("Queue is empty"));
		
		queue.deQueue();
		assertTrue(queue.printQueue().toString().equals("Queue is empty"));		
	}
}
