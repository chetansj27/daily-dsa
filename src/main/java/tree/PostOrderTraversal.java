package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        //return traverse(root, nums);
        return usingStack(root, nums);
    }

    public List<Integer> traverse(TreeNode root, List<Integer> nums) {
        if (root != null) {
            traverse(root.left, nums);
            traverse(root.right, nums);
            nums.add(root.val);
        }
        return nums;
    }

    public List<Integer> usingStack(TreeNode root, List<Integer> nums) {
        Stack<TreeNode> firstStack = new Stack<>();
        Stack<TreeNode> secondStack = new Stack<>();
        if (root == null)
            return nums;
        firstStack.push(root);
        while (!firstStack.isEmpty()) {
            TreeNode temp = firstStack.pop();
            secondStack.push(temp);
            if (temp.left != null)
                firstStack.push(temp.left);
            if (temp.right != null)
                firstStack.push(temp.right);
        }
        while (!secondStack.isEmpty()) {
            nums.add(secondStack.pop().val);
        }
        return nums;
    }
}
