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
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    /*
    1. 如果 A 和 B 都存在 root 下面，return lca(a,b)
    2. 如果只有 a return a
    3. 如果只有 b return b
    4. 如果都不存在 return null
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if(root == null || root == A || root == B){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,A,B);
        TreeNode right = lowestCommonAncestor(root.right,A,B);
        
        
        if(left != null && right != null){
            return root;
        }
        
        if(left != null){
            return left;    
        }
        
        if(right != null){
             return right; 
        }
        
        return null;
    }
}

















