class Solution {
    public int rob(TreeNode root) {
        int[] ans = solve(root);
        return Math.max(ans[0], ans[1]);
    }
    public int[] solve(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        int take = root.val + left[1] + right[1];
        int not_take = Math.max(left[0], left[1]) +Math.max(right[0], right[1]);

        return new int[]{take, not_take};
    }
}
