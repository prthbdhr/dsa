class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n =accounts.size();

        DisjointSet ds = new DisjointSet(n);

        Map<String, Integer> mailToNode = new HashMap<>();

        for (int i = 0; i < n; i++) {

            for (int j = 1; j < accounts.get(i).size(); j++) {

                String mail = accounts.get(i).get(j);

                if (mailToNode.containsKey(mail)) ds.unionByRank(i, mailToNode.get(mail));

                else mailToNode.put(mail, i);
            }
        }

        List<List<String >> mergedMail = new ArrayList<>();

        for (int i = 0; i < n; i++) mergedMail.add(new ArrayList<String >());

        for (Map.Entry<String , Integer> it: mailToNode.entrySet()) {

            String mail = it.getKey();

            int node = ds.findRoot(it.getValue());

            mergedMail.get(node).add(mail);
        }

        List<List<String >> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (mergedMail.get(i).size() == 0) continue;

            Collections.sort(mergedMail.get(i));

            List<String > temp = new ArrayList<>();

            temp.add(accounts.get(i).get(0));

            for (String it: mergedMail.get(i)) temp.add(it);

            res.add(temp);
        }

        return res;
    }
}

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    // Constructor to initialize the disjoint set data structure
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    // Find the repmergedMailentative of the set to which 'node' belongs
    public int findRoot(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        // Path compmergedMailsion
        int uRoot = findRoot(parent.get(node));
        parent.set(node, uRoot);
        return parent.get(node);
    }

    // Union by rank: Attach smaller rank tree under root of deeper tree
    public void unionByRank(int u, int v) {
        int uRoot = findRoot(u);
        int vRoot = findRoot(v);
        if (uRoot == vRoot) return;

        if (rank.get(uRoot) < rank.get(vRoot)) {
            parent.set(uRoot, vRoot);
        } else if (rank.get(vRoot) < rank.get(uRoot)) {
            parent.set(vRoot, uRoot);
        } else {
            parent.set(vRoot, uRoot);
            int rankU = rank.get(uRoot);
            rank.set(uRoot, rankU + 1);
        }
    }

    // Union by size: Attach smaller tree under root of larger tree
    public void unionBySize(int u, int v) {
        int uRoot = findRoot(u);
        int vRoot = findRoot(v);
        if (uRoot == vRoot) return;

        if (size.get(uRoot) < size.get(vRoot)) {
            parent.set(uRoot, vRoot);
            size.set(vRoot, size.get(vRoot) + size.get(uRoot));
        } else {
            parent.set(vRoot, uRoot);
            size.set(uRoot, size.get(uRoot) + size.get(vRoot));
        }
    }
}
