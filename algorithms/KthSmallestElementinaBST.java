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
        Time = (N)
        Space = k

        use in order traverse
        (BST property, in-order is ascending order)


    */
     
    List<Integer>order = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k < 0){
            return 0;
        }
        
        helper(root, k);
        if(order.size() >= k){
            return order.get(k-1);
        }
          return 0;
    }
    
    private void helper(TreeNode root, int k){
        if(root == null || order.size() >= k){
            return;
        }
        // in order , 左跟右
        helper(root.left, k);
        order.add(root.val);
        helper(root.right, k);
        
        
    }
}









