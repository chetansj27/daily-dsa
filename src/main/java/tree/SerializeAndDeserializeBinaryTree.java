package tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    /*
        Will use level order traversal.
        In serialize -> If found null  will append *  else will append value
        In deserialize -> If found *  do nothing  else will append to left and right to curr
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                res.append("* ");
                continue;
            }
            res.append(curr.val).append(" ");
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return res.toString();


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode curr = queue.poll();
            if (!Objects.equals(values[i], "*")) {
                TreeNode node = new TreeNode(Integer.parseInt(values[i]));
                curr.left = node;
                queue.offer(node);
            }
            if (!Objects.equals(values[++i], "*")) {
                TreeNode node = new TreeNode(Integer.parseInt(values[i]));
                curr.right = node;
                queue.offer(node);
            }
        }
        return root;
    }
}
