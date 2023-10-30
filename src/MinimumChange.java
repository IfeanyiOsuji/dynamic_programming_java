package src;

public class MinimumChange {
     int minCoins = Integer.MAX_VALUE;
    public  int minChange(int amount, int []coins){
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        minCoins = -1;
        for(int i=0; i< coins.length; i++){
            int subAmount = amount - coins[i];
            int subCoins = minChange(subAmount, coins);
            if(subCoins != -1){
                int numCoins = subCoins +1;
                System.out.println("numCoins = "+numCoins);
                if(numCoins <= minCoins || minCoins == -1){
                    minCoins = numCoins;
                System.out.println("minCOins = "+minCoins);
                
                }
            }

        }
        return minCoins;
    }
    public static void main(String[] args) {
        System.out.println(new MinimumChange().minChange(10, new int[]{3, 2, 1}));
    }
    
}
