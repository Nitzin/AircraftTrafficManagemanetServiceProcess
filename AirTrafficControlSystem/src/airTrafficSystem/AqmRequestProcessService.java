package airTrafficSystem;

import com.google.gson.Gson;

public class AqmRequestProcessService {
	public AirCraftQueueLinkedList trafficQueue = null;
	String requestType;
	static final String BOOT = "SystemBoot";
	static final String ENQUEUE = "enqueue";
	static final String DEQUEUE = "dequeue";
	
	public AqmRequestProcessService() {
		
	}
	
	public StringBuilder init(){
		if(trafficQueue == null){
			trafficQueue = new AirCraftQueueLinkedList();
		}
		return trafficQueue.printQueue();
	}
	
	public String enqueue(){
		String returnValue = "Quene not intialize";
		AirCraftQueueNode acNode = new AirCraftQueueNode(getAircraftObject());
		if(trafficQueue != null){
			trafficQueue.enQueue(acNode);
			returnValue = trafficQueue.printQueue().toString();
		}
		return returnValue;
	}
	
	public String dequeue(){
		String returnValue = "Quene not intialize";
		if(trafficQueue != null){
			AirCraftQueueNode acNode = trafficQueue.deQueue();
			returnValue =   (acNode == null ? "Queue is empty"  : acNode.airCraft.toString());
		}
		return returnValue;
		
	}
	
	public AirCraft getAircraftObject(){
		 AirCraft ac = new AirCraft(AirCraft.AirCraftSize.getRandomSize(), AirCraft.AirCraftType.getRandomType());
		 return ac;
	}
	
	public final static class Functions {
			 
	        private static Gson gson = new Gson();
	
	/**
	* Convert given object to a json string
	* @param object
	* @return json as String
	*/
	public static String asJSON(Object object){
	      return gson.toJson(object);
	}
	
	/**
	* Convert given json string to an Object of the given class
	* @param json - JSON string
	* @param cl - Object class
	* @return an instance of the given class
	*/
	public static <T> T fromJSON(String json,Class<T> cl){
	      return gson.fromJson(json,cl);
	}

}
 
}
