/**
 * https://www.geeksforgeeks.org/problems/geeks-training/1
 */

public class NinjasTraining {

    public int maximumPoints(int arr[][]) {

        int n = arr.length;
        int m = arr[0].length;

        int[] prev1 = arr[0].clone();
        int[] prev2 = prev1.clone();

        for (int day = 1; day < n; day++) {

            prev1 = new int[m];

            for (int task = 0; task < m; task++) {

                int maxi = 0;

                for (int lastTask = 0; lastTask < m; lastTask++) {

                    if (lastTask != task) maxi = Math.max(maxi, prev2[lastTask]);
                }

                prev1[task] = arr[day][task] + maxi;
            }

            prev2 = prev1.clone();
        }

        return Arrays.stream(prev1).max().getAsInt();
    }
}