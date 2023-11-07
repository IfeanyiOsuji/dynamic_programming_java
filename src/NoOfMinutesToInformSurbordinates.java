package src;

public class NoOfMinutesToInformSurbordinates {
    public int numOfMinutes(int n, int headID, int [] manager, int [] informTime){
        int max = 0;
        for(int i=0; i< n; i++){
            if(informTime[i] == 0){
                continue;
            }
            max = Math.max(max, dfx(i, manager, informTime));
        }
        return max;
    }

    private int dfx(int emp, int[] manager, int[] informTime) {
        
        if(manager[emp] != -1){
            informTime[emp] += dfx(manager[emp], manager, informTime);
            manager[emp] = -1;
        }

        return informTime[emp];
    }
public static void main(String [] args){
    
}
    
}
