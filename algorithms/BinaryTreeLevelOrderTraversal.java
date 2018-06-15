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
     * @return: Level order a list of lists of integer
     */
    /*
      e 是 edge
      树的话
      Time O(e) = O(n)
    */
     public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> results = new ArrayList<>();
       if(root == null){
           return results;
       }
       Queue<TreeNode> queue = new LinkedList<>();
       //1. 所有起点放入quque
       queue.offer(root);
       while(!queue.isEmpty()){
           //2. 根据当前拓展下一层
           List<Integer> curtLevel = new ArrayList<>();
           // take a snapshot
           int size = queue.size();
           for (int i = 0; i < size; i++){
                TreeNode data = queue.poll();
                curtLevel.add(data.val);
                
               if(data.left != null){
                   queue.offer(data.left);
               }
               if(data.right != null){
                   queue.offer(data.right);
               }
           }
           
           results.add(curtLevel);
       }
       
       return results;
  }

}



