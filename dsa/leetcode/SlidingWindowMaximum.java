/**
 *  Leetcode 239 | https://leetcode.com/problems/sliding-window-maximum
 */

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        if (n == 0 || k == 0) return new int[]{0};

        int[] res = new int[n - k + 1];

        int ind = 0;

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!q.isEmpty() && q.peekFirst() <= i - k ) q.pollFirst();

            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();

            q.offerLast(i);

            if (i >= k - 1) res[ind++] = nums[peekFirst()];
        }

        return res;
    }
}