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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */
class ResultType{
    DoublyListNode first, last;
    
    public ResultType(DoublyListNode first, DoublyListNode last) {
        this.first = first;
        this.last = last;
    }
}

public class Solution {
    /*
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
     // O (二叉树的节点个数 * 每个节点处理的时间)
     // O(N * 1)
    DoublyListNode header = null;
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if(root == null){
            return null;
        }
        
        ResultType result = helper(root);
        return result.first;
    }
    
    private ResultType helper(TreeNode root){
        if(root == null){
            return null;
        }
        
        // 左根右
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        DoublyListNode node = new DoublyListNode(root.val);
        
        ResultType result = new ResultType(null,null);
           if(left == null){
               result.first = node;
           } else {
               result.first = left.first;// passing first 
               left.last.next = node;
               node.prev = left.last;
           }
           
         if(right == null){
             result.last = node;
          } else {
             result.last = right.last;//passing last
             right.first.prev = node; // insert current node 
             node.next = right.first; // insert current node 
         }
         
         return result;
    }
}







