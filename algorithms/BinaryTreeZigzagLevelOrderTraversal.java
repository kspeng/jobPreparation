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
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /*
            Time O(n)
        */
        List<List<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isEven = true;
        while(queue.isEmpty() == false){
            int size = queue.size();
            List<Integer> result = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                result.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            
            if(isEven == false){
                // reverse the list
                Collections.reverse(result);
            }
            isEven = !isEven;
            results.add(result);
        }
        return results;
    }
}








