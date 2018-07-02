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
    In order traverse (左根右)
    左>根>右
  */
    int lastVal = Integer.MIN_VALUE;
    boolean firstNode = true;

    public boolean isValidBST(TreeNode root) {
       if (root == null) {
           return true;
       }
       
       if (isValidBST(root.left) == false) {
           return false;
       }

       // pre < cur, and cannot have ==
       if(firstNode == false && lastVal >= root.val){
           return false;
       }
       
       firstNode = false;
       lastVal = root.val;
       
       if(isValidBST(root.right) == false){
           return false;
       }
       
       return true;
    }
}