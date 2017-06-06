package Junits;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Test;

import airTrafficSystem.AirCraft;
import airTrafficSystem.AirCraft.AirCraftSize;
import airTrafficSystem.AirCraft.AirCraftType;
import airTrafficSystem.AirCraftQueueNode;

public class AirCraftQueueNodeTest {

	@Test
	public void equalsMethodTest() {
		AirCraft a = new AirCraft( AirCraftSize.SMALL, AirCraftType.PASSENGER);
		AirCraft b = new AirCraft( AirCraftSize.LARGE, AirCraftType.PASSENGER);
		Timestamp tp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		a.setEnqueueTime(tp);
		AirCraftQueueNode first = new AirCraftQueueNode(a);
		AirCraftQueueNode last = new AirCraftQueueNode(a);
		AirCraftQueueNode node = new AirCraftQueueNode(b);
		
		assertTrue(first.equals(last));
		assertTrue(node.getAirCraftPriority() == 4);
		assertTrue(first.getAirCraftPriority() == 3);
		assertFalse(first.equals(node));
		
	}

}
