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
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    /*
       recursive & divide and conquer

    */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new  ArrayList<Integer>();
        if(root == null){
            return results;
        }
        
        // 左右根
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        results.addAll(left);
        results.addAll(right);
        results.add(root.val);
        
        return results;
    }
}