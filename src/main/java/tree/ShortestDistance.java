package tree;

public class ShortestDistance {
    public static void main(String[] args) {

    }

    public int shortestDistance(TreeNode root, int a, int b) {
        if (root == null) {
            return 0;
        }
        if (root.val > a && root.val > b) {
            return shortestDistance(root.left, a, b);
        } else if (root.val < a && root.val < b) {
            return shortestDistance(root.right, a, b);
        }

        return calculateRootDistance(root, a) + calculateRootDistance(root, b);

    }
    //5 2 1 3
    // 5 12 9 ,21

    public int calculateRootDistance(TreeNode root, int x) {
        if (root.val == x) {
            return 0;
        } else if (root.val > x) {
            return 1 + calculateRootDistance(root.left, x);
        } else {
            return 1 + calculateRootDistance(root.right, x);
        }
    }
}
