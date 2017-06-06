package Junits;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Test;

import airTrafficSystem.AirCraft;
import airTrafficSystem.AirCraft.AirCraftSize;
import airTrafficSystem.AirCraft.AirCraftType;

public class AirCraftTest {

	@Test
	public void airCrafTestEquals() {
		Timestamp tp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    	AirCraft a = new AirCraft( AirCraftSize.LARGE, AirCraftType.PASSENGER);
    	a.setEnqueueTime(tp);
    	AirCraft b = new AirCraft( AirCraftSize.LARGE, AirCraftType.PASSENGER);
    	b.setEnqueueTime(tp);
    	
    	assertTrue(a.equals(b));
    	
    	AirCraft c = new AirCraft( AirCraftSize.LARGE, AirCraftType.CARGO);
    	c.setEnqueueTime(tp);
    	
    	assertFalse(a.equals(c));
	}

}
