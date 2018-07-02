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
    public int sum, size;
    public ResultType(int sum, int size){
        this.sum = sum;
        this.size = size;
    }
}
public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    ResultType maxType;
    TreeNode maxNode;
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return maxNode;
    }
    
    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(0,0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int sum = left.sum + right.sum + root.val;
        int size =  left.size + right.size + 1;
        // a/b < c/d => a * d < c * b
        // multiple is faster than divide
        if(maxType == null){
            maxNode = root;
            maxType = new ResultType(sum,size);  
        } else if (1.0*sum/size > 1.0*maxType.sum/maxType.size) {
            maxNode = root;
            maxType = new ResultType(sum,size);  
        }
        
        return  new ResultType(sum,size); 
    }
}









