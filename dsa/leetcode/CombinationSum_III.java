/**
 *  #Leetcode 216 | https://leetcode.com/problems/combination-sum-iii
 */

public class CombinationSum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        solve(1, n, k, new ArrayList<>(), res);

        return res;
    }

    private void solve(int index, int n, int k, List<Integer> ds, List<List<Integer>> res) {

        if (ds.size() == k && n == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i <= Math.min(n, 9); i++) {
            ds.add(i);

            solve(i + 1, n - i, k, ds, res);

            ds.remove(ds.size() - 1);
        }

        return;
    }
}