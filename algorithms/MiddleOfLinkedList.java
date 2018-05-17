/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        /*
            Time (O) = n / 2
            Space (1)
        */
        if(head == null){
            return null;
        }
        
        ListNode faster = head.next;
        while(faster != null && faster.next != null){
            head = head.next;
            faster = faster.next.next;
        }
        
        return head;
        
    }
}