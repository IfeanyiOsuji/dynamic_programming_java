package src;

import java.util.HashMap;
import java.util.Map;

public class FibonacchiSequence {
    public static int fib(int n, Map<Integer, Integer>memo){
        if(n ==0 || n==1){
            return n;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int result = fib(n-1, memo) + fib(n-2, memo);
        memo.put(n, result);

        return result;
    }
    public static int fib(int n){
        return fib(n, new HashMap<>());
    }

    public static int trib(int n){
        return trib(n, new HashMap<>());
    }
    private static int trib(int n, Map<Integer, Integer>memo){
        if(n==0 || n== 1){
            return 0;
        }
        if(n==2)
            return 1;
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int result = trib(n-1, memo) + trib(n-2, memo)+trib(n-3, memo);
        memo.put(n, result);

        return result;
    }

    


    public static void main(String[] args) {
        //System.out.println(fib(1000));

        System.out.println(trib(3));
        
    }
}
