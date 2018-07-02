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



public class Solution2 {
   /*
        Traverse遍历法
        O(n)
        
    */
    public List<Integer> postorderTraversal(TreeNode root) {
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
        // 左右跟
        helper(root.left,results);
        helper(root.right,results);
        results.add(root.val);
    }
}