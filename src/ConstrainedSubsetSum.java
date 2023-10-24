package src;
import java.util.ArrayDeque;
import java.util.Deque;

public class ConstrainedSubsetSum {

    public static int constrainedSubsetSum(int [] nums, int k){

        int maxSum = nums[0];
        Deque<Integer> maxSumDequeu = new ArrayDeque<>();
        for(int i=0; i< nums.length; i++){
            nums[i]+= !maxSumDequeu.isEmpty() ? maxSumDequeu.peek() : 0;
            maxSum = Math.max(nums[i], maxSum);

            while (!maxSumDequeu.isEmpty() && nums[i] > maxSumDequeu.peekLast()){
                maxSumDequeu.pollLast();

            }
            if(nums[i] > 0){
                maxSumDequeu.offer(nums[i]);
                System.out.println(maxSumDequeu);
            }
            if(i >= k && !maxSumDequeu.isEmpty() && maxSumDequeu.peek() == nums[i-k]){
                maxSumDequeu.poll();
            }

        }
        return maxSum;


    }
    public static void main(String[] args) {
        //System.out.println(findMaxInSubArray(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        //System.out.println(findMaxInSubArray(new int[]{1,3,-1,3,6,7}, 2));
        //System.out.println(constrainedSubsetSum(new int[]{10, 2, -10, 5, 20}, 2));
        //System.out.println(constrainedSubsetSum(new int[]{10, -2, -10, -5, 20}, 2));
        System.out.println(constrainedSubsetSum(new int[]{-10, -2, -10, -1, -20}, 2));

    }

}
