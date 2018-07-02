
public class Solution1 {
   /*
		Divide and Conquer
		Time O(n)
   */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left, right) + 1;
    }
}



public class Solution2 {
   	/*
		Traverse 
		Time O(n)
   	*/
    int depth = 1;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        help(root,1);
        
        return depth;
    }
    
    private void help(TreeNode root, int curDepth){
        if(root == null){
            return;
        }
        
        if(curDepth > depth){
            depth = curDepth;
        }
        help(root.left, curDepth + 1);
        help(root.right, curDepth + 1);
    }
}