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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */

    /*
    Time O(n)
    */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.isEmpty() == false){
            int size = queue.size();
            ListNode header = new ListNode(0);
            ListNode temp = header;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                temp.next = new ListNode(node.val);
                temp = temp.next;
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            results.add(header.next);
        }
        
        return results;
    }
}














