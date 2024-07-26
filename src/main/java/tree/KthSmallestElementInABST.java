package tree;

public class KthSmallestElementInABST {
    /*
        InOrder traversal of BST will be in sorted order. We can use this property. Will keep a counter to check current level
        if counter == k then return that node
     */
    private static int counter = 0;
    private static int value = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        counter = k;
        traverse(root);
        return value;
    }

    public void traverse(TreeNode root) {
        if (root.left != null)
            traverse(root.left);
        counter--;
        if (counter == 0) {
            value = root.val;
            return;
        }
        if (root.right != null)
            traverse(root.right);
    }
}
