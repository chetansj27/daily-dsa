package tree;

import java.util.Stack;

public class BinarySearchTreeIterator {
}


class BSTIterator {
    /*
        First we will traverse to last left element and put everything in stack.
        For next() will pop from stack and if right exists then repeat 1 step
        For hasNext() return stack isEmpty()
     */
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode temp = stack.pop();
        int val = temp.val;
        temp = temp.right;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}