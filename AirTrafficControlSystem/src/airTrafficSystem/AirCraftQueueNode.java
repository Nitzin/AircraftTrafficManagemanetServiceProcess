package airTrafficSystem;

public class AirCraftQueueNode {
	
	    protected AirCraftQueueNode next = null;
	    protected AirCraftQueueNode prev = null;
	    protected AirCraft airCraft;
	    protected int airCraftPriority;
	    
	    public AirCraftQueueNode(AirCraft ac) {
	        this.airCraft = ac;
	        this.airCraftPriority  = ac.getSize().getSizeInt() + ac.getType().getTypeInt();
	    }
	    public AirCraftQueueNode() {
	       
	    }

		public AirCraftQueueNode getNext() {
			return next;
		}

		public void setNext(AirCraftQueueNode next) {
			this.next = next;
		}

		public AirCraftQueueNode getPrev() {
			return prev;
		}

		public void setPrev(AirCraftQueueNode prev) {
			this.prev = prev;
		}

		public AirCraft getAirCraft() {
			return airCraft;
		}

		public void setAirCraft(AirCraft airCraft) {
			this.airCraft = airCraft;
		}

		public int getAirCraftPriority() {
			return airCraftPriority;
		}

		public void setAirCraftPriority(int airCraftPriority) {
			this.airCraftPriority = airCraftPriority;
		}
		
		 @Override
		    public boolean equals(Object o) {
		 
		        // If the object is compared with itself then return true  
		        if (o == this) {
		            return true;
		        }
		 
		        /* Check if o is an instance of AirCraftQueueNode or not
		          "null instanceof [type]" also returns false */
		        if (!(o instanceof AirCraftQueueNode)) {
		            return false;
		        }
		         
		        // typecast o to AirCraftQueueNode so that we can compare data members 
		        AirCraftQueueNode c = (AirCraftQueueNode) o;
		         
		        // Compare the data members and return accordingly 
		        return (airCraft.equals(c.airCraft) && c.airCraftPriority == airCraftPriority);
		    }
		 
/*		 public static void main(String[] args) {
			AirCraft a = new AirCraft( AirCraftSize.SMALL, AirCraftType.PASSENGER);
			AirCraftQueueNode first = new AirCraftQueueNode(a);
			AirCraftQueueNode last = new AirCraftQueueNode(a);
			
			System.out.println(first.next.equals(last));
			return;
		 }*/
	    
}
	
