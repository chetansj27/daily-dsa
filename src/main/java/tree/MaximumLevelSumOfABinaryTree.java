package tree;

import java.util.*;

public class MaximumLevelSumOfABinaryTree {
    public int levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        if (root == null) {
            return maxSum;
        }
        queue.add(root);
        for (int level = 1; !queue.isEmpty(); level++) {
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                levelSum += current.val;
            }
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}
