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
    /*
        Traverse遍历法
        O(n)
        
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root == null){
            return results;
        }
       helper(root, results);
       
       
       return results;
    }
    
    private void helper(TreeNode root,List<Integer> results){
        if(root == null){
            return;
        }
        // 根左右
        results.add(root.val);
        helper(root.left,results);
        helper(root.right,results);
    }
}

public class Solution2 {
     /**
     * A solution using recursive & divide and conquer. Divide the original problem to 2 sub-problems (left sub-tree and
     * right sub-tree), then merge the result and return.
     *
     * Time complexity: O(n)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        // divide
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
       
        // 根左右
        // Conquer
        results.add(root.val);
        results.addAll(left);
        results.addAll(right);
        
       return results;
    }
}

public class Solution3 {
    /**
     * A non-recursive solution use stack.
     * 
     * Time complexity: O(n)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(stack.isEmpty() == false){
            
            TreeNode cur = stack.pop();
            // 根左右
            results.add(cur.val);
            
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    
       return results;
    }
    
}