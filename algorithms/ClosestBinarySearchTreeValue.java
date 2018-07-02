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
    /**
     * O(n) we can optimize to O(h)
     */
    TreeNode solutionNode = null;
    
    public int closestValue(TreeNode root, double target) {
        if(root == null){
            return 0;
        }
        helper(root,target);
        return solutionNode.val;
    }
    
    private void helper(TreeNode root, double target){
        if(root == null){
            return;
        }
        if(solutionNode == null){
             solutionNode = root;
        }
        else if(Math.abs(root.val - target) < Math.abs(solutionNode.val - target) ){
            solutionNode = root;
        }
        
        helper(root.left, target);
        helper(root.right, target);
        
       
        
    }
}