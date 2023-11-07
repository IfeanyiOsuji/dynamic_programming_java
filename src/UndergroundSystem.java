package src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class UndergroundSystem {
   
    Map<Integer, Customer>register;
   
    public UndergroundSystem() {
        register = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
            if(1 <= stationName.length() && stationName.length() <=10){
            Customer customer = new Customer(stationName, t);
            register.put(id, customer);
            }
            //System.out.println("timeIn "+customer.timeIn);
        
    }
    
    public void checkOut(int id, String stationName, int t) {
         if(1<= stationName.length() && stationName.length() <=10){
           Customer customer = register.get(id);
           customer.endStation = stationName;
           customer.timeOut = t;
           if(register.containsKey(id)){
               register.put(id, customer);
           }else{
               register.put(id, new Customer(stationName, stationName, 0, 0));
           }
           
         }
           //System.out.println("timeIn "+customer.timeIn +" timeOut+"+customer.timeOut +" "+customer.startStation +" "+customer.endStation);
            
         
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int start = 0;
        int end = 0;
         int count = 0;
        
       if(register.size() == 0) return 0;
        Iterator i = register.values().iterator();
        while(i.hasNext()){
            Customer customer = (Customer)i.next();
           // System.out.println("timeIn "+customer.timeIn +" timeOut+"+customer.timeOut +" "+customer.startStation +" "+customer.endStation);
            if(customer.startStation != null && customer.startStation.equals(startStation) &&  customer.endStation != null && customer.endStation.equals(endStation) && customer.timeIn > 0){
                int diff = customer.timeOut - customer.timeIn;
                start += diff;
                
                ++count;
            }
            
        }
      //  System.out.println("start "+start);
        
       // System.out.println("count "+count);
        if(count > 0)
        return (start * 1.0) / (count * 1.0);

        return start;   

    }
}

class Customer{
    String startStation;
    String endStation;
    int timeIn;
    int timeOut;
    public Customer(String startStation, String endStation, int timeIn, int timeOut){
        this(startStation, timeIn);
        this.endStation = endStation;
        this.timeOut = timeOut;
    }
      public Customer(String startStation, int timeIn){
        this.startStation = startStation;
        this.timeIn = timeIn;
        
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */