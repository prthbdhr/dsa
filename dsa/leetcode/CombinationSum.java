/**
 * #Leetcode 39 | https://leetcode.com/problems/combination-sum
 */

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        solve(0, nums, new ArrayList<>(), target, res);

        return res;
    }

    private void solve(int i, int[] nums, List<Integer> ds, int target, List<List<Integer>> res) {
        if (i  == nums.length) {
            if (target == 0) {
                res.add(new ArrayList<>(ds));
            }

            return;
        }

        if (nums[i] <= target) {
            ds.add(nums[i]);

            solve(i, nums, ds, target - nums[i], res);

            ds.remove(ds.size() - 1);
        }

        solve(i + 1, nums, ds, target, res);

        return;
    }
}