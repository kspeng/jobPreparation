/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution1 {

    // recursive & divide and conquer
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> results = new ArrayList();
        if(root == null){
            return results;
        }
        
        // 左根右
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        
        
        results.addAll(left);
        results.add(root.val);
        results.addAll(right);
        
        return results;
    }
}


public class Solution2 {
   /*
        Traverse遍历法
        O(n)
        
    */
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> results = new ArrayList();
        if(root == null){
            return results;
        }
        
        help(root, results);
        return results;
    }
    private void help(TreeNode root, List<Integer> results){
        if(root == null){
            return;
        }
        
        help(root.left, results);
        results.add(root.val);
        help(root.right, results);
        
    }
    
}

public class Solution3 {
    // use stack with no recursion
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 左根右
        
        TreeNode cur = root;
        
        while(stack.isEmpty() == false || cur != null){
            // go to left all the way
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            // visit
            results.add(cur.val);
            // check right branch
            cur = cur.right;
        }
        return results;
    }
}