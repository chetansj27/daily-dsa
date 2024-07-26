package tree;

public class FlattenBinaryTreeToLinkedList {
    /*
        Will traverse in Right->Left->Root
        Left pointer will be null and Right Pointer should point next node

     */
    TreeNode prev=null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
