class Solution {

    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();

        solve (0, 0, n, new StringBuilder(), res);

        return res;
    }

    private void solve(int op, int cl, int n, StringBuilder ds, List<String> res) {

        if (ds.length() == 2 * n) {

            res.add(ds.toString());

            return;
        }

        if (op < n) {

            ds.append("(");

            solve (op + 1, cl, n, ds, res);

            ds.deleteCharAt(ds.length() - 1);
        }

        if (cl < op) {

            ds.append(")");

            solve (op, cl + 1, n, ds, res);

            ds.deleteCharAt(ds.length() - 1);
        }
    }
}