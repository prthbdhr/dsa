/**
 * #Leetcode2593 | https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/description
 */

public class FindScoreArrayAfterMarkingAllElements {

    public long findScore(int[] nums) {
        int n = nums.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[0] != b[0] ?
                a[0] - b[0] :
                a[1] - b[1]);

        for (int i = 0; i < n; i++) {
            pq.offer(new int[] {nums[i], i});
        }

        long sum = 0;

        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            int[] cell = pq.poll(
            int val = cell[0];
            int pos = cell[1];

            if (visited[pos]) continue;

            sum += val;

            visited[pos] = true;

            if ((pos - 1) >= 0) visited[pos - 1] = true;

            if ((pos + 1) < n) visited[pos + 1] = true;
        }

        return sum;
    }
}