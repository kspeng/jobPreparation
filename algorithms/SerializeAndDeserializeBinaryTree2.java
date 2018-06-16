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
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    /*
    Time O(n)
    */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        
        Queue<TreeNode> quque = new LinkedList<>();
        quque.offer(root);
        while(quque.isEmpty() == false){
            int snapshotSize  = quque.size();
            List<Integer> result = new ArrayList<>();
            for(int i = 0; i< snapshotSize; i++){
               TreeNode cur = quque.poll();
               result.add(cur.val);
               
               if(cur.left != null){
                  quque.offer(cur.left); 
               }
               if(cur.right != null){
                  quque.offer(cur.right); 
               }
            }
            
            results.add(result);
        }
        // reverse the sub list order
        Collections.reverse(results);
        
        return results;
    }
}








