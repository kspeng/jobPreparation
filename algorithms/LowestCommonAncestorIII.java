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

class ResultType {
    public boolean a_exist, b_exist;
    public TreeNode node;
    ResultType(boolean a, boolean b, TreeNode n) {
        a_exist = a;
        b_exist = b;
        node = n;
    }
}
public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */

    /*
        Case {1,#,2,#,3,#,4,#,5}
        lca(3, 5)
        1
         \
          2
           \
            3
             \
              4
               \
                5
        this should return null

    */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        ResultType result = helper(root, A, B);
        if(result.a_exist && result.b_exist){
            return result.node;
        }
        
        return null;
    }
    
    public ResultType helper(TreeNode root, TreeNode A, TreeNode B){
        if(root == null){
            return new ResultType(false, false,  root);
        }
        
        ResultType left  = helper(root.left, A, B);
        ResultType right  = helper(root.right, A, B);
        
        boolean a_exist = left.a_exist || right.a_exist || root == A;
        boolean b_exist = left.b_exist || right.b_exist || root == B;
        
        if(root == A || B == root){
            return new ResultType(a_exist, b_exist,  root);
        }
        if(left.node != null && right.node != null){
            return new ResultType(a_exist, b_exist,  root);
        }
        if(left.node != null){
            return new ResultType(a_exist, b_exist,  left.node );
        }
        if(right.node != null){
            return new ResultType(a_exist, b_exist,  right.node );
        }
        
        return new ResultType(a_exist, b_exist,  null);
    }
}








