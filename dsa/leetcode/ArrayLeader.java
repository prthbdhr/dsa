

/*  
    *  #GFG  | https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
 */

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeader {
    
    static ArrayList<Integer> leaders(int arr[]) {
        
        int n = arr.length;

        ArrayList<Integer> res = new ArrayList<>();

        int maxFromRight = arr[n - 1];

        // include the rightmost element as a leader
        res.add(maxFromRight);

        for (int i = n - 2; i >= 0; i--) {

            if (arr[i] >= maxFromRight) {

                res.add(arr[i]);

                maxFromRight = arr[i];
            }
        }

        Collections.reverse(res);
        
        return res;
    }
}
