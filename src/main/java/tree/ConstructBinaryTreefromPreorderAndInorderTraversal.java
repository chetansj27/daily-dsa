package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderAndInorderTraversal {
    /*
        first element of preorder will be root and to left of root in inorder will be left substree and right will be right subtree.

     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueMap.put(inorder[i], i);
        }
        return prepare(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valueMap);
    }

    public TreeNode prepare(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> valueMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = valueMap.get(root.val);
        int left = inRoot - inStart;
        root.left = prepare(preorder, preStart + 1, preStart + left, inorder, inStart, inRoot - 1, valueMap);
        root.right = prepare(preorder, preStart + left + 1, preEnd, inorder, inRoot + 1, inEnd, valueMap);
        return root;
    }
}
