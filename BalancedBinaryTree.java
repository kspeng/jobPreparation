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
    public boolean balanced;
    public int height;
    public ResultType( boolean balanced, int height){
        this.balanced = balanced;
        this.height = height;
    }
}
public class Solution1 {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        ResultType result = helper(root);
        return result.balanced;
    }
    
    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(true, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        if(left.balanced == false || right.balanced == false  ||
        Math.abs(left.height - right.height) > 1){
              return new ResultType(false, -1);
        }
        
        return new ResultType(true, Math.max(left.height, right.height) + 1);
    }
}



public class Solution2 {
    /**
     * divided and conquer
     */
    int NOT_BALANCED = -1;
    public boolean isBalanced(TreeNode root) {
        
       int result = helper(root);    
       return NOT_BALANCED !=  result;
    }
    
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        if(Math.abs(left - right) > 1 || left == -1 || right == -1 ){
            return -1;
        }
        
        return Math.max(left, right) + 1;
        
    }
}





