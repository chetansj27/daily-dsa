package tree;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return findDepth(root);
    }

    public int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findDepth(root.left), findDepth(root.right)) + 1;
    }
}
