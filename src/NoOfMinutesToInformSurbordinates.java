package src;

/* Time Needed to Inform All Employees
 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news.
 */

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
System.out.println(new NoOfMinutesToInformSurbordinates().numOfMinutes(15, 0, new int[]{-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6}, new int[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}));

}
    
}
