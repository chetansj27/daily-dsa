package tree;

public class DeepestLeavesSum {
    /*
           compare level with maxLevel
                if equal then add to sum
                else set sum to value  and update maxLevel to level
     */
    int sum = 0;
    int maxLevel = Integer.MIN_VALUE;

    public int deepestLeavesSum(TreeNode root) {
        calculate(root, 0);
        return sum;
    }

    public void calculate(TreeNode root, int level) {
        if (root == null)
            return;

        if (level > maxLevel) {
            sum = root.val;
            maxLevel = level;
        } else if (maxLevel == level) {
            sum += root.val;
        }
        calculate(root.left, level + 1);
        calculate(root.right, level + 1);
    }
}
