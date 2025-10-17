/**
 *  #Leetcode 40 | https://leetcode.com/problems/combination-sum-ii
 */

public class CombinationSum_II {

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        solve(0, nums, new ArrayList<>(), target, res);

        return res;
    }

    private void solve(int ind, int[] nums, List<Integer> ds, int target, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < nums.length && nums[i] <= target; i++) {
            if (i > ind && nums[i] == nums[i - 1]) continue;

            ds.add(nums[i]);

            solve(i + 1, nums, ds, target - nums[i], res);

            ds.remove(ds.size() - 1);
        }

        return;
    }
}