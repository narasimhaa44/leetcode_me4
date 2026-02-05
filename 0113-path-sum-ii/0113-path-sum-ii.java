class Solution {

    public void pathhelper(TreeNode root, List<List<Integer>> out, List<Integer> in) {
        if (root == null) return;

        in.add(root.val);

        if (root.left == null && root.right == null) {
            out.add(new ArrayList<>(in));
        } else {
            pathhelper(root.left, out, in);
            pathhelper(root.right, out, in);
        }

        in.remove(in.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> in = new ArrayList<>();

        if (root == null) return out;

        pathhelper(root, out, in);

        Iterator<List<Integer>> it = out.iterator();
        while (it.hasNext()) {
            List<Integer> inn = it.next();
            int sum = 0;
            for (int p : inn) sum += p;
            if (sum != targetSum) it.remove();
        }

        return out;
    }
}
