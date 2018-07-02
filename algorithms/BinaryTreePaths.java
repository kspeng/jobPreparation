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
     * A solution using recursive & divide and conquer. Divide the original problem to 2 sub-problems (left sub-tree and
     * right sub-tree), then merge the result and return.
     *
     * Time complexity: O(n)
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        //出口
        if(root == null){
            return paths;
        }
        // special case for leaf
        if(root.left == null && root.right == null){
            paths.add(""+ root.val);
            return paths;
        }
        
        List<String> left =  binaryTreePaths(root.left);
        List<String> right =  binaryTreePaths(root.right);
        for(String path : left){
            paths.add(root.val+"->"+path);
        }
        
        for(String path : right){
            paths.add(root.val+"->"+path);
        }
        
        return paths;
    }
}