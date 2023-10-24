package src;

import java.util.HashMap;
import java.util.Map;

public class AmountSum {

    public static boolean sumAmount(int a, int [] arr){ // using brute force
        
        if(a==0)
            return true;
        for(int i=0; i< arr.length; i++){
            int subAmount = a- arr[i];
            if(sumAmount(subAmount, arr)){
                    return true;
            }              
        }
        return false;
    }

     public static boolean sumAmount(int a, int [] arr, Map<Integer, Boolean>memo){ // using dynamic programming

         if(a==0)
            return true;
        if(memo.containsKey(a)){
            return memo.get(a);
        }
        for(int i=0; i< arr.length; i++){
            int subAmount = a- arr[i];
           boolean result =  sumAmount(subAmount, arr);
           return result;
                    
                      
        }
        return false;
     }
     public static boolean subAmount1(int a, int [] arr){
        return sumAmount(a, arr, new HashMap<>());
     }


    // public static boolean sumAmount1(int a, int [] arr){
    //     return sumAmount(a, arr) == a ? true : false;
    // }
    public static void main(String[] args) {
        System.out.println(subAmount1(4,new int[]{1, 2, 3}));
    }
}
