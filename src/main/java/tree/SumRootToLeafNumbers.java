package tree;

public class SumRootToLeafNumbers {
   /*
        Use preorder to traverse the tree.
        everytime multiply value by 10 and add current value
    */

    public int sumNumbers(TreeNode root) {
        return calculate(root, 0);
    }

    public int calculate(TreeNode root, int val) {
        if (root == null)
            return 0;
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return calculate(root.left, val) + calculate(root.right, val);
    }
}

