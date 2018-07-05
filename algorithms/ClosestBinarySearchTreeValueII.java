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
    暴力方法。时间复杂度 O(n)，空间复杂度也是 O(n)

    先用 inorder traversal 求出中序遍历
    找到第一个 >= target 的位置 index
    从 index-1 和 index 出发，设置两根指针一左一右，获得最近的 k 个整数

   */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
       List<Integer> values = new ArrayList<>();
       // get arraylist in asecnding order
       inorder(root, values);
       int i = 0;
       int n = values.size();
       // find the mid pointer
       for(;i < n; i++){
           if(values.get(i) >= target){
               break;
           }
       }
       // at the end case
       if(i >= n){
           return values.subList(n-k, n);
       }
       // two pointer   left target right
       int left = i - 1, right = i;
       List<Integer> results = new ArrayList<>();
       for (int j = 0; j < k; j++){
            if(left >= 0 && (right >= n || target - values.get(left) <  values.get(right) - target)) {
                results.add(values.get(left));
                left--;
            }  else {
                results.add(values.get(right));
                right++;
            }
       }
       return  results;
    } 
    
    
    private void inorder(TreeNode root, List<Integer> values){
        if(root == null){
            return;
        }
        inorder(root.left,values);
        values.add(root.val);
        inorder(root.right,values);
    }
}







