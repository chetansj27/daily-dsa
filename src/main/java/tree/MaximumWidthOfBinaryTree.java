package tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    /*
        We will use level order traversal to traverse the tree.
        Will assign index to each node starting from root with 0 with formula 2*i+1 for left 2*i+2 for right.
        Max width will be difference of leftmost index and rightmost index.
        To prevent overflow, will take minimum index at present level and subtract it from all indexes of current leve
        then it will be i for left and right.

     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Queue<Pair> queue = new LinkedList<>();
        int res = 0;
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int currMin = queue.peek().index;
            int size = queue.size();
            int leftIndex = 0;
            int rightIndex = 0;
            for (int i = 0; i < size; i++) {
                int currIndex = queue.peek().index - currMin;
                TreeNode temp = queue.peek().root;
                queue.poll();
                if (i == 0)
                    leftIndex = currIndex;
                if (i == size - 1)
                    rightIndex = currIndex;
                if (temp.left != null) {
                    queue.offer(new Pair(temp.left, currIndex * 2 + 1));
                }
                if (temp.right != null) {
                    queue.offer(new Pair(temp.right, currIndex * 2 + 2));
                }
            }
            res = Math.max(res, (rightIndex - leftIndex + 1));
        }
        return res;
    }
}

class Pair {
    TreeNode root;
    int index;

    public Pair(TreeNode root, int index) {
        this.root = root;
        this.index = index;
    }
}
