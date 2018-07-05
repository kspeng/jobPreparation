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
    /*
        Pre-order
        

    */
    TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        
        // 根左右
        if(lastNode != null){
           lastNode.left = null; //剪支
           lastNode.right = root;
        }
        // 链接
        lastNode = root;
        TreeNode right = root.right;
        TreeNode left = root.left;
         
        flatten(left);
        flatten(right);
    }
}