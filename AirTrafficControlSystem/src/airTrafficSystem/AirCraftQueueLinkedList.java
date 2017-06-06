package airTrafficSystem;

import java.util.Calendar;

import airTrafficSystem.AirCraftQueueNode;

public class AirCraftQueueLinkedList {
	protected AirCraftQueueNode firstNode = new AirCraftQueueNode();
	protected AirCraftQueueNode lastNode = new AirCraftQueueNode();
	
	public void enQueue(AirCraftQueueNode x) {
		x.airCraft.setEnqueueTime(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
		if (firstNode.next == null || firstNode.next.equals(lastNode))// list is empty
	    {
	        firstNode.next = x;
	        x.prev = firstNode;
	        x.next = lastNode;
	        lastNode.prev = x;
	    } 
		else {
		    AirCraftQueueNode curr = firstNode.next;
		    while ((!curr.equals(lastNode)) && x.airCraftPriority <= curr.airCraftPriority && x.airCraft.getTimestamp().after(curr.airCraft.getTimestamp())) {
		        curr = curr.next;
		    }
		    AirCraftQueueNode tempCurr = curr;
		    x.next = tempCurr;
		    x.prev = tempCurr.prev;
		    tempCurr.prev.next = x;
		    tempCurr.prev = x;
		}
	}
	
	public AirCraftQueueNode deQueue() {
        if (firstNode.next == null || firstNode.next.equals(lastNode)) {
            return null;
        } else {
            AirCraftQueueNode temp = null;
            temp = firstNode.next;
            firstNode.next = temp.next;
            temp.next.prev = firstNode;
            return temp;
        }
    }

	public StringBuilder printQueue() {
        AirCraftQueueNode temp = null;
        int i = 1;
        
        temp = firstNode.next;
        StringBuilder str = new StringBuilder();
        if(temp != null){
        	 while (!(temp.next == null || temp.equals(lastNode))) {
             	str.append("{"+i+" : "+temp.airCraft.toString()+"}, ");
                 temp = temp.next;
                 i++;
             }
	        if(str.length() == 0){
	        	str.append("Queue is empty");
	        	return str;
	        }else{
	        	return str;
	        }
        }else{
        	str.append("Queue is empty");
        	return str;
       }  
	}
}
