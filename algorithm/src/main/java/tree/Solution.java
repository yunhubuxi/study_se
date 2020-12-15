package tree;

class Solution {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left); // 左子节点最大值
        int right = helper(root.right); // 右子节点最大值
        res = Math.max(left + right + root.val, res); //res 已经是 加节点后的最大值
        return Math.max(0, Math.max(left, right) + root.val); // 0 和 左右节点和根节点结合的最大值,交给上层进行计算
    }
}
