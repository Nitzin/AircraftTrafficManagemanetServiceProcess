package airTrafficSystem;

import java.sql.Timestamp ;
import java.util.Random;

public class AirCraft {
	
	public Timestamp enqueueTime; 
	public enum AirCraftSize{
		SMALL(1), LARGE(2);
		private int e_size;
        
		private AirCraftSize(int value) {
			this.e_size = value;
		}
		public int getSizeInt() { return e_size; }
		
		 private static final AirCraftSize[] VALUES = values();
		 private static final int SIZE = VALUES.length;
		 private static final Random RANDOM = new Random();

		  public static AirCraftSize getRandomSize()  {
		    return VALUES[RANDOM.nextInt(SIZE)];
		  }
	}
	
	public enum AirCraftType{
		PASSENGER(2), CARGO(1);
		private int e_type;
        
		private AirCraftType(int value) {
			this.e_type = value;
		}
		public int getTypeInt() { return e_type; }
		
		private static final AirCraftType[] VALUES = values();
		private static final int SIZE = VALUES.length;
		private static final Random RANDOM = new Random();

		public static AirCraftType getRandomType()  {
			return VALUES[RANDOM.nextInt(SIZE)];
		}
	}
	
	AirCraftSize acSize;
	AirCraftType acType;
	
	public AirCraft(AirCraftSize s, AirCraftType t){
        this.acSize=s;
        this.acType=t;
   }
	public AirCraftSize getSize() {
        return acSize;
    }
    
    public void setSize(AirCraftSize acSize)
    {
      this.acSize = acSize;
    }

    public AirCraftType getType() {
        return acType;
    }

    public void setType(AirCraftType acType){
        this.acType = acType;
    }
      
    public Timestamp getTimestamp(){
		return enqueueTime;
    }

    public void setEnqueueTime(Timestamp enqueueTime){
      this.enqueueTime = enqueueTime;
    }
    
    @Override
    public String toString() {
        return acType+"-"+acSize+"-("+enqueueTime+")";
    }	
	
    @Override
    public boolean equals(Object o) {
 
        // If the object is compared with itself then return true  
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of AirCraftQueueNode or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof AirCraft)) {
            return false;
        }
         
        // typecast o to AirCraftQueueNode so that we can compare data members 
        AirCraft c = (AirCraft) o;
         
        // Compare the data members and return accordingly 
        return c.acSize == acSize && c.acType == acType && c.enqueueTime.equals(enqueueTime);
    }
    
/*    public static void main(String[] args) {
    	Timestamp tp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    	AirCraft a = new AirCraft( AirCraftSize.SMALL, AirCraftType.PASSENGER);
    	a.setEnqueueTime(tp);
    	AirCraft b = new AirCraft( AirCraftSize.LARGE, AirCraftType.PASSENGER);
    	b.setEnqueueTime(tp);
    	
    	System.out.println(a.equals(b));
    	return;
    }*/
}
