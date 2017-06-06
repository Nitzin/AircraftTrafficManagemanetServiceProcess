package airTrafficSystem;

public class TrafficControlManagement {

	public static void main(String[] args) {

		AirCraftQueueLinkedList trafficQueue = new AirCraftQueueLinkedList();
		AirCraft ac = new AirCraft(AirCraft.AirCraftSize.LARGE,AirCraft.AirCraftType.PASSENGER);
		AirCraft ac1 = new AirCraft(AirCraft.AirCraftSize.SMALL,AirCraft.AirCraftType.CARGO);
		AirCraft ac2 = new AirCraft(AirCraft.AirCraftSize.LARGE,AirCraft.AirCraftType.CARGO);
		
		AirCraftQueueNode acNode = new AirCraftQueueNode(ac);
		AirCraftQueueNode acNode1 = new AirCraftQueueNode(ac1);
		AirCraftQueueNode acNode2 = new AirCraftQueueNode(ac2);
		
		trafficQueue.enQueue(acNode);
		trafficQueue.enQueue(acNode1);
		trafficQueue.enQueue(acNode2);
		trafficQueue.printQueue();
		
		trafficQueue.deQueue();
		System.out.println("+++++++++++++++++++++");
		trafficQueue.printQueue();
		
		trafficQueue.deQueue();
		trafficQueue.deQueue();
		System.out.println("+++++++++++++++++++++");
		trafficQueue.printQueue();
		
		trafficQueue.deQueue();
		
		return;
	}

}
