package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {
    // Root-Left-Right
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        //return traverse(root, nums);

        return nums;
    }

    public List<Integer> traverse(TreeNode root, List<Integer> nums) {
        if (root != null) {
            nums.add(root.val);
            traverse(root.left, nums);
            traverse(root.right, nums);
        }
        return nums;
    }

    public List<Integer> usingStack(TreeNode root, List<Integer> nums) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return nums;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            nums.add(root.val);
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);

        }
        return nums;
    }
}
