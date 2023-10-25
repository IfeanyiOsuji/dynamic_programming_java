package src;

public class ParkingSystem {
    private int big;
     private int medium;
      private int small;
    public ParkingSystem(int big, int medium, int small) {
        this. big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        switch(carType){
            case 1 : return isAvailable(1);
            case 2 : return isAvailable(2);
            case 3 : return isAvailable(3);
            default : return false;
        }
        
    }

    private boolean isAvailable(int carType){
        
        if(carType ==1 && this.big > 0){
            this.big --;
            //System.out.println(carType);
            return true;
        }
         if(carType ==2 && this.medium > 0){
            this.medium --;
            //System.out.println(carType);
            return true;
        }
         if(carType ==3 && this.small > 0){
            this.small --;
            //System.out.println(carType);
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));

    }
}
