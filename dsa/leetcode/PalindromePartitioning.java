/**
 *  #Leetcode 131 | https://leetcode.com/problems/palindrome-partitioning
 */

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        solve(0, s, new ArrayList<>(), res);

        return res;
    }

    private void solve(int ind, String s, List<String> ds, List<List<String>> res) {
        if (ind == s.length()) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            if (isPalindrome(s, ind, i)) {
                ds.add(s.substring(ind, i + 1));

                solve(i + 1, s, ds, res);

                ds.remove(ds.size() - 1);
            }
        }

        return;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;

            l++;
            r--;
        }

        return true;
    }
}