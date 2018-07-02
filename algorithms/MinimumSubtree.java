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

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    TreeNode minNode = null;
    int min = Integer.MAX_VALUE;


    public TreeNode findSubtree(TreeNode root) {
        if(root == null){
            return minNode;
        }
        
        help(root);
        return minNode;
    }
    // 1. return root's sum
    private int help(TreeNode root){
        if(root == null){
            return 0;
        }

        // divide + conquer + merge
        int left = help(root.left);
        int right = help(root.right);
        int sum = left + right + root.val;
        
        // 打擂台，遍历 traverse
        if(sum < min){
            min = sum;
            minNode = root;
        }
        
        return sum;
        
        
    }
}







