package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        //return traverse(root, nums);
        Stack<TreeNode> stack= new Stack<>();
        while(true){
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                root = stack.pop();
                nums.add(root.val);
                root = root.right;
            }
        }
        return nums;
    }

    /*public List<Integer> traverse(TreeNode root, List<Integer> nums) {
        if (root != null) {
            traverse(root.left, nums);
            nums.add(root.val);
            traverse(root.right, nums);
        }
        return nums;
    }*/
}
