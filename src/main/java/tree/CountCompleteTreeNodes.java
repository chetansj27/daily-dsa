package tree;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        if (leftHeight == rightHeight)
            return (1 << leftHeight) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int leftHeight(TreeNode leftNode) {
        int height = 0;
        while (leftNode != null) {
            height++;
            leftNode = leftNode.left;
        }
        return height;
    }

    public int rightHeight(TreeNode rightNode) {
        int height = 0;
        while (rightNode != null) {
            height++;
            rightNode = rightNode.right;
        }
        return height;
    }
}
