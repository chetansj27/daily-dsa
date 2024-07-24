package tree;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    boolean validate(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val >= min.val || max != null && root.val <= max.val) return false;
        return validate(root.left, min, root) && validate(root.right, root, max);

    }
}
