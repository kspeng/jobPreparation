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
     1. Find the node with the largest value that SMALLER than target
     2. Find the node with the smallest value that LARGER than or equal to target
  */
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        
        TreeNode low = lowerBound(root,target);
        TreeNode high = highBound(root,target);
        
        if(low == null){
            return high.val;
        }
        if(high == null){
            return low.val;
        }
        if(target - low.val > high.val - target){
            return high.val;
        }
        
        return low.val;
    }
     // find the node with the largest value that smaller than target
    private TreeNode lowerBound(TreeNode root, double target){
        if(root == null){
            return null;
        }
        // that smaller than target, so go to left
        if(root.val > target){
            return lowerBound(root.left,target);
        }
        
        // look for larger node on right side
        TreeNode lowerNode =  lowerBound(root.right, target);
        if(lowerNode != null){
            return lowerNode;
        }
        
        return root;
    }
    
    // find the node with the smallest value that larger than or equal to target
    private TreeNode highBound(TreeNode root, double target){
        if(root == null){
            return null;
        }

        // that larger than or equal to target, so go to right
        if(root.val < target){
            return highBound(root.right, target);
        }
        
        TreeNode highNode =  highBound(root.left, target);
        if(highNode != null){
            return highNode;
        }
        
        return root;
    }
}


// *********************************************
public class Solution2 {
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