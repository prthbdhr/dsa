/**
 *  #Leetcode 41 | https://leetcode.com/problems/trapping-rain-water
 */

public class TrappingRainWater {

    public int trap(int[] height) {

        int left = 0, right = height.length - 1;

        int maxLeft = 0, maxRight = 0;

        int total = 0;

        while (left < right) {

            if (height[left] <= height[right]) {

                if (maxLeft > height[left]) total += maxLeft - height[left];

                else maxLeft = height[left];

                left++;
            }

            else {

                if (maxRight > height[right]) total += maxRight - height[right];

                else maxRight = height[right];

                right--;
            }
        }

        return total;
    }
}