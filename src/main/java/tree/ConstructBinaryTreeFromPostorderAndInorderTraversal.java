package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostorderAndInorderTraversal {
    /*
     last element of postorder will be root and to left of root in inorder will be left substree and right will be right subtree.

  */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueMap.put(inorder[i], i);
        }
        return prepare(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, valueMap);
    }

    public TreeNode prepare(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> valueMap) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = valueMap.get(root.val);
        int left = inRoot - inStart;
        root.left = prepare(inorder, inStart, inRoot - 1, postorder, postStart, postStart + left - 1, valueMap);
        root.right = prepare(inorder, inRoot + 1, inEnd, postorder, postStart + left, postEnd - 1, valueMap);
        return root;
    }
}
